package com.swb.springbootjwttoken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @title: User
 * @author: 流沐颖
 * @date:2022/6/13 17:48
 * @description:
 * @version: study
 */

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString


@TableName("t_user")
public class User {
    @TableId
    private String username;
    private String password;
}
