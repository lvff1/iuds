package com.swb.springbootjwttoken.configuation;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.swb.springbootjwttoken.intercptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title: WebMvcConfig
 * @author: 流沐颖
 * @date:2022/6/19 14:01
 * @description: 对自己所写的拦截器进行注册
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
        // 拦截所有的请求
        registry.addInterceptor(myInterceptor).addPathPatterns("/**")
                // 只放行登录操作
                .excludePathPatterns("/user/login");

    }
}
