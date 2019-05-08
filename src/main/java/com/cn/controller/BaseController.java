package com.cn.controller;

import com.cn.domain.ResponseData;
import com.cn.domain.User;
import com.cn.exception.BaseException;
import com.cn.util.RequestUtil;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/17
 */
@Controller
public class BaseController
{

    protected static final String DEFAULT_PAGE = "1";
    protected static final String DEFAULT_PAGE_SIZE = "10";

    public Object getAttribute(HttpServletRequest request,String message)
    {
        Object attribute = request.getSession().getAttribute(message);
        return attribute;
    }
}
