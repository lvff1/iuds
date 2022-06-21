package com.swb.springbootempall.entity;

import com.alibaba.fastjson.annotation.JSONField;
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
 * @title: Role
 * @author: 流沐颖
 * @date:2022/6/21 10:23
 * @description: 角色表
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@TableName("t_role")
public class Role {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String rname;
    private String rdesc;
    private Integer rstatus;

    @JSONField
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


}
