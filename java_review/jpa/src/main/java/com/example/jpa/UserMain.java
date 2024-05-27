package com.example.jpa;

public class UserMain {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User patricUser = new User("patric", "patric@gmail.com");

        userDAO.createUser(patricUser);
    }
}
