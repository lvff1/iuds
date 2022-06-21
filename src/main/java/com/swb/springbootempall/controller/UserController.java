package com.swb.springbootempall.controller;

import com.swb.springbootempall.common.utils.R;
import com.swb.springbootempall.entity.User;
import com.swb.springbootempall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: UserController
 * @author: 流沐颖
 * @date:2022/6/17 12:18
 * @description:
 * @version: study
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 增加
     */
    @PostMapping("/save")
    public R saveUser(@RequestBody User user) {

        System.out.println("添加：" + user);

        if (userService.save(user)) {
            return R.ok("添加成功！", user);
        }
        return R.error("添加失败");
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public R delUser(@RequestBody List<Integer> list) {

        System.out.println("删除：" + list);

        if (userService.removeBatchByIds(list)) {
            return R.ok("删除成功！" );
        }
        return R.error("删除失败");
    }
    /**
     * 修改
     */
    @PostMapping("/update")
    public R updateUser(@RequestBody User user) {

        System.out.println("更新：" + user);

        if (userService.updateById(user)) {
            return R.ok("更新成功！" );
        }
        return R.error("更新失败");
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public R listUser() {

        List<User> userList = userService.list();
        System.out.println("所有用户信息：");
        userList.forEach((e) -> System.out.println(e));

        if (userList!=null&&userList.size()>0) {
            return R.ok("查询成功！",userList );
        }
        return R.error("查询失败");
    }


    /**
     * 查询单个
     */
    @PostMapping("/info/{id}")
    public R getUserById(@PathVariable Integer id) {

       User user = userService.getById(id);
        System.out.println("查询的结果为："+user);
        if(user!=null){
            return  R.ok("查询成功！",user);
        }
        return R.error("查询失败！");
    }
    /**
     * 分页查询
     */

    /**
     * 登录
     */
    //@PostMapping("/login")
    //public R doLogin(String username, String password) {
    //
    //    // 非空判断
    //    if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password)) {
    //        return R.error("用户名或密码为空");
    //    }
    //
    //    User user = userService.getById(username);
    //    if (user == null) {
    //        return R.error("该用户不存在！登录失败");
    //    }
    //    if(user!=null&&!user.getPassword().equals(password)){
    //        return R.error("用户名或密码错误！登录失败");
    //    }
    //    return R.ok("登录成功！",user);
    //}
}
