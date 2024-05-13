package com.example.iocexam;

import com.example.iocexam.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication  // 이 애노테이션이 기본적으로 ComponentScan을 가지고 있음
public class IocexamApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IocexamApplication.class, args);
        UserController userController = context.getBean(UserController.class);
        userController.joinUser();
    }

}
