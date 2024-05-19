package com.example.springjdbc08;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Springjdbc08Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc08Application.class, args);

    }

    @Bean
    public CommandLineRunner run(UserDao userDao){
        return args -> {
            User user = new User();
            user.setName("Hi");
            user.setEmail("hi@exam.com");

            User resultUser = userDao.insertUser(user);

            System.out.println(resultUser.getId());
        };
    }


}
