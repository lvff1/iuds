package com.swb.springbootmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Date;

/**
 * @title: Emp
 * @author: 流沐颖
 * @date:2022/6/14 10:02
 * @description:
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Component
public class Emp {
    private Integer empno;
    private String ename;
    private Double sal;
    private Double comm;
    // 添加时:  jsonformat
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")

    // 显示时： datetimeformat
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    private String job;
    private Integer mgr;
    private Integer deptno;

}
