package com.swb.springbootmybatis.controller;

import com.swb.springbootmybatis.entity.Emp;
import com.swb.springbootmybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: EmpController
 * @author: 小蓝胖
 * @date:2022/6/14 11:11
 * @description:
 * @version: study
 */

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查找所有
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<Emp> getAll() {
        System.out.println("-------------------");
        System.out.println(empService.getAllEmp());
        System.out.println("-------------------");
        return empService.getAllEmp();
    }

    /**
     * 添加用户
     * 使用@RequestBody  进行json数据的封装
     */
    @PostMapping("/add")
    public String addEmp(@RequestBody Emp emp) {

        if (empService.addEmp(emp) > 0) {
            return "添加成功!";
        }
        return "添加失败!";

    }
   /**
     * 添加用户
     * 使用@RequestBody  进行json数据的封装
     */
    @PostMapping("/update")
    public String updateEmp(@RequestBody Emp emp) {

        if (empService.updateEmp(emp) > 0) {
            return "更新成功!";
        }
        return "更新失败!";

    }

    @DeleteMapping("/delete/{eno}")
    public String deleteEmp(@PathVariable  String eno) {
        int empno=Integer.valueOf(eno);
        if (empService.deleteEmp(empno) > 0) {
            return "删除成功!";
        }
        return "删除失败!";


    }
}
