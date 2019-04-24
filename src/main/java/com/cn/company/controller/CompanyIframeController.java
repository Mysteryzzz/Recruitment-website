package com.cn.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/23
 */
@RequestMapping("/companyIframe")
@Controller
public class CompanyIframeController {

    @RequestMapping("/hrInformation")
    public ModelAndView hrInformation()
    {
        return new ModelAndView("company/hrInformation");
    }

    @RequestMapping("/companyInfo")
    public ModelAndView companyInfo()
    {
        return  new ModelAndView("/company/companyInfo");
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
