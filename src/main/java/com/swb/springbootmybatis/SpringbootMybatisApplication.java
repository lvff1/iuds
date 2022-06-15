package com.swb.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/**
 * 配置 dao扫描  也就是进行实体类的创建
 */
@MapperScan(basePackages = "com.swb.springbootmybatis.dao")

/**
 * @author 流沐颖
 */
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
