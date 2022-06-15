package com.swb.springbootuser.controller;

import com.swb.springbootuser.bean.User;
import com.swb.springbootuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: UserController
 * @author: 流沐颖
 * @date:2022/6/13 17:47
 * @description:
 * @version: study
 */
@RestController
public class UserController {
    @Autowired
    private UserService  userService;

    @GetMapping("/getAll")
    public String getAll(){
       return userService.getAll();
    }

    /**
     * 删除
     * @param user
     * @return
     */
    @DeleteMapping
    public int addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 删除
     * @param uid
     * @return
     */
    @DeleteMapping
    public int delUser(Integer uid){
        return userService.delUser(uid);
    }
    /**
     * 更新
     * @param uid
     * @return
     */
    @PutMapping
    public int updateUser(Integer uid){
        return userService.updateUser(uid);
    }


}
