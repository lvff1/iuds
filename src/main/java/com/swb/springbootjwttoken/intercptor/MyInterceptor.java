package com.swb.springbootjwttoken.intercptor;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.swb.springbootjwttoken.commom.excption.MyInvalidClaimException;
import com.swb.springbootjwttoken.commom.excption.MyTokenExpiredException;
import com.swb.springbootjwttoken.commom.excption.MyTokenIsNullException;
import com.swb.springbootjwttoken.commom.utils.JwtUtils;
import com.swb.springbootjwttoken.context.TokenContext;
import com.swb.springbootjwttoken.entity.UserToken;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title: MyInterceptor
 * @author: 流沐颖
 * @date:2022/6/19 13:58
 * @description:
 * @version: study
 */
@Component
public class MyInterceptor implements HandlerInterceptor {


    /**
     * controller之前 做一些登录验证啥的  我们就先不管异常处理了
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("逮到你了！url地址为：【" + request.getRequestURI() + "】");

        //因为我们规定使用token的必须要放在请求头中  使用从header时拿到token值
        String token = request.getHeader("token");

        /**
         * 01 检验token是否非空
         */
        if (ObjectUtils.isEmpty(token)) {
            // 要在这个异常类中写相应了构造方法
            throw new MyTokenIsNullException(1000, "token不能为空，校验失败");
        }
        /**
         * 02 检验token是否合法  就是toke常见的四种异常
         */
        try {
            JwtUtils.checkToken(token);
        }catch (TokenExpiredException tee){
            // 超时
            throw new MyTokenExpiredException(1001, "token已过期，校验失败");
        }catch (InvalidClaimException ice){
            // 被篡改了
            throw new MyInvalidClaimException(1001, "token已经被窜改，校验失败");

        }

        // 解析出token中所携带的用户信息并将其存入本地线程池中


        UserToken userToken=JwtUtils.getUserToken(token);
        TokenContext.set(userToken);





        // false不放行！ true 放行
        return true;
    }

    /**
     * controller之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }


    /**
     * 数据渲染之后  关闭资源等操作
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
