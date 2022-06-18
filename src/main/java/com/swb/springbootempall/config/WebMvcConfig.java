package com.swb.springbootempall.config;

import com.swb.springbootempall.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title: WebMvcConfig
 * @author: 流沐颖
 * @date:2022/6/17 13:23
 * @description: 拦截器注册  对相关请求进行在拦截器拦截  做出相应的操作
 * @version: study
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;


    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");


    }

    /**
     * 解决跨域问题
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //所有路径
                .addMapping("/**")
                // 所有方法
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 所有的头部信息
                .allowedHeaders("*")
                //所有的域名
                .allowedOrigins("*");
    }
}
