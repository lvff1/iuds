package com.swb.springbootmybatis.service;

import com.swb.springbootmybatis.entity.Emp;

import java.util.List;

/**
 * @title: EmpService
 * @author: 流沐颖
 * @date:2022/6/14 11:00
 * @description:
 * @version: study
 */
public interface EmpService {

    /**
     * 获取所有的emp
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 添加员工
     * @param emp
     * @return
     */
    int addEmp(Emp emp);

    /**
     * 更新员工  todo
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);

    /**
     * 删除员工
     * @param empno
     * @return
     */
    int deleteEmp(int empno);
}
