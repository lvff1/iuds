package com.swb.springbootjwttoken.context;

import com.swb.springbootjwttoken.entity.UserToken;

/**
 * @title: TokenContext
 * @author: 流沐颖
 * @date:2022/6/19 21:11
 * @description: 拿到解析token后的用户信息
 * @version: study
 */
public class TokenContext {
    private static final ThreadLocal<UserToken> thread_local = new ThreadLocal<>();

    /**
     * 设置相关userToken给本地线程池
     *
     * @param userToken
     */
    public static void set(UserToken userToken) {
        thread_local.set(userToken);
    }

    /**
     * 获取到本地已经存储的UserToken
     */
    public static UserToken get() {
        return thread_local.get();
    }

    /**
     * 移除掉本地线程池中所存储的UserToken
     */
    public  static void remove(){
        thread_local.remove();
    }


}
