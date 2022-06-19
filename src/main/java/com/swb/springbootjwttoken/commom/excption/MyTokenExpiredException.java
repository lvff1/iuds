package com.swb.springbootjwttoken.commom.excption;

import lombok.Data;

/**
 * @title: MyTokenExpiredException
 * @author: 流沐颖
 * @date:2022/6/19 20:53
 * @description:
 * @version: study
 */
@Data
public class MyTokenExpiredException extends MyBusinessException {

    /**
     * 传入相关的code+msg
     * @param code
     * @param msg
     */
    public MyTokenExpiredException(Integer code, String msg) {
        super(code, msg);
    }
}
