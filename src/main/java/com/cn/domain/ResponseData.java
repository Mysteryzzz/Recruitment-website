package com.cn.domain;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/17
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.pagehelper.Page;

import java.util.List;

public class ResponseData {
    @JsonInclude(Include.NON_NULL)
    private String code;
    @JsonInclude(Include.NON_NULL)
    private String msg;
    @JsonInclude(Include.NON_NULL)
    private List<?> data;
    private boolean success;
    @JsonInclude(Include.NON_NULL)
    private Long count;

    public ResponseData() {
        this.success = true;
    }

    public ResponseData(boolean success) {
        this.success = true;
        this.setSuccess(success);
    }

    public ResponseData(List<?> list) {
        this(true);
        this.code = "0";
        this.setData(list);
        if (list instanceof Page) {
            this.setCount(((Page)list).getTotal());
        } else {
            this.setCount((long)list.size());
        }

    }

    public String getCode() {
        return this.code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

