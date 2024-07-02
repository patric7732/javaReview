package org.example.jwtexam.jwt.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // 사용자가 인증되지 않았을때
    @Override // 구현 인터페이스, 인증 예외를 담는 exception 객체
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        String exception = (String)request.getAttribute("exception"); // 오브젝트로 받기에 String으로 형변환 해줌
    }
}
