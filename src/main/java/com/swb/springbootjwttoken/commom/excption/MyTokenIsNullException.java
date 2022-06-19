package com.swb.springbootjwttoken.commom.excption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: TokenIsNullException
 * @author: 流沐颖
 * @date:2022/6/19 20:19
 * @description:
 * @version: study
 */
@Data


public class MyTokenIsNullException extends MyBusinessException{
    public MyTokenIsNullException(Integer code, String msg) {
        super(code, msg);
    }
}
