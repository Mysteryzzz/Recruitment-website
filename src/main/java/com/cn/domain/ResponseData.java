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
    private String message;
    @JsonInclude(Include.NON_NULL)
    private List<?> rows;
    private boolean success;
    @JsonInclude(Include.NON_NULL)
    private Long total;

    public ResponseData() {
        this.success = true;
    }

    public ResponseData(boolean success) {
        this.success = true;
        this.setSuccess(success);
    }

    public ResponseData(List<?> list) {
        this(true);
        this.setRows(list);
        if (list instanceof Page) {
            this.setTotal(((Page)list).getTotal());
        } else {
            this.setTotal((long)list.size());
        }

    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public List<?> getRows() {
        return this.rows;
    }

    public Long getTotal() {
        return this.total;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

