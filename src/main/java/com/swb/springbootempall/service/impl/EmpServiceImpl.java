package com.swb.springbootempall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootempall.entity.Emp;
import com.swb.springbootempall.mapper.EmpMapper;
import com.swb.springbootempall.service.EmpService;
import org.springframework.stereotype.Service;

/**
 * @title: EmpServiceImpl
 * @author: 流沐颖
 * @date:2022/6/17 19:01
 * @description:
 * @version: study
 */
@Service
public class EmpServiceImpl  extends ServiceImpl<EmpMapper, Emp> implements EmpService {
}
