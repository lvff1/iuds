package com.swb.springbootempall.controller;

import com.swb.springbootempall.common.utils.R;
import com.swb.springbootempall.entity.Dept;
import com.swb.springbootempall.entity.Emp;
import com.swb.springbootempall.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: DeptController
 * @author: 流沐颖
 * @date:2022/6/17 19:48
 * @description:
 * @version: study
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    /**
     * 自动注入
     */
    @Autowired
    private DeptService deptService;

    /**
     * 添加
     */
    @PostMapping("/save")
    public R saveDept(@RequestBody Dept dept) {

        System.out.println("添加：" + dept);

        if (deptService.save(dept)) {
            return R.ok("添加成功！", dept);
        }
        return R.error("添加失败");
    }

    /**
     * 删除   要进行传值  所以是PostMapping
     */
    @PostMapping("/remove")
    public R removeDept(@RequestBody List<Integer> deptno) {
        System.out.println("删除：" + deptno);

        if (deptService.removeBatchByIds(deptno)) {
            return R.ok("删除成功！");
        }
        return R.error("删除失败");

    }


    /**
     * 修改
     */
    @PostMapping("/update")
    public R updateDept(@RequestBody Dept dept) {
        System.out.println("更新：" + dept);

        if (deptService.updateById(dept)) {
            return R.ok("更新成功！");
        }
        return R.error("更新失败");
    }

    /**
     * 查所有
     */
    @GetMapping("/list")
    public R listDept() {
        List<Dept> deptList = deptService.list();
        deptList.forEach((e)->System.out.println(e));

        if (deptList != null && deptList.size() > 0) {
            return R.ok("查询成功！", deptList);

        }
        return R.error("查询失败");
    }

    /**
     * 根据id查询
     */
    @PostMapping("/info/{deptno}")
    public R getEmpByEno(@PathVariable Integer deptno) {

        Dept dept = deptService.getById(deptno);
        System.out.println("查询的结果为："+dept);
        if(dept!=null){
            return  R.ok("查询成功！",dept);
        }
        return R.error("查询失败！");
    }


}
