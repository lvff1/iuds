package com.swb.springbootjwttoken.exception;

import com.swb.springbootjwttoken.commom.excption.MyBusinessException;
import com.swb.springbootjwttoken.commom.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @title: MyException
 * @author: 流沐颖
 * @date:2022/6/19 14:18
 * @description: 全局异常处理器
 * @RestControllerAdvice 将作用于  所有包括这个RestController上面  对其出现的异常进行捕获和处理
 * @version: study
 */
@RestControllerAdvice
@Slf4j
public class MyException {

    /**
     * 处理系统异常 如除数为0等
     * @param e
     * @return
     */
    @ExceptionHandler
    public R sysException(Exception e) {
        // 记录日志
        log.error("系统异常", e);

        // 提示给用户
        return R.error("系统繁忙，请稍后再试吧~");


    }

    /**
     * 处理业务异常  如转账金额不足等
     * @param mbe
     * @return
     */
    @ExceptionHandler
    public R businessException(MyBusinessException mbe) {
        // 记录日志
        log.error("业务异常", mbe);

        // 提示用户
        return R.error(mbe.getMsg());

    }


}
