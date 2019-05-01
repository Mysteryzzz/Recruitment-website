package com.cn.user.controller;

import com.cn.domain.User;
import com.cn.constant.AuthType;
import com.cn.user.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: ReZero
 * @Date: 5/1/19 4:18 PM
 * @Version 1.0
 */
@Controller
public class UserRegisterController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping(value = "/userRegister")
    public ModelAndView register(User user) {
        user.setType(AuthType.USER_TYPE);
        user.setEnable("1");
        registerService.registerUser(user);
        return new ModelAndView("/user/login");
    }

}
