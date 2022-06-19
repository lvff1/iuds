package com.swb.springbootjwttoken.commom.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.swb.springbootjwttoken.entity.UserToken;

import java.util.Date;

/**
 * @title: JwtUtils
 * @author: 流沐颖
 * @date:2022/6/19 16:36
 * @description: 供外界进行调用  快速生成token
 * @version: study
 */
public class JwtUtils {

    private static final String USERTOKEN = "token";

    // 超时时长  30min
    private static final long TOKEN_TIME_OUT = 30 * 60 * 1000;


    private static final Algorithm SWBSWB = Algorithm.HMAC256("swbswb");


    /**
     * 生成token 并将用户信息保存
     *
     * @param userToken
     * @return
     */
    public static String createToken(UserToken userToken) {

        // 将对象转json字符串  起到跨平台的作用
        String jsonString = JSON.toJSONString(userToken);

        // 进行生成token操作
        String token = JWT.create()
                .withClaim(USERTOKEN, jsonString)
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_TIME_OUT))
                .sign(SWBSWB);

        return token;

    }

    /**
     * 检查token是否合法  是否抛出以下几个异常
     * 01 - SignatureVerificationException:		签名不一致异常
     * 02 - TokenExpiredException:    			令牌过期异常
     * 03 - AlgorithmMismatchException:			算法不匹配异常
     * 04 - InvalidClaimException:				失效的payload异常
     *
     * @param token
     */
    public static DecodedJWT checkToken(String token) throws JWTVerificationException {
        DecodedJWT verify = JWT.require(SWBSWB).build().verify(token);
        return verify;

    }

    /**
     * 解析token取出值
     * @param token
     * @return
     */
    public static UserToken getUserToken(String token) {
        // 01  检验合法性
        DecodedJWT decodedJWT = checkToken(token);

        // 02 取出值
        String json = decodedJWT.getClaim(USERTOKEN).asString();

        // 返回对象
        return JSON.parseObject(json,UserToken.class);



    }
}
