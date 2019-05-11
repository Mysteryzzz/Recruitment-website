package com.cn.config;

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

    @Around("execution(* com.cn.*.controller..*(..))")
    public Object beforeInterceptor(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        if (valid(request.getRequestURL().toString()) || (request.getSession().getAttribute("user") != null)) {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }


}
//
//    MethodSignature methodSignature = (MethodSignature)signature;
//    Method targetMethod = methodSignature.getMethod();
//
//    Class clazz = targetMethod.getClass();
//    if(clazz.isAnnotationPresent(Permission.class)){
//        //获取方法上注解中表明的权限
//        Permission permission = (Permission)clazz.getAnnotation(Permission.class);
//        String module = permission.module();
//        String operation = permission.operation();
//        Privilege privilege = new Privilege(new PrivilegePK(module, operation));
//        //获取当前用户拥有的权限
//        User user = (User)ContextUtils.getHttpSession().getAttribute("employer");
//        if(null != user){
//        System.out.println(user.getUsername());
//        }
//        Set<Role> roles = user.getRoles();
//        for(Role role : roles){
//        if(role.getPrivileges().contains(privilege)){
//        //如果当前用户拥有的权限包含方法注解上的权限,则执行被拦截到的方法
//        return pjp.proceed();
//        }
//        }
//        //如果没有权限,抛出异常,由Spring框架捕获,跳转到错误页面
//        throw new PermissionException();
//        }
//        return pjp.proceed();