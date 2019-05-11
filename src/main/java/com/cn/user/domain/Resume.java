package com.cn.user.domain;

import java.util.Date;

public class Resume {
    private Integer id;

    private String name;

    private String sex;

    private String nationCode;

    private String educationCode;

    private Integer phone;

    private String email;

    private String location;

    private String skills;

    private Double expectSalary;

    private Integer createdBy;

    private Date creationDate;

    private Integer lastUpdatedBy;

    private Date lastUpdateDate;

    private Integer userId;

    private String expectPosition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode == null ? null : nationCode.trim();
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode == null ? null : educationCode.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
    }

    public Double getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(Double expectSalary) {
        this.expectSalary = expectSalary;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExpectPosition() {
        return expectPosition;
    }

    public void setExpectPosition(String expectPosition) {
        this.expectPosition = expectPosition == null ? null : expectPosition.trim();
    }
}