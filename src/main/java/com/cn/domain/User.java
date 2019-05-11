package com.cn.domain;


import com.cn.constant.AuthType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User extends BaseDTO {
    @Id
    @GeneratedValue
    private java.lang.Integer id;

    private String account;

    private String password;

    private String email;

    private String phone;

    private AuthType type;

    private String enable;

    private String salt;

    private Integer isResumed;
    public User() {

    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User(String account, String password, AuthType type) {
        this.account = account;
        this.password = password;
        this.type = type;
    }

    public User(String account, AuthType type) {
        this.account = account;
        this.type = type;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AuthType getType() {
        return type;
    }

    public void setType(AuthType type) {
        this.type = type;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void updateSalt(java.lang.Integer id, String salt) {

    }

    public Integer getIsResumed() {
        return isResumed;
    }

    public void setIsResumed(Integer isResumed) {
        this.isResumed = isResumed;
    }
}