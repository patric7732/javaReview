package com.example.aopexam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    // 리턴 타입이 상관없을 떄에는 * 사용
    // 패키지 안에 있는 모든 메서드가 실행될때 실행, *뒤에
    @Pointcut("execution(* com.example.aopexam.*.*(..))")
    public void pc() {
    }

    @Pointcut("execution(* hello())")
    public void pc2() {
    }


    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before :::::::::: " + joinPoint.getSignature().getName());
    }

    @After("pc2()")
    public void after() {
        System.out.println("After :::::::::: ");
    }

    @AfterReturning(pointcut = "execution(String com.example.aopexam.*.*(..))", returning = "result")
    public void afterReturningServiceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("After method: " + joinPoint.getSignature().getName() + ", return value: " + result);
    }

    @Before("execution(* setName(..))")
    public void beforeName(JoinPoint joinPoint) {
        System.out.println("beforeName::::::::::::::    ");
        System.out.println("method name ::::: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("::::::::::: 인자 --> " + obj);
        }
    }

    @AfterThrowing(value = "pc2()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("AfterThrowing ###################");
        System.out.println("exception value :: " + ex);
    }

    @Around("pc()")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around run :::::::::::::: 실제 호출된 메서드가 실행되기 전에 할일 구현");
        String value = (String) pjp.proceed(); // 실제 target 메서드를 호출

        System.out.println("Around run :::::::::::::: 실제 호출된 메서드가 실행된 후에 할일 구현");
        value += "  patric aop run::";
        return value;
    }

}
