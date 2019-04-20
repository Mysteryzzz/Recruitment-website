package com.cn.exception;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
public class MyException extends RuntimeException
{
    public MyException(String message)
    {
        super(message);
    }
}
