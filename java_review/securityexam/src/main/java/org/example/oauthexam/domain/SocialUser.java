package org.example.oauthexam.domain;

import lombok.Data;
import jakarta.persistence.*;
@Entity
@Data
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String socialId;
    private String provider;
    private String username;
    private String email;
    private String avatarUrl;
}

