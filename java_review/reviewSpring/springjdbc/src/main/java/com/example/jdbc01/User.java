package com.example.jdbc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복 - 롬복은 컴파일 단계에서 인지,
@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
}
