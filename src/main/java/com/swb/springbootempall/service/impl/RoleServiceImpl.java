package com.swb.springbootempall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootempall.entity.Role;
import com.swb.springbootempall.mapper.RoleMapper;
import com.swb.springbootempall.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @title: RoleServiceImpl
 * @author: 流沐颖
 * @date:2022/6/21 14:45
 * @description:
 * @version: study
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
