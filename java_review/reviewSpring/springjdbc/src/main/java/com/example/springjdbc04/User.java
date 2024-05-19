package com.example.springjdbc04;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}
