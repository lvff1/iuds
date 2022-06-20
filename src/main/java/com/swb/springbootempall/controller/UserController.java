package com.swb.springbootempall.controller;

import com.swb.springbootempall.common.utils.R;
import com.swb.springbootempall.entity.Emp;
import com.swb.springbootempall.entity.User;
import com.swb.springbootempall.service.EmpService;
import com.swb.springbootempall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login")
    public R doLogin(String username, String password) {

        // 非空判断
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password)) {
            return R.error("用户名或密码为空");
        }

        User user = userService.getById(username);
        if (user == null) {
            return R.error("该用户不存在！登录失败");
        }
        if(user!=null&&!user.getPassword().equals(password)){
            return R.error("用户名或密码错误！登录失败");
        }
        return R.ok("登录成功！",user);
    }

}
