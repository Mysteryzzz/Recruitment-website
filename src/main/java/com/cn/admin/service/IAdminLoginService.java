package com.cn.admin.service;

import com.cn.domain.User;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
public interface IAdminLoginService {
    User checkAdminAccount(User user);
}
