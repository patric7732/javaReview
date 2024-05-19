package com.example.aopexam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String doSomething(){
        // 핵심 관심, target
        System.out.println("SimpleService doSomthing run");
        return "Doing somthing";
    }

    public void hello() {
        System.out.println("hello method ::::");
        // afterThrowing 테스트
//        if (1==1){
//            throw new RuntimeException();
//        }
    }

    public void setName(String name){
        System.out.println("setName() method run :::::");
    }
}
