package com.cn.company.service.impl;

import com.cn.company.service.ICompanyLoginService;
import com.cn.dao.UserMapper;
import com.cn.domain.User;
import com.cn.exception.MyException;
import com.cn.constant.AuthType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CompanyLoginServiceImpl implements ICompanyLoginService {

    private static String ENABLE="0";
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkCompanyAcoount(User user) {
        user.setType(AuthType.COMPANY_TYPE);
        User user1 = userMapper.selectByAccount(user);
        if(userMapper.selectByAccount(new User(user.getAccount(), AuthType.COMPANY_TYPE))==null)
        {
            throw new MyException("用户名不存在");
        }
        if(user1==null)
        {
            throw new MyException("密码错误，请重新输入");
        }
        if(ENABLE.equals(user1.getEnable()))
        {
            throw new MyException("账户被冻结请联系管理员");
        }
        return user1;
    }
}
