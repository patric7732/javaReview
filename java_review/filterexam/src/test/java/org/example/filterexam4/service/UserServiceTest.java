package org.example.filterexam4.service;

import org.example.filterexam4.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Commit // 테스트 메서드 완료 후 롤백 방지
    void registerUserTest() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");
        user.setName("TestUser");
        user.setEmail("test@example.com");

        User registeredUser = userService.registerNewUser(user);

        assertNotNull(registeredUser.getId());
    }
}
