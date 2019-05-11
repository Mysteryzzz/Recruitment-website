package com.cn.user.service.impl;

import com.cn.dao.UserMapper;
import com.cn.domain.User;
import com.cn.exception.MyException;
import com.cn.constant.AuthType;
import com.cn.user.service.ILoginService;
import com.cn.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/18
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class LoginServiceImpl implements ILoginService
{
    private static java.lang.Integer USER_TYPE=1;
    private static String ENABLE="0";

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkLogin(User user){
        user.setType(AuthType.USER_TYPE);
        user.setPassword(EncryptUtil.encryptByMD5(user.getPassword()));
        User user1 = userMapper.selectByAccount(user);
        if(userMapper.selectByAccount(new User(user.getAccount(), AuthType.USER_TYPE))==null)
        {
            throw new MyException("用户名不存在");
        }
        if(user1==null)
        {
            throw new MyException("密码错误,请重新输入");
        }
        if(ENABLE.equals(user1.getEnable()))
        {
            throw new MyException("账户被冻结请联系管理员");
        }
        return user1;
    }
}
