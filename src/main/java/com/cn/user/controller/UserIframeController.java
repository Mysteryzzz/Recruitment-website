package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.User;
import com.cn.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
@Controller
@RequestMapping("/UserIframe")
public class UserIframeController extends BaseController {

    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping("/userInfos")
    public ModelAndView userInfos(){
        return new ModelAndView("/user/userInfos");
    }

    @RequestMapping("/userInfo")
    public ModelAndView userInfo(HttpServletRequest request)
    {
        User user = (User)getAttribute(request,"user");
        User userInfo = userInfoService.selectUserById(user.getId());
        request.getSession().setAttribute("user",userInfo);
        ModelAndView modelAndView =  new ModelAndView("/user/userInfo");
        modelAndView.addObject("userInfo",userInfo);
        return modelAndView;
    }

    @RequestMapping("/myResume")
    public ModelAndView myResume(){
        return new ModelAndView("/user/myResume");
    }

    @RequestMapping("/myApplication")
    public ModelAndView myApplication(){
        return new ModelAndView("/user/myApplication");
    }

    @RequestMapping("/myMessage")
    public ModelAndView myMessage(){
        return new ModelAndView("/user/myMessage");
    }
}
