package com.cn.user.service;

import com.cn.domain.User;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
public interface IUserInfoService {

    void updateUserInfo(User user);

    User selectUserById(Integer id);
}
