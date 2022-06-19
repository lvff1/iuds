package com.swb.springbootjwttoken.commom.excption;

import com.swb.springbootjwttoken.commom.utils.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @title: MyBusinessException
 * @author: 流沐颖
 * @date:2022/6/19 14:19
 * @description:
 * @version: study
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyBusinessException extends RuntimeException {

    /**
     * 业务异常出现代码
     */
    private Integer code;

    /**
     * 业务异常出现时提示的消息
     */
    private String msg;




}
