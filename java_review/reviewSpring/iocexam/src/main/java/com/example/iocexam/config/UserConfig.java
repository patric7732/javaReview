package com.example.iocexam.config;

import com.example.iocexam.controller.UserController;
import com.example.iocexam.dao.UserDao;
import com.example.iocexam.dao.UserDaoImpl;
import com.example.iocexam.service.UserService;
import com.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.iocexam")
public class UserConfig {

//    // IOC 컨테이너에 Bean을 등록하는 방법을 생각해보고 동작 될 수 있도록 작성
//    // 1. javaconfig를 이용해서 동작되도록
//    @Bean
//    public UserDao userDao() {
//        return new UserDaoImpl();
//    }
//
//
//    // Settter로 주입
//    @Bean
//    public UserService userService(UserDao userDao){
//        UserServiceImpl userService = new UserServiceImpl();
//        // userDao 값을 넣어주는 setter 메서드 필요.
//        userService.setUserDao(userDao);
//        return userService;
//    }
//
//    // 생성자로 주입
////    @Bean
////    public UserService userService(UserDao userDao){
////        return new UserServiceImpl(userDao); // user Dao를 인자로 받는 생성자
////    }
//
//    @Bean
//    public UserController userController(UserService userService) {
//        return new UserController(userService);
//    }





    // 2. componentScan 을 이용해서 작동되도록, 코드를 완석해보기.


}
