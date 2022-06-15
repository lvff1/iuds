package com.swb.springbootmybatis;

import com.swb.springbootmybatis.entity.Emp;
import com.swb.springbootmybatis.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest( "class = SpringbootMybatisApplication.class")
class SpringbootMybatisApplicationTests {
    @Autowired
    private EmpService empService;

    @Test
    void contextLoads() {
        List<Emp> allEmp = empService.getAllEmp();
        System.out.println(allEmp);

    }

}
