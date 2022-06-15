package com.swb.springbootuser.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

@Component

@ConfigurationProperties(prefix="my.user1")
public class User {
    private Integer uid;
    private String username;

    ///**
    // * array
    // */
    //
    //private String[] userString;
    //
    //
    ///**
    // * set
    // */
    //private Set userSet;
    //
    //
    ///**
    // * map
    // */
    //private Map<String,String> userMap;
    //
    ///**
    // * properties
    // */
    //private Properties userProperties;

    public User(Integer uid, String username) {
        this.uid=uid;
        this.username=username;
    }
}
