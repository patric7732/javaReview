package org.example.filterexam;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

// 필터 자체를 요청 할 수는 없다.
//필터는 어떤 요청을 처리하기 전, 후에 해야 할 일들을 거쳐서 할 수 있다.
// 예를 들면 인코딩, 인증, 인가같은 일을 해줄 수 있다.
@Slf4j
@Component
public class FirstFilter implements Filter {

    public FirstFilter() {
        log.info("FirstFilter 생성자 () 실행");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FirstFilter init () 실행");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("FirstFilter dofilter () 실행 전 실행");

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("FirstFilter dofilter () 실행 후 실행");
    }

    @Override
    public void destroy() {
        log.info("FirstFilter destroy () 실행");
    }
}
