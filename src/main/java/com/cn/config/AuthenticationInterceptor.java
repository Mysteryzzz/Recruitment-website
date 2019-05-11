package com.cn.config;

import com.cn.annotation.Permission;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;

/**
 * @Author: ReZero
 * @Date: 5/11/19 5:05 PM
 * @Version 1.0
 */
@Aspect
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


    private static final LinkedList<String> validURLs = new LinkedList<>();
    private static final String userLoginURL = "user/userLogin";
    private static final String companyLoginURL = "company/companyLogin";

    static {
        validURLs.add(userLoginURL);
        validURLs.add(companyLoginURL);
    }

    private boolean valid(String url) {
        for (String validUrl : validURLs) {
            if (url.endsWith(validUrl)) {
                return true;
            }
        }
        return false;
    }

    @Around("execution(* com.cn.*.controller..*(..)) && @annotation(permission)")
    public Object beforeInterceptor(ProceedingJoinPoint joinPoint, Permission permission) {
        try {
            // valid unauthorized url
            Object[] args = joinPoint.getArgs();
            HttpServletRequest request = (HttpServletRequest) args[0];
            if (valid(request.getRequestURL().toString())) {
                return joinPoint.proceed();
            }

            //TODO delete unchecked permission but only checked user session plan
            if (request.getSession().getAttribute("user") != null) {
                return joinPoint.proceed();
            }
            // valid authorized url
            if (permission.module() == "") {
                //check module
                // false : return null
                if (permission.operation() == "") {
                    //check operation
                    // false : return null
                }
                return joinPoint.proceed();
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
        return null;
}


}