package com.swb.springbootempall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swb.springbootempall.entity.Emp;
import com.swb.springbootempall.mapper.EmpMapper;
import com.swb.springbootempall.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @title: EmpServiceImpl
 * @author: 流沐颖
 * @date:2022/6/17 19:01
 * @description:
 * @version: study
 */
@Service
public class EmpServiceImpl  extends ServiceImpl<EmpMapper, Emp> implements EmpService {

    @Override
    public IPage<Emp> doQuery(Map<String, Object> map) {

        // 取出相应的值
        Integer current = (Integer)map.get("current");
        Integer size = (Integer)map.get("size");


        // 封装分页对象
        Page<Emp> page=new Page<>(current,size);

        return baseMapper.empPage(page,map);
    }
}
