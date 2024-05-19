package com.example.springdatajdbc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// 엔티티 클래스 ( DTO는 단순히 값만 담아서 전달되는 객체라면, 엔티티는 데이터베이스와의 관계를 알려주는 역할도 해줌.
@Table("users") // 엔티티로 쓰기 위해 Table 어노테이션을 써야함, 테이블명과 객체가 다르기에 설정해줘야함
@Getter
@Setter
@NoArgsConstructor // 생성자 설정,
@AllArgsConstructor
public class User {
    @Id // id라는 것을 알려줘야함, 이것이 기본적인 조건임
    private Long id;
    private String name;
    private String email;


    // id는 받지 않고 User name, email만 받는 생성자
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
