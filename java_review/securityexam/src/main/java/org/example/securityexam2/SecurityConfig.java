package org.example.securityexam2;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authroizeRequest -> authroizeRequest
                        .anyRequest() //모든 요청
                        .authenticated() //인증을 요구
                )
                .formLogin(Customizer.withDefaults());
        http
                .rememberMe(rememberMe ->rememberMe
                                .rememberMeParameter("remember")
//                        .tokenValiditySeconds(300)
                );


        return http.build();
    }
}