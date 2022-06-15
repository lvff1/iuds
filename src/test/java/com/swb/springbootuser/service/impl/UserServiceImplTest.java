package com.swb.springbootuser.service.impl;

import com.swb.springbootuser.bean.User;
import com.swb.springbootuser.service.UserService;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @title: UserServiceImplTest
 * @author: 流沐颖
 * @date:2022/6/13 23:58
 * @description:
 * @version: study
 */
public class UserServiceImplTest {

    /**
     * 进行测试  模拟前台传来的数据  在业务层进行判断  若成功接收到了 则将结果返回
     */
    UserService userService = new UserServiceImpl();


    @Test
    public void delUser() {

        Integer uid = 102;

        int i = userService.delUser(uid);

        //  暂时就是当业务层拿到传过去的uid  就算删除成功
        if (i > 0) {
            System.out.println("删除成功！");
        }


    }

    @Test
    public void updateUser() {

        Integer uid = 101;

        int i = userService.updateUser(uid);

        //  暂时就是当业务层拿到传过去的uid  就算更新成功
        if (i > 0) {
            System.out.println("修改成功！");
        }

    }

    @Test
    public void addUser() {

        User u1 = new User(1, "swbswb");
        System.out.println(u1);
        //  暂时就是当业务层拿到传过去的u1 就算添加
        int i = userService.addUser(u1);
        if (i > 0) {
            System.out.println("添加成功！");
        }


    }
}