package com.cn.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/24
 */
@RequestMapping("/adminIframe")
@Controller
public class AdminIframeController {

    @RequestMapping("/companyManager")
    public ModelAndView companyManager()
    {
        return new ModelAndView("/admin/companyManager");
    }

    @RequestMapping("/messageManager")
    public ModelAndView messageManager()
    {
        return new ModelAndView("/admin/messageManager");
    }

    @RequestMapping("/userManager")
    public ModelAndView userManager()
    {
        return  new ModelAndView("/admin/userManager");
    }
}
