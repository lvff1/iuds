package com.swb.springbootempall.Exceptions;

import com.swb.springbootempall.common.exception.BusinessException;
import com.swb.springbootempall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.bind.annotation.*;

/**
 * @title: ExceptionHandler
 * @author: 流沐颖
 * @date:2022/6/17 13:13
 * @description: 业务异常及相关系统异常
 * @version: study
 */

@RestControllerAdvice

@Slf4j
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler
    public  static R sysException(Exception e) {

        // 输出日志
        log.error("系统异常", e);


        //输出给用户
        return R.error("系统繁忙，请稍后再试试吧~");

    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public static  R businessException(BusinessException be){

        // 输出日志
        log.error("业务异常", be);


        // 输出给用户
        return R.error(be.getMsg());


    }





}
