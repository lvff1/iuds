package com.swb.springbootexception.config;

import com.swb.springbootexception.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title: WebMvcConfig
 * @author: 流沐颖
 * @date:2022/6/16 9:31
 * @description: 实现WebMvc的接口  为了定义拦截的范围
 * @version: study
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 对自己写的拦截器进行注册
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 进行注册
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**");

    }

}
