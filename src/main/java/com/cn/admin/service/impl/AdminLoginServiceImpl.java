package com.cn.admin.service.impl;

import com.cn.admin.service.IAdminLoginService;
import com.cn.dao.UserMapper;
import com.cn.domain.User;
import com.cn.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
@Service
public class AdminLoginServiceImpl implements IAdminLoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkAdminAccount(User user) {
        User user1  =userMapper.selectByAccount(new User(user.getAccount(),user.getPassword(),0));
        if(user1==null)
        {
            throw new MyException("用户名或密码错误");
        }
        return user1;
    }
}
