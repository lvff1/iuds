package com.swb.springbootempall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @title: Dept
 * @author: 流沐颖
 * @date:2022/6/17 19:47
 * @description:
 * @version: study
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@TableName("t_dept")
public class Dept {

    @TableId(type = IdType.AUTO)
    private Integer deptno;

    private String dname;

    private String Ioc;



}
