package com.example.springjdbc08;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    // 입력이 되면 자동으로 생성된 PK 값을 리턴받고 싶을때.
    // SimpleJdbcInsert, 수행한 뒤에 PK값을 리턴해준

    private SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    }

    public User insertUser(User user) {

        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());

        Number pk = simpleJdbcInsert.executeAndReturnKey(params);
        user.setId(pk.longValue());
        return user;
    }

}
