package org.example.filterexam4.config;

import org.example.filterexam4.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(AuthenticationFilter) authenticationFilter(){
        FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean = new FilterRegistrationBean();
    }
}
