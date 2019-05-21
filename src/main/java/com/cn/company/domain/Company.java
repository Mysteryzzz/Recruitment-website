package com.cn.company.domain;

import com.cn.domain.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Company extends BaseDTO {
    @Id
    @GeneratedValue
    private Integer id;

    private String companyAllName;

    private String companyIntr;

    private String companyLocation;

    private String productIntr;

    private String companyName;

    private String companyLogo;

    private String companyBussines;

    private String idCard;

    private String companyLocationInfo;

    private Integer hrId;

    private String enable;

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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}