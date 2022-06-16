package com.swb.springbootexception.Exception;

import com.swb.springbootexception.common.exception.BusinessException;
import com.swb.springbootexception.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @title: MyExceptionHandler
 * @author: 流沐颖
 * @date:2022/6/16 20:25
 * @description: 全局的异常管理器
 * @RestControllerAdvice 对restful风格的controller进行增强 也就是进行处理
 * @version: study
 */

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {
    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class) // 只有抛出的异常是Exception的子类就会调用这个方法
    public static R sysException(Exception e){
        // 日志方式将异常记录起来 给管理员看的
        log.error("系统异常",e);

        System.out.println("出现系统异常啦~");

        // 返回给用户看的异常信息
        return R.error("系统正在维护中，请稍后再试！");
    }


    /**
     * 业务异常--运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public static R businessException(BusinessException e){ // 只要是BusinessException就会抛出异常

        // 以日志的形式记录异常  提示给管理员
        log.error("业务异常", e);

        // 提示信息给用户  尽量通俗易懂  将传进来的提示信息再次返回出去
        return R.error(e.getMsg());



    }
}
