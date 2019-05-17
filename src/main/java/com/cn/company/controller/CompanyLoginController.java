package com.cn.company.controller;

import com.cn.company.service.ICompanyLoginService;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
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
 * @date: 2019/4/19
 */
@RequestMapping(value = "/company")
@Controller
public class CompanyLoginController {

    @Autowired
    ICompanyLoginService companyLoginService;

    @RequestMapping(value = "/companyLogin",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData companyLogin(HttpServletRequest request, @RequestParam String account, @RequestParam String password)
    {
        User user = companyLoginService.checkCompanyAcoount(new User(account,password));
        HttpSession session = request.getSession();
        session.setAttribute("company",user);
        return new ResponseData(true);
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return new ModelAndView("/company/login");
    }
}
