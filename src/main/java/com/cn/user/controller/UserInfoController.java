package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.User;
import com.cn.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
@RequestMapping("/user")
@Controller
public class UserInfoController extends BaseController {


    @Autowired
    IUserInfoService userInfoService;

    @PostMapping("/updateUserInfo")
    public ModelAndView updateUserInfo(HttpServletRequest request,User user){
        User user1 = (User)getAttribute(request,"user");
        user.setId(user1.getId());
        userInfoService.updateUserInfo(user);
        User userInfo = userInfoService.selectUserById(user1.getId());
        ModelAndView modelAndView = new ModelAndView("/user/userInfo");
        modelAndView.addObject("userInfo",userInfo);
        return modelAndView;
    }
}
