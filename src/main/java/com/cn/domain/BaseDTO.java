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
    private Long createdBy;
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
    private Long lastUpdatedBy;
    @JsonIgnore
    @Column
    @Condition(
            exclude = true
    )
    private Date lastUpdateDate;

    public BaseDTO()
    {

    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
