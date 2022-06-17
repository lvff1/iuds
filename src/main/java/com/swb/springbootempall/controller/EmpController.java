package com.swb.springbootempall.controller;

import com.swb.springbootempall.common.utils.R;
import com.swb.springbootempall.entity.Emp;
import com.swb.springbootempall.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: EmpController
 * @author: 流沐颖
 * @date:2022/6/17 18:54
 * @description:
 * @version: study
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    /**
     * 自动注入
     */
    @Autowired
    private EmpService empService;

    /**
     * 添加
     */
    @PostMapping("/save")
    public R saveEmp(@RequestBody Emp emp) {

        System.out.println("添加：" + emp);

        if (empService.save(emp)) {
            return R.ok("添加成功！", emp);
        }
        return R.error("添加失败");
    }

    /**
     * 删除 -- 单个删除
     */
    @DeleteMapping("/remove/{empno}")
    public R removeEmp(@PathVariable Integer empno) {
        System.out.println("删除：" + empno);

        if (empService.removeById(empno)) {
            return R.ok("删除成功！");
        }
        return R.error("删除失败");

    }


    /**
     * 修改
     */
    @PutMapping("/update")
    public R updateEmp(@RequestBody Emp emp) {
        System.out.println("更新：" + emp);

        if (empService.updateById(emp)) {
            return R.ok("更新成功！");
        }
        return R.error("更新失败");
    }

    /**
     * 查所有
     */
    @GetMapping("/list")
    public R listEmp() {
        List<Emp> empList = empService.list();
        empList.forEach((e)->System.out.println(e));

        if (empList != null && empList.size() > 0) {
            return R.ok("查询成功！", empList);

        }
        return R.error("查询失败");
    }

    /**
     * 根据id查询
     */
    @PostMapping("/info/{empno}")
    public R getEmpByEno(@PathVariable Integer empno) {

        Emp emp = empService.getById(empno);
        System.out.println("查询的结果为："+emp);
        if(emp!=null){
            return  R.ok("查询成功！",emp);
        }
        return R.error("查询失败！");
    }


}
