package com.cn.user.service.impl;

import com.cn.dao.UserMapper;
import com.cn.domain.User;
import com.cn.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
