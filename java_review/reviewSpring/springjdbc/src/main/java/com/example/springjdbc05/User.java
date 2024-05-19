package com.example.springjdbc05;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private Long id;
    private String name;
    private String email;
}
