package com.miteng.strive.config;

import com.miteng.strive.interceptor.DemoInterceptor;
import com.miteng.strive.pojo.Money;
import com.miteng.strive.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 苗腾
 * @Date 2021/7/1 9:55
 * @Version 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor())
        .addPathPatterns("/hello");
    }

    @Bean
    public Money dd() {
        return new Money();
    }
}
