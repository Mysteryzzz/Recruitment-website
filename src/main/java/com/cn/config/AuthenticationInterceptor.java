package com.cn.config;

import com.cn.annotation.Permission;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
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

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

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

    @Around("execution(* com.cn..controller..*(..)) && @annotation(permission)")
    public Object beforeInterceptor(ProceedingJoinPoint joinPoint, Permission permission) {
        try {
            // valid unauthorized url
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            if (valid(request.getRequestURL().toString())) {
                return joinPoint.proceed();
            }

            //TODO delete unchecked permission but only checked user session plan


            logger.info(permission.module());
            // valid authorized url
            if ("user".equals(permission.module())) {
                //check module
                // false : return null

                if (request.getSession().getAttribute("user") != null) {
                    return joinPoint.proceed();
                } else {
                    request.getSession().setAttribute("next_url", request.getRequestURI());
                    return new ModelAndView("user/login");
                }
//                if (permission.operation() == "") {
//                    //check operation
//                    // false : return null
//                }
//                return joinPoint.proceed();
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
        return null;
}


}