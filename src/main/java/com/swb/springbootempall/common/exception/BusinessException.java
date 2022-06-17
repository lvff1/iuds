package com.swb.springbootempall.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: BusinessException
 * @author: 流沐颖
 * @date:2022/6/17 19:06
 * @description:  这个是用来继承运行时异常 进行业务异常时的抛出
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BusinessException extends RuntimeException {

    private Integer code;

    private String msg;
}
