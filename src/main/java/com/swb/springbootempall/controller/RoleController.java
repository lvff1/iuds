package com.swb.springbootempall.controller;

import com.swb.springbootempall.common.utils.R;
import com.swb.springbootempall.entity.Role;
import com.swb.springbootempall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: RoleControoler
 * @author: 流沐颖
 * @date:2022/6/21 14:44
 * @description:
 * @version: study
 */

@RestController
@RequestMapping("/role")

public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 增加
     */
    @PostMapping("/save")
    public R saveRole(@RequestBody Role role) {

        System.out.println("添加：" + role);

        if (roleService.save(role)) {
            return R.ok("添加成功！", role);
        }
        return R.error("添加失败");
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public R delRole(@RequestBody List<Integer> list) {

        System.out.println("删除：" + list);

        if (roleService.removeBatchByIds(list)) {
            return R.ok("删除成功！");
        }
        return R.error("删除失败");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R updateRole(@RequestBody Role role) {

        System.out.println("更新：" + role);

        if (roleService.updateById(role)) {
            return R.ok("更新成功！");
        }
        return R.error("更新失败");
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public R listRole() {

        List<Role> RoleList = roleService.list();
        System.out.println("所有用户信息：");
        RoleList.forEach((e) -> System.out.println(e));

        if (RoleList != null && RoleList.size() > 0) {
            return R.ok("查询成功！", RoleList);
        }
        return R.error("查询失败");
    }


    /**
     * 查询单个
     */
    @PostMapping("/info/{id}")
    public R getRoleById(@PathVariable Integer id) {

        Role role = roleService.getById(id);
        System.out.println("查询的结果为：" + role);
        if (role != null) {
            return R.ok("查询成功！", role);
        }
        return R.error("查询失败！");
    }

}
