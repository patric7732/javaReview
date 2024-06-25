package org.example.filterexam2;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FilterReader;

@Configuration
public class FilterConfig {
    @Bean //필터를 등록할때 @ 방법보다 config 방법을 이용하면 좀 더 직관적이고 디테일한 설정이 가능해요.
    public FilterRegistrationBean<UserFilter> authenticationFilter(){
        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
        UserFilter userFilter = new UserFilter();
        registrationBean.setFilter(userFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);  //필터 실행시 우선 순위를 정할 수 있어요.  숫자가 작을수록 우선순위가 높아요.
        return registrationBean;
    }
}