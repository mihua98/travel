package com.hm.travel.config;

import com.hm.travel.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author: xiaomikasa
 * @date: 2019/8/27
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截的请求，
        // excludePathPatterns("/login", "/register") 排除的请求
        registry.addInterceptor(loginInterceptor).addPathPatterns("/travelLogEdit");

    }
}
