package com.cn.company.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Company {
    @Id
    @GeneratedValue
    private Integer id;

    private String companyAllName;

    private String companyIntr;

    private String companyLocation;

    private String productIntr;

    private Date creationDate;

    private Integer createdBy;

    private Date lastUpdateDate;

    private Integer lastUpdatedBy;

    private String companyName;

    private String companyLogo;

    private String companyBussines;

    private String idCard;

    private String companyLocationInfo;

    private Integer hrId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyAllName() {
        return companyAllName;
    }

    public void setCompanyAllName(String companyAllName) {
        this.companyAllName = companyAllName == null ? null : companyAllName.trim();
    }

    public String getCompanyIntr() {
        return companyIntr;
    }

    public void setCompanyIntr(String companyIntr) {
        this.companyIntr = companyIntr == null ? null : companyIntr.trim();
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation == null ? null : companyLocation.trim();
    }

    public String getProductIntr() {
        return productIntr;
    }

    public void setProductIntr(String productIntr) {
        this.productIntr = productIntr == null ? null : productIntr.trim();
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.trim();
    }

    public String getCompanyBussines() {
        return companyBussines;
    }

    public void setCompanyBussines(String companyBussines) {
        this.companyBussines = companyBussines == null ? null : companyBussines.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getCompanyLocationInfo() {
        return companyLocationInfo;
    }

    public void setCompanyLocationInfo(String companyLocationInfo) {
        this.companyLocationInfo = companyLocationInfo == null ? null : companyLocationInfo.trim();
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }
}