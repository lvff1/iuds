package com.swb.springbootmybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootmybatisplus.entity.Emp;
import com.swb.springbootmybatisplus.mapper.EmpMapper;
import com.swb.springbootmybatisplus.service.EmpService;
import org.springframework.stereotype.Service;

/**
 * @title: EmpServiceImpl
 * @author: 流沐颖
 * @date:2022/6/14 11:00
 * @description:
 * @version: study
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper,Emp> implements EmpService {


}
