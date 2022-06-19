package com.swb.springbootjwttoken.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @title: UserToken
 * @author: 流沐颖
 * @date:2022/6/19 16:31
 * @description: 用来封装返回的结果 生成相应的token
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserToken {
    private Integer id;
    private String username;
}
