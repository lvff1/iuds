package com.swb.springbootempall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @TableId
    private String username;

    private String password;
}
