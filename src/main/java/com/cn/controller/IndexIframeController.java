package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/25
 */
@RequestMapping("/indexIframe")
@Controller
public class IndexIframeController
{

    @RequestMapping("/positionList")
    public ModelAndView positionList()
    {
        return new ModelAndView("positionList");
    }

    @RequestMapping("/positionInfo")
    public ModelAndView positionInfo()
    {
        return new ModelAndView("positionInfo");
    }

    @RequestMapping("/companyInfo")
    public ModelAndView companyInfo()
    {
        return new ModelAndView("companyInfo");
    }

    @RequestMapping("/companyList")
    public ModelAndView companyList()
    {
        return  new ModelAndView("companyList");
    }
}
