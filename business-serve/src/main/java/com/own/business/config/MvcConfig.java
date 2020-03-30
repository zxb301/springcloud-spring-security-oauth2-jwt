package com.own.business.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 98050
 * @Time: 2018-10-25 19:48
 * @Feature: 配置过滤器
 */
@Configuration
//@EnableConfigurationProperties(JwtProperties.class)
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");
    }

   /*  @Bean
     public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
         System.out.println();
         return new BasicAuthRequestInterceptor("user","pass123");
     }*/

}
