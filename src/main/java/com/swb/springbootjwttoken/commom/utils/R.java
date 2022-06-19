package com.swb.springbootjwttoken.commom.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;

/**
 * @title: R
 * @author: 流沐颖
 * @date:2022/6/19 14:14
 * @description:
 * @version: study
 */
@Data
@AllArgsConstructor
@ToString

public class R extends HashMap {

    /**
     * 返回成功的代码  200
     *
     * @return
     */
    public static R ok() {
        R re = new R();
        re.put("code", 200);
        return re;
    }

    /**
     * 重载方法之一  提示code+msg
     *
     * @param msg
     * @return
     */
    public static R ok(String msg) {
        R re = ok();
        re.put("msg", msg);
        return re;
    }

    /**
     * 重载方法之一 提示code+data
     *
     * @param data
     * @return
     */
    public static R ok(Object data) {
        R re = ok();
        re.put("data", data);
        return re;

    }

    /**
     * 重载方法之一 提示code+msg+data
     *
     * @param msg
     * @param data
     * @return
     */
    public static R ok(String msg, Object data) {
        R re = ok();
        re.put("msg", msg);
        re.put("data", data);
        return re;
    }

    /**
     * 返回成功的代码  200
     *
     * @return
     */
    public static R error() {
        R re = new R();
        re.put("code", 500);
        return re;
    }

    /**
     * 重载方法之一  提示code+msg
     *
     * @param msg
     * @return
     */
    public static R error(String msg) {
        R re = error();
        re.put("msg", msg);
        return re;
    }

    /**
     * 重载方法之一 提示code+data
     *
     * @param data
     * @return
     */
    public static R error(Object data) {
        R re = error();
        re.put("data", data);
        return re;

    }

    /**
     * 重载方法之一 提示code+msg+data
     *
     * @param msg
     * @param data
     * @return
     */
    public static R error(String msg, Object data) {
        R re = error();
        re.put("msg", msg);
        re.put("data", data);
        return re;
    }

}