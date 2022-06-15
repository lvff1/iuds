package com.swb.springbootempplus.commons;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;

/**
 * @title: R
 * @author: 流沐颖
 * @date:2022/6/15 13:26
 * @description: 统一返回值  result
 * @version: study
 */
@Data
public class R {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应返回的信息
     */
    private String msg;

    /**
     * 响应返回的数据信息
     */
    private Object data;


    /**
     * 只返回code
     *
     * @return
     */
    public static R ok() {
        R re = new R();
        re.setCode(200);
        return re;

    }

    /**
     * 返回提示信息 code
     *
     * @param msg
     * @return
     */
    public static R ok(String msg) {
        R re = ok();
        re.setMsg(msg);
        return re;
    }

    /**
     * 返回数据 code
     *
     * @param data
     * @return
     */
    public static R ok(Object data) {
        R re = ok();
        re.setData(data);
        return re;
    }

    /**
     * 返回提示信息及数据 code
     *
     * @param msg
     * @param data
     * @return
     */
    public static R ok(String msg, Object data) {
        R re = ok();
        re.setMsg(msg);
        re.setData(data);
        return re;
    }

    /**
     * 只返回code
     *
     * @return
     */
    public static R fail() {
        R re = new R();
        re.setCode(500);
        return re;

    }

    /**
     * 返回提示信息 code
     *
     * @param msg
     * @return
     */
    public static R fail(String msg) {
        R re = fail();
        re.setMsg(msg);
        return re;
    }

    /**
     * 返回数据 code
     *
     * @param data
     * @return
     */
    public static R fail(Object data) {
        R re = fail();
        re.setData(data);
        return re;
    }

    /**
     * 返回提示信息及数据 code
     *
     * @param msg
     * @param data
     * @return
     */
    public static R fail(String msg, Object data) {
        R re = fail();
        re.setMsg(msg);
        re.setData(data);
        return re;
    }


}
