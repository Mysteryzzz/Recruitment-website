package com.cn.controller;

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
    public String hrInformation()
    {
        return "/company/hrImformation";
    }
}
