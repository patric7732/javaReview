package org.example.securityexam;

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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auhhorizeRequests -> auhhorizeRequests
                        .anyRequest() // 모든 요청
                        .authenticated() // 인증을 요구
                );
//                .formLogin(Customizer.withDefaults()); // 이때 폼은 기본ㅁ 로그인 폼을 이용
        http
                .formLogin(formLogin -> formLogin
//                        .loginPage("/loginForm") // 시큐리티가 원하는 로그인 페이지를 설정해줌
                        .defaultSuccessUrl("/success")
                        .failureUrl("/fail")
                                .successHandler((request, response, authentication) ->
                                {
                                    log.info("authentication :: " + authentication.getName());
                                    response.sendRedirect("/success");
                                })
                                .failureHandler((request, response, exception) ->
                                {
                                    log.info("authentication :: " + exception.getMessage());
                                    response.sendRedirect("/fail");
                                })
//                        .usernameParameter("userId")
//                        .passwordParameter("passwd")
//                        .loginProcessingUrl("/login_p")
                        .permitAll() // 로그인 페이지에 대한 권한을 모두로 바꿈
                );
        http
                .logout(logout -> logout
//                        .logoutUrl("/log_out")
                        .logoutSuccessUrl("/login")
                        .addLogoutHandler((request, response, authentication) -> {
                            log.info("addLogoutHandler :: ");
                            HttpSession session = request.getSession();
                            session.invalidate();
                        })
                        .logoutSuccessHandler((request, response, authentication) -> {
                            log.info("logoutSuccessHandler :: ");
                            response.sendRedirect("/logout");
                        })
                        .deleteCookies("remember-me")
                );


        return http.build();
    }

}
