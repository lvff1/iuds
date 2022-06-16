package com.swb.springbootexception.controller;

import com.swb.springbootexception.Exception.MyExceptionHandler;
import com.swb.springbootexception.common.exception.BusinessException;
import com.swb.springbootexception.common.utils.R;
import com.swb.springbootexception.entity.User;
import com.swb.springbootexception.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

/**
 * @title: Login
 * @author: 流沐颖
 * @date:2022/6/16 21:47
 * @description:
 * @version: study
 */
@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private UserService userService;
    @Autowired
    private MyExceptionHandler myExceptionHandler;

    @PostMapping("/doLogin")
    public R doLogin(String username, String password) {
        System.out.println("根本拦截不到我哦~");
        //username.length();
        // 使用用户名去进行查询 返回结果为user对象
        User user = userService.getById(username);
        // 空指针异常--系统异常
        System.out.println(user);
        // 通过从数据库返回的
        if (user!= null&&username!=null) {
            if (user.getPassword().equals(password)) {
                return R.ok("登录成功！", user);
            } else {
                throw new BusinessException(1002, "登录密码错误！");
            }
        } else {
            throw new BusinessException(1001, "用户名【"+username+"】不存在或密码错误！");
        }


    }

}
