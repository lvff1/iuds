package com.swb.springbootempall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swb.springbootempall.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * @title: EmpService
 * @author: 流沐颖
 * @date:2022/6/17 19:01
 * @description:
 * @version: study
 */
public interface EmpService extends IService<Emp> {
    IPage<Emp> doQuery(Map<String, Object> map);
}
