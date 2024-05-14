package com.example.jdbc02;

import com.example.jdbc02.dao.User;
import com.example.jdbc02.dao.UserDao;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJDBC2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            // Insert
//            userDao.insertUser(new User(null,"hong", "hong@gmail.com"));

            // read
            List<User> users = userDao.findAllUsers();
            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));

//            for (User user : users) {
//                System.out.println(user);
//            };

            // update

        };
    }
}
