package com.example.springjdbc03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springjdbc03Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc03Application.class, args);

    }

    @Bean
    public CommandLineRunner demo(UserService userService) {
        return args -> {
            // 다른 실행 부분 처리 필드
            try {
                userService.executeComplexBusinessProcess("John", "John@exam.com");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
