package com.cn.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
public class HdmpException extends BaseException {
    private Logger logger = LoggerFactory.getLogger(HdmpException.class);

    public HdmpException(String code, String descriptionKey, Object[] parameters) {
        super(code, descriptionKey, parameters);
    }

    public HdmpException(String descriptionKey, Object[] parameters) {
        super((String)null, descriptionKey, parameters);
    }

    public HdmpException(String code, String descriptionKey) {
        super(code, descriptionKey, (Object[])null);
    }

    public HdmpException(String descriptionKey) {
        super((String)null, descriptionKey, (Object[])null);
    }

    public HdmpException(String descriptionKey, Exception e) {
        super((String)null, descriptionKey, (Object[])null);
        this.logger.error(e.getMessage(), e);
    }

    public HdmpException(String descriptionKey, Throwable t) {
        super((String)null, descriptionKey, (Object[])null);
        this.logger.error(descriptionKey, t);
    }

    public HdmpException(Throwable t) {
        super((String)null, t.getMessage(), (Object[])null);
        this.logger.error(t.getMessage(), t);
    }

    public HdmpException(Exception e) {
        super((String)null, e.getMessage(), (Object[])null);
        this.logger.error(e.getMessage(), e);
    }

    public HdmpException(Exception e, boolean flag) {
        super((String)null, e.getMessage(), (Object[])null);
        if (flag) {
            this.logger.error(e.getMessage(), e);
        }

    }

    public HdmpException(String code, String descriptionKey, Object[] parameters, Exception e) {
        super(code, descriptionKey, parameters);
        this.logger.error(descriptionKey, e);
    }

    public HdmpException(String code, String descriptionKey, Exception e) {
        super(code, descriptionKey, (Object[])null);
        this.logger.error(descriptionKey, e);
    }

    public HdmpException(String code, String descriptionKey, Object[] parameters, Throwable t) {
        super(code, descriptionKey, parameters);
        this.logger.error(descriptionKey, t);
    }

    public HdmpException(String code, String descriptionKey, Throwable t) {
        super(code, descriptionKey, (Object[])null);
        this.logger.error(descriptionKey, t);
    }

    public HdmpException(String descriptionKey, Object[] parameters, Exception e) {
        super((String)null, descriptionKey, parameters);
        this.logger.error(descriptionKey, e);
    }

    public HdmpException(String descriptionKey, Object[] parameters, Throwable t) {
        super((String)null, descriptionKey, parameters);
        this.logger.error(descriptionKey, t);
    }
}

