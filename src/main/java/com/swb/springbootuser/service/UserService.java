package com.swb.springbootuser.service;

import com.swb.springbootuser.bean.User;

/**
 * @title: UserService
 * @author: 流沐颖
 * @date:2022/6/13 17:53
 * @description:
 * @version: study
 */
public interface UserService {
    String getAll();

    int delUser(Integer uid);


    int updateUser(Integer uid);

    int addUser(User user);
}
