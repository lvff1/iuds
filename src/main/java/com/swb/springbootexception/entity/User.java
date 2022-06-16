package com.swb.springbootexception.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @title: User
 * @author: 流沐颖
 * @date:2022/6/16 20:42
 * @description:
 * @version: study
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@TableName("t_user")
public class User {


    @TableId("username")
    private String  username;
    private String password;


}
