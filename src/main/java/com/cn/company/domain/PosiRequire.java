package com.cn.company.domain;

import java.util.Date;

public class PosiRequire {
    private Integer id;

    private Integer positionId;

    private String message;

    private Date creationDate;

    private Integer createdBy;

    private Date lastUpdateDate;

    private Integer lastUpdatedBy;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}