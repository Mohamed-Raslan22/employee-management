package com.employee.management.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.management.fiters.RequestIdFilter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean requestIdFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RequestIdFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
