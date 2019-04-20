package com.cn.user.service;

import com.cn.domain.User;
import com.cn.exception.HdmpException;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/18
 */

public interface ILoginService
{
    User checkLogin(User user);
}
