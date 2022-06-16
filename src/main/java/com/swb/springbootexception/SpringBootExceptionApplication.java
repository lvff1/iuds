package com.swb.springbootexception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages =" com.swb.springbootexception.mapper")
public class SpringBootExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExceptionApplication.class, args);
    }

}
