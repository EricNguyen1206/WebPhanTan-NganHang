package com.o7planning.SpringBootRoutingDS.config;

import com.o7planning.SpringBootRoutingDS.interceptor.DataSourceInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//44 Trong WebMvcConfig cần phải đăng ký DataSourceInterceptor.

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new DataSourceInterceptor())//
                .addPathPatterns("/benthanh/**", "/tandinh/**");
                // tach nhieu '/' phia sau
    }


}