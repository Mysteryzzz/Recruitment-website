package com.cn.company.service.impl;

import com.cn.company.domain.Company;
import com.cn.company.service.CompanyHrInfoService;
import com.cn.dao.UserMapper;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/5
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CompanyHrInfoImpl implements CompanyHrInfoService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void updateHrInfos(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectHrInfo(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
