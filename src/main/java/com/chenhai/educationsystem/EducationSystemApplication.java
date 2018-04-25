package com.chenhai.educationsystem;

import com.chenhai.educationsystem.filter.CrossFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EducationSystemApplication{

    public static void main(String[] args) {
        SpringApplication.run(EducationSystemApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<CrossFilter> registerCrossFilter(){
        FilterRegistrationBean<CrossFilter> registration = new FilterRegistrationBean();
        registration.setFilter(new CrossFilter());
        registration.addUrlPatterns("/*");
        registration.setName("crossFilter");
        return registration;
    }
}
