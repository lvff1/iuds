package com.swb.springbootexception.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @title: BusinessException
 * @author: 流沐颖
 * @date:2022/6/16 23:56
 * @description: 进行自定义抛出的自定义异常
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BusinessException extends RuntimeException {

    /**
     * 异常代码
     */
    private Integer code;

    /**
     * 异常提示信息
     */
    private String msg;


}
