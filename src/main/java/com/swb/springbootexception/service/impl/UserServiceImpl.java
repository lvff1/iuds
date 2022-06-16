package com.swb.springbootexception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootexception.entity.User;
import com.swb.springbootexception.mapper.UserMapper;
import com.swb.springbootexception.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @title: UserServiceImpl
 * @author: 流沐颖
 * @date:2022/6/16 20:24
 * @description:
 * @version: study
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
