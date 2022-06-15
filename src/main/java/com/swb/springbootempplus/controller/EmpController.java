package com.swb.springbootempplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swb.springbootempplus.commons.R;
import com.swb.springbootempplus.entity.Emp;
import com.swb.springbootempplus.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: EmpController
 * @author: 流沐颖
 * @date:2022/6/15 13:27
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
    public R getAll() {
        List<Emp> empList = empService.list();
        if (empList != null && empList.size() > 0) {
            return R.ok("查询成功!", empList);
        }
        return R.fail("查询失败!");
    }

    /**
     * 通过eno查找整条数据
     *
     * @param empno
     * @return
     */
    @GetMapping("/checkNo/{empno}")
    public R getListByEno(@PathVariable("empno") Integer empno) {
        Emp emp = empService.getById(empno);
        if (emp != null) {
            return R.ok("查询成功!", emp);
        }
        return R.fail("查询失败，是不是没有加路径参数？！");
    }

    @PostMapping("/page")
    public R getInfoByPage(@RequestBody Page<Emp> page) {
        Page<Emp> pageInfo = empService.page(page);
        if (pageInfo != null && pageInfo.getSize() > 0) {
            return R.ok("分页成功！", pageInfo);
        }
        return R.ok("分页失败！是不是没有写分页插件啊？！", pageInfo);
    }

    /**
     * 执行添加 记得一定要加上@RequestBody注解 接受前端传来的数据 封装数据 -- PostMapping
     *
     * @param emp
     * @return
     */
    @PostMapping("/add")
    public R addEmp(@RequestBody Emp emp) {

        boolean save = empService.save(emp);
        if (save) {
            return R.ok("添加成功！", emp);
        }
        return R.fail("添加失败,是不是没有加@RequestBody注解？！");
    }

    /**
     * 执行更新： 记得一定要加上@RequestBody注解 接受前端传来的数据 封装数据  --  PutMapping
     *
     * @param emp
     * @return
     */
    @PutMapping("/update")
    public R updateEmp(@RequestBody Emp emp) {
        System.out.println("aaaa");
        System.out.println(emp);
        boolean update = empService.updateById(emp);
        if (update) {
            return R.ok("修改成功！");
        }
        return R.fail("修改失败，是不是没有加@RequestBody注解？！");

    }

    /**
     * 执行删除  通过empno -- DeleteMapping
     *
     * @param empno
     * @return
     */
    @DeleteMapping("/delete/{empno}")
    public R delete(@PathVariable("empno") Integer empno) {
        boolean delete = empService.removeById(empno);
        if (delete) {
            return R.ok("删除成功！");
        }
        return R.fail("删除失败，是不是没有加路径参数？！");
    }


}
