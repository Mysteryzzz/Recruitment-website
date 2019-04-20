package com.cn.admin.controller;

import com.cn.admin.service.IAdminLoginService;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/19
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminLoginController {

    @Autowired
    IAdminLoginService loginService;

    @RequestMapping(value = "/adminLogin",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData adminLogin(HttpServletRequest request, @RequestParam String account,@RequestParam String password)
    {
        User user = loginService.checkAdminAccount(new User(account,password));
        HttpSession session = request.getSession();
        session.setAttribute("admin",user);
        return new ResponseData(true);
    }
}
