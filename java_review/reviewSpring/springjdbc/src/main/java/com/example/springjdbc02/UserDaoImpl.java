package com.example.springjdbc02;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createAndUpdateUser(String name, String email, String newEmail) {
        jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
// Introduce an error to test transaction rollback
        if (newEmail.contains("error")) {
            throw new RuntimeException("Simulated error");
        }
        jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", newEmail, name);
    }
}

