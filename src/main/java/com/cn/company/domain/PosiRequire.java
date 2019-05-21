package com.cn.company.domain;

import com.cn.domain.BaseDTO;

import java.util.Date;

public class PosiRequire extends BaseDTO {
    private Integer id;

    private Integer positionId;

    private String message;

    public PosiRequire()
    {

    }

    public  PosiRequire(String message,Integer positionId)
    {
        this.message = message;
        this.positionId = positionId;
    }

    public PosiRequire(String message)
    {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

}