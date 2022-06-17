package com.swb.springbootempall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootempall.entity.User;
import com.swb.springbootempall.mapper.UserMapper;
import com.swb.springbootempall.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @title: UserServiceImpl
 * @author: 流沐颖
 * @date:2022/6/17 12:21
 * @description:
 * @version: study
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService  {
}
