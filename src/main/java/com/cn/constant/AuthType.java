package com.cn.constant;

/**
 * @Author: ReZero
 * @Date: 5/1/19 4:28 PM
 * @Version 1.0
 */
public enum AuthType {
    ADMIN_TYPE(0), USER_TYPE(1), COMPANY_TYPE(2);
    int code;
    AuthType(Integer code){
        this.code = code;
    }

    public static AuthType getEnum(int code) {
        for (AuthType authType : AuthType.values()) {
            if (authType.getCode() == code) {
                return authType;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }
}
