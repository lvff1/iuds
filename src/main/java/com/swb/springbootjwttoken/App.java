package com.swb.springbootjwttoken;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author 流沐颖
 */
@SpringBootApplication

@MapperScan(basePackages = "com.swb.springbootjwttoken.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
