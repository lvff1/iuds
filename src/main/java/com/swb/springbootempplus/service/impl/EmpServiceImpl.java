package com.swb.springbootempplus.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootempplus.entity.Emp;
import com.swb.springbootempplus.mapper.EmpMapper;
import com.swb.springbootempplus.service.EmpService;
import org.springframework.stereotype.Service;

/**
 * @title: EmpServiceImpl
 * @author: 流沐颖
 * @date:2022/6/15 13:14
 * @description:
 * @version: study
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    // 这里继承的是serviceImpl 实现方法
}
