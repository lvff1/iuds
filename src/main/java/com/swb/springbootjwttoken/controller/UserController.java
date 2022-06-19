package com.swb.springbootjwttoken.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.swb.springbootjwttoken.commom.utils.JwtUtils;
import com.swb.springbootjwttoken.commom.utils.R;
import com.swb.springbootjwttoken.context.TokenContext;
import com.swb.springbootjwttoken.entity.User;
import com.swb.springbootjwttoken.entity.UserToken;
import com.swb.springbootjwttoken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.util.SystemUtil;

import java.util.List;

/**
 * @title: UserController
 * @author: 流沐颖
 * @date:2022/6/13 17:47
 * @description:
 * @version: study
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Algorithm swbswb = Algorithm.HMAC256("swbswb");

    /**
     * 执行登录前 生成相关token并返回到前端
     *
     * @param username
     * @return
     */
    @PostMapping("/login")
    public R doLogin(String username, String password) {
        System.out.println("执行登录操作");


        // 01 判断用户名或密码是否为空
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password)) {
            return R.error("用户名或密码为空，登录失败！");
        }

        // 02 查询数据库中是否存在该用户
        User user = userService.getById(username);
        System.out.println("当前登录用户：" + user);

        // 03 判断密码是否正确
        if (!user.getPassword().equals(password)) {
            // 进行脱敏提示
            return R.error("用户名或密码错误！！登录失败！");
        }

        // 封装 UserToken
        UserToken userToken = new UserToken();

        // 将用户名保存
        userToken.setUsername(username);

        // 生成token  再次封装  供用户调用时直接使用一个生成jwrutils类来生成token
        String token = JwtUtils.createToken(userToken);


        return R.ok("登录成功！", token);

    }

    /**
     * 输出所有的用户信息
     *
     * @return
     */
    @GetMapping("/list")
    public R userList() {
        List<User> list = userService.list();
        if (list != null && list.size() > 0) {
            return R.ok("查询成功！", list);
        } else {
            return R.error("查询失败");

        }
    }

    /**
     * 返回当前登录的用户信息
     *
     * @return
     */
    @GetMapping("/getUser")
    public R getUser() {
        UserToken userToken = TokenContext.get();
        if (userToken != null) {

            return R.ok("查询成功", userToken);
        }
        return R.error("查询失败");
    }
}
