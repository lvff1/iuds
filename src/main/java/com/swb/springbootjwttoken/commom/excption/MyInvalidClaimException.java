package com.swb.springbootjwttoken.commom.excption;

/**
 * @title: MyInvalidClaimException
 * @author: 流沐颖
 * @date:2022/6/19 20:56
 * @description:
 * @version: study
 */
public class MyInvalidClaimException extends MyBusinessException {
    /**
     * 判断token 是否被窜改
     * @param code
     * @param msg
     */
    public MyInvalidClaimException(Integer code, String msg) {
        super(code, msg);
    }
}
