package com.swb.springbootempall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @title: Emp
 * @author: 流沐颖
 * @date:2022/6/17 18:53
 * @description:
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@TableName("t_emp")
public class Emp {

    @TableId(type = IdType.AUTO)
    private Integer empno;

    private String ename;

    private Double sal;

    private Double comm;

    private String job;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private Integer mgr;

    private Integer deptno;
}
