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
 * @title: User
 * @author: 流沐颖
 * @date:2022/6/17 12:16
 * @description:
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private Integer sex;
    private String email;
    private Integer status;

    @JSONField
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;

}
