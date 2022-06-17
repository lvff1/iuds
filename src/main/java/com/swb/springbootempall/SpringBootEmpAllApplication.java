package com.swb.springbootempall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 流沐颖
 */
@SpringBootApplication
// 开始扫描dao层 实现相关的实例对象
@MapperScan(basePackages = "com.swb.springbootempall.mapper")
public class SpringBootEmpAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmpAllApplication.class, args);
    }

}
