package com.cn.domain;

import com.cn.annotation.Condition;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/17
 */
public class BaseDTO implements Serializable {

    @JsonIgnore
    @Column(
            updatable = false
    )
    @Condition(
            exclude = true
    )
    private Integer createdBy;
    @JsonIgnore
    @Column(
            updatable = false
    )
    @Condition(
            exclude = true
    )
    private Date creationDate;
    @JsonIgnore
    @Column
    @Condition(
            exclude = true
    )
    private Integer lastUpdatedBy;
    @JsonIgnore
    @Column
    @Condition(
            exclude = true
    )
    private Date lastUpdateDate;

    public BaseDTO()
    {

    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
