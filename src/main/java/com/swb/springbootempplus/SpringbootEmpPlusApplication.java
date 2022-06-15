package com.swb.springbootempplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.swb.springbootempplus.mapper")
public class SpringbootEmpPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmpPlusApplication.class, args);
    }

}
