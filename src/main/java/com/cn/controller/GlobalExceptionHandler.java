package com.cn.controller;

import com.cn.domain.ResponseData;
import com.cn.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 异常处理handler
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseData allExceptionHandler(Exception e)
    {
        LOGGER.error(e.getMessage(),e);
        ResponseData responseData = new ResponseData(false);
        responseData.setMsg("网络问题，操作失败");
        return responseData;
    }

    @ExceptionHandler(MyException.class)
    public ResponseData myExceptionHandler(MyException e)
    {
        LOGGER.error(e.getMessage(),e);
        ResponseData responseData = new ResponseData(false);
        responseData.setMsg(e.getMessage());
        return responseData;
    }
}
