package com.cn.company.controller;

import com.cn.company.domain.Company;
import com.cn.company.service.CompanyHrInfoService;
import com.cn.company.service.ICompanyService;
import com.cn.controller.BaseController;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/23
 */
@RequestMapping("/companyIframe")
@Controller
public class CompanyIframeController extends BaseController {

    @Autowired
    CompanyHrInfoService hrInfoService;

    @Autowired
    ICompanyService companyService;


    @RequestMapping("/hrInformation")
    public ModelAndView hrInformation(HttpServletRequest request)
    {
       User user =(User)getAttribute(request,"company");
       User hr_user = hrInfoService.selectHrInfo(user.getId());
       ModelAndView modelAndView = new ModelAndView("company/hrInformation");
       modelAndView.addObject("hr",hr_user);
        return modelAndView;
    }

    @RequestMapping("/companyInfo")
    public ModelAndView companyInfo(HttpServletRequest request)
    {
        User user =(User)getAttribute(request,"company");
        Company company = companyService.selectCompanyInfo(user.getId());
        ModelAndView modelAndView = new ModelAndView("/company/companyInfo");
        modelAndView.addObject("companyInfo",company);
        return  modelAndView;
    }

    @RequestMapping("/postRecruitment")
    public ModelAndView postRecruitment()
    {
        return  new ModelAndView("/company/postRecruitment");
    }

    @RequestMapping("/recruitmentList")
    public ModelAndView recruitmentList()
    {
        return  new ModelAndView("/company/recruitmentList");
    }

    @RequestMapping("/applicationCenter")
    public ModelAndView applicationCenter()
    {
        return  new ModelAndView("/company/applicationCenter");
    }

    @RequestMapping("/message")
    public ModelAndView message()
    {
        return new ModelAndView("message");
    }

}
