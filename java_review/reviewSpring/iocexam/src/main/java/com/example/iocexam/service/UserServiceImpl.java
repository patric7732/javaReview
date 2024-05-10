package com.example.iocexam.service;

import com.example.iocexam.dao.UserDao;
import com.example.iocexam.domain.User;

public class UserServiceImpl implements UserService{
    // 회원가입을 하려면 DAO가 필요함, DAO의 인스턴스가 저장되어야 있어야 하니까..
    private UserDao userDao;


    @Override
    public void joinUser(User user) {
        // 회원가입을 위한 비즈니스 코드가 작성되어야함.

        // 회원가입을 위한 비즈니스가 수행되면, 해당 데이터를 저장하는 코드가 실행
        userDao.addUser(user);
    }
}
