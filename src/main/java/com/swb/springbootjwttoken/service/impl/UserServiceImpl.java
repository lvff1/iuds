package com.swb.springbootjwttoken.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootjwttoken.entity.User;
import com.swb.springbootjwttoken.mapper.UserMapper;
import com.swb.springbootjwttoken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: UserServiceImpl
 * @author: 流沐颖
 * @date:2022/6/13 17:54
 * @description:
 * @version: study
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {



}
