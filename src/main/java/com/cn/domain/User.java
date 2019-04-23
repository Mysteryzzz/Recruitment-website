package com.cn.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User extends BaseDTO {
    @Id
    @GeneratedValue
    private Integer id;

    private String account;

    private String password;

    private String email;

    private String phone;

    private Integer type;

    private String enable;


    public User()
    {

    }

    public User(String account,String password)
    {
        this.account = account;
        this.password = password;
    }
    public User(String account,String password,Integer type)
    {
        this.account = account;
        this.password = password;
        this.type = type;
    }

    public User(String account,Integer type)
    {
        this.account = account;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

}