package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import com.cn.exception.HdmpException;
import com.cn.user.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/18
 */
@RequestMapping(value = "/user")
@Controller
public class UserLoginController
{

    @Autowired
    ILoginService loginService;
    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public ResponseData login(HttpServletRequest request, @RequestParam String account,@RequestParam String password )
    {
        HttpSession session = request.getSession();
        User user = new User(account,password);
        loginService.checkLogin(user);
        session.setAttribute("user",user);
        return  new  ResponseData(true);
    }
}
