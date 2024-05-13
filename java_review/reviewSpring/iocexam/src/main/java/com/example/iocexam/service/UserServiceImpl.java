package com.example.iocexam.service;

import com.example.iocexam.dao.UserDao;
import com.example.iocexam.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
@Repository
public class UserServiceImpl implements UserService{
    // 회원가입을 하려면 DAO가 필요함, DAO의 인스턴스가 저장되어야 있어야 하니까..
    @Autowired
    private UserDao userDao; // 필드 기반 주입

    // 생성자 주입
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }


    // 설정자 주입
//    @Autowired // componentScan으로 생성자 안하고 설정자로 주입받고 싶을 시에, 기본적으로 생성자를 통해 주입하기 떄문에
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void joinUser(User user) {
        // 회원가입을 위한 비즈니스 코드가 작성되어야함.

        // 회원가입을 위한 비즈니스가 수행되면, 해당 데이터를 저장하는 코드가 실행
        userDao.addUser(user);
    }
}
