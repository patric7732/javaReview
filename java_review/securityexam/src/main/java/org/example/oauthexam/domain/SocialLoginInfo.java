package org.example.oauthexam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "social_login_info")
@Getter
@Setter
public class SocialLoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provider;
    private String socialId;
    private LocalDateTime createdAt;
    private String uuid;

    public SocialLoginInfo() {

        this.createdAt = LocalDateTime.now();
        this.uuid = UUID.randomUUID().toString();
    }
}
