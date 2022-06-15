package com.swb.springbootmybatis.service.impl;

import com.swb.springbootmybatis.dao.EmpDao;
import com.swb.springbootmybatis.entity.Emp;
import com.swb.springbootmybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title: EmpServiceImpl
 * @author: 流沐颖
 * @date:2022/6/14 11:00
 * @description:
 * @version: study
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpDao empDao;


    /**
     * 获取所有的emp
     *
     * @return
     */
    @Override
    public List<Emp> getAllEmp() {
        return empDao.getAllEmp();
    }

    /**
     * 添加员工
     *
     * @param emp
     * @return
     */
    @Override
    public int addEmp(Emp emp) {
       return empDao.addEmp(emp);
    }

    /**
     * 更新员工  todo
     *
     * @param emp
     * @return
     */
    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    /**
     * 删除员工
     *
     * @param empno
     * @return
     */
    @Override
    public int deleteEmp(int empno) {
       return  empDao.deleteEmp(empno);
    }
}
