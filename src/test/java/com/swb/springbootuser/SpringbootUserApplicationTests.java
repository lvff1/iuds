package com.swb.springbootuser;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootUserApplicationTests {

    /**
     * 签名算法和数据不可暴露 所以便将其封装为静态常量进行保存
     */
    private static final Algorithm swbswb = Algorithm.HMAC256("swbswb");

    public static void main(String[] args) throws InterruptedException {

        // 生成头部信息
        Map<String, Object> map1 = new HashMap<>();
        map1.put("k1", "v1");

        // 获取当前时间 并进行相关的超时设置  3s  单位是毫秒
        long currentTimeMillis = System.currentTimeMillis()+3000;


        // 生成相关Token

        String token = JWT.create()
                // 设置头部信息 一般标注此token 实现什么算法等
                .withHeader(map1)
                // 设置负载信息 主要是相关用户信息
                .withClaim("username", "admin")
                .withClaim("password", "admin01")
                .withClaim("age", 18)

                // 设置过期时间  当前时间+3s
                .withExpiresAt(new Date(currentTimeMillis))
                // 设置签名
                .sign(swbswb);



        System.out.println(token);
        //Thread.sleep(4000);

        // 进行校验
        DecodedJWT verify = JWT.require(swbswb).build().verify(token);

        // 若不通过 一般会有以下异常抛出：
        //  01 - SignatureVerificationException:		签名不一致异常
        //  02 - TokenExpiredException:    			令牌过期异常
        //  03 - AlgorithmMismatchException:			算法不匹配异常
        //  04 -InvalidClaimException:				失效的payload异常
        //System.out.println(verify);


        // 通过后可以进行封装数据的读取
        // 头部
        Claim k1 = verify.getHeaderClaim("k1");

        // 负载
        String username = verify.getClaim("username").asString();
        Integer age = verify.getClaim("age").asInt();

        String signature = verify.getSignature().toString();


        System.out.println("姓名为："+username+"年龄为："+age);

        System.out.println("头部信息为："+k1.asString());
        System.out.println("签名信息为："+signature);

    }

}
