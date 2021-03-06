package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import com.cn.exception.HdmpException;
import com.cn.user.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
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
public class UserLoginController {

    @Autowired
    ILoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ResponseData login(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        User user1 = new User(user.getAccount(), user.getPassword());
        user1 = loginService.checkLogin(user1);
        session.setAttribute("user", user1);
        String nextUrl = "/index.html";
        if (session.getAttribute("next_url") != null){
            nextUrl = session.getAttribute("next_url").toString();
        }
        return new ResponseData(true).setMsg(nextUrl);
    }

    @RequestMapping("/userLogout")
    public ModelAndView userLogout(HttpServletRequest request){
        request.getSession().invalidate();
        return new ModelAndView("/index");
    }

    @RequestMapping("/isLogin")
    @ResponseBody
    public ResponseData isLogin(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if(user!=null){
            return new ResponseData();
        }else {
            return new ResponseData(false);
        }
    }
}