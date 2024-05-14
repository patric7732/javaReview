package com.example.jdbc01;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);

    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            //Create
            //user 입력
//            String sql = "INSERT INTO users(name, email) VALUES(?,?)";
//            jdbcTemplate.update(sql, "patric", "patric@gmail.com");

            // Read
            // RowMapper를 이용해야하는 이유는 결과값 담을때, 테이블의 컬럼과 User class의 필드를 직접 매칭 해주는데
            // 만약에 테이블의 컬럼과 클래스의 필드가 완전히 일치하다면 직접 해줄 필요가 없게됨

//            List<User> users = jdbcTemplate.query("SELECT id,name,email FROM users",
//                    new BeanPropertyRowMapper<>(User.class));
//            for (User user : users){
//                System.out.println(user);
//        }
//            users.forEach(System.out::println);

            // Read
            RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );
            List<User> users = jdbcTemplate.query("SELECT * FROM users", rowMapper);
            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
        };

    }
}
