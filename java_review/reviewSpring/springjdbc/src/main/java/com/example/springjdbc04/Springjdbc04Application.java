package com.example.springjdbc04;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class Springjdbc04Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc04Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){
        return args -> {
            String sql = "SELECT id, name, email FROM users";
            List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
            users.forEach(user -> System.out.println(user));
        };
    }

    @Bean
    public CommandLineRunner demoExtractor(JdbcTemplate jdbcTemplate) {
        return args -> {
// ResultSetExtractor example
            String sql = "SELECT id, name, email FROM users";
            User user = jdbcTemplate.query(sql, new UserResultSetExtractor());
            System.out.println(user);
        };
    }

    // RowMapper 사용
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            return new User(id, name, email);
        }
    }

    // ResultSetExtractor 사용
    private static class UserResultSetExtractor implements ResultSetExtractor<User> {
        // ResultSetExtractor 결과 집합 전체를 단일 객체로 변환하는데 사용
        // 여러 테이블에서 조인된 결과를 받아서 하나의 복합 객체로 매핑, 조건에 따라 다양한 타입의 객체를 리스트에 추가할 떄 사용할 수 있다.
        // 메소드가 한 번만 호출되서 전체 결과 집합을 처리해준다.
        @Override
        public User extractData(ResultSet rs) throws SQLException {
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));

            //유저 하나에 대한 값만 채우는 거라 RowMapper와 크게 차이는 없어보임,
                // 근데 게시글이라면 게시글 하나에 댓글 리스트가 필드로 들어와 있을 수 있음

            }
            return user;
        }
    }

}
