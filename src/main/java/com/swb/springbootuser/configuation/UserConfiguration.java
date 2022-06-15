package com.swb.springbootuser.configuation;

import com.swb.springbootuser.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: UserConfiguation
 * @author: 流沐颖
 * @date:2022/6/13 17:50
 * @description:
 * @version: study
 */

//@Configuration
public class UserConfiguration {

    @Value("${my.user1.uid}")
    public Integer uid;


    /**
     * 第一种方式  直接写死
     *
     * @return
     */
    @Bean
    public User user() {
        User user=new User();
        user.setUid(uid);
        return user;
    }

}
