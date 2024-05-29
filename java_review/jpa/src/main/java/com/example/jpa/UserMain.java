package com.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j // 이걸 붙이면 따로 logger를 설정 안해도 됨
public class UserMain {
//    private static final Logger log = LoggerFactory.getLogger(UserMain.class);
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

//        // findUser()
//        log.info("================ fiunUser() =================");
//        User findUser = userDAO.findUser(1L);
//        log.info("Found user : {}", findUser.getName());
//
//        User findUser2 = userDAO.findUser(1L);
//        if (findUser == findUser2){
//            log.info("findUser == findUser2");
//        } else{
//            log.info("findUser != findUser2");
//        }

        // user create
//        UserDAO userDAO = new UserDAO();
//
//        User patricUser = new User("johnnase", "john@gmail.com");
//
//        userDAO.createUser(patricUser);
//
//        log.info("Create user : " + patricUser.getName());
//        log.info("user email :  {}", patricUser.getEmail());

        // user update
        User user = new User();
        user.setId(1L);
        user.setName("patric55");
        user.setEmail("patric@gmail.com");

        userDAO.updateUser(user);
    }
}
