package com.example.jdbc02.dao;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {
    // JDBCTemplate 객체 이용해서 구현
    // 필드기반, 필드기반은 지양하지 않음

//    @Autowired
    private final JdbcTemplate jdbcTemplate;


//    //생성자 기반
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    // 설정자 기반
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name,email) VALUES (?,?)";
jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        String sql2 = "SELECT * FROM users";
        RowMapper<User> rowMapper = (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
        );
        return jdbcTemplate.query(sql2, rowMapper);
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql3 = "UPDATE users SET email = ? WHERE name = ?";
        jdbcTemplate.update(sql3, email, name);
    }

    @Override
    public void deleteUser(String name) {

    }
}
