package com.cn.controller;

import com.cn.domain.ResponseData;
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

    @Autowired
    private MessageSource messageSource;

    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler({Exception.class})
    public Object exceptionHandler(Exception exception, HttpServletRequest request) {
        this.logger.error(exception.getMessage(), exception);
        if (RequestUtil.isAjaxRequest(request)) {
            Throwable thr = this.getRootCause(exception);
            ResponseData res = new ResponseData(false);
            if (thr instanceof BaseException) {
                BaseException be = (BaseException)thr;
                Locale locale = RequestContextUtils.getLocale(request);
                String messageKey = be.getDescriptionKey();
                String message = this.messageSource.getMessage(messageKey, be.getParameters(), messageKey, locale);
                res.setCode(be.getCode());
                res.setMessage(message);
            } else {
                res.setMessage(thr.getMessage());
            }

            return res;
        } else {
            return new ModelAndView("500");
        }
    }

    private Throwable getRootCause(Throwable throwable) {
        while(throwable.getCause() != null) {
            throwable = throwable.getCause();
        }

        if (throwable instanceof OgnlException && ((OgnlException)throwable).getReason() != null) {
            return this.getRootCause(((OgnlException)throwable).getReason());
        } else {
            return throwable;
        }
    }
}
