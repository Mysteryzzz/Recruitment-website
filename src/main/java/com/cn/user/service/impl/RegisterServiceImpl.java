package com.cn.user.service.impl;

import com.cn.dao.UserMapper;
import com.cn.domain.User;
import com.cn.user.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ReZero
 * @Date: 5/1/19 4:19 PM
 * @Version 1.0
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        userMapper.insertSelective(user);
    }
}
