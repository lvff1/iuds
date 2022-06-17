package com.swb.springbootempall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootempall.entity.Dept;
import com.swb.springbootempall.mapper.DeptMapper;
import com.swb.springbootempall.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @title: DeptServiceImpl
 * @author: 流沐颖
 * @date:2022/6/17 19:51
 * @description:
 * @version: study
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
