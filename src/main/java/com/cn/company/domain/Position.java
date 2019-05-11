package com.cn.company.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Position {
    private Integer id;

    private String positionName;

    private Double salary;

    private Integer companyId;

    private Integer count;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer state;

    private String educationCode;

    private String locationCode;

    private String experienceCode;

    private Date creationDate;

    private Integer createdBy;

    private Date lastUpdateDate;

    private Integer lastUpdatedBy;

    private String requireMessage;

    private String responseMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode == null ? null : educationCode.trim();
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode == null ? null : locationCode.trim();
    }

    public String getExperienceCode() {
        return experienceCode;
    }

    public void setExperienceCode(String experienceCode) {
        this.experienceCode = experienceCode == null ? null : experienceCode.trim();
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

    public String getRequireMessage() {
        return requireMessage;
    }

    public void setRequireMessage(String requireMessage) {
        this.requireMessage = requireMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}