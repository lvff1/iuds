package com.swb.springbootempplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: PageConfig
 * @author: 流沐颖
 * @date:2022/6/15 13:27
 * @description: 分页插件的配置
 * @version: study
 */

@Configuration
public class PageConfig {
    /**
     * 创建一个配置类进行分页配置  即设置一个MyBatisPlus的拦截器
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
       MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
       interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
       return interceptor;
    }


}
