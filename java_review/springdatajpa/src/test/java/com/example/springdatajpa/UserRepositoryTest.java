package com.example.springdatajpa;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void save(){
        User user = new User("kim", "kim@exma.com");
        repository.save(user);

        System.out.println(user.getId());
    }

    @Test
    void findByName(){
        List<User> users = repository.findByName("kang");
        assertThat(users.size()).isEqualTo(4);


        List<User> users2 = repository.findByName("kim");
        assertThat(users2.size()).isEqualTo(1);

    }

    @Test
    void updateUserEmail(){
        repository.updateUserEmail(3L, "new_patric@exam.com");

        Optional<User> user = repository.findById(3L);
        assertThat(user.get().getEmail()).isEqualTo(3);

    }

    @Test
    void deleteByEmail(){
        int count = repository.deleteByEmail("jeon@exam.com");
        System.out.println(count);
//        assertThat(count).isEqualTo(1);
    }
}