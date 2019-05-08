package com.cn.company.controller;

import com.cn.company.service.CompanyHrInfoService;
import com.cn.controller.BaseController;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/5
 */
@RequestMapping("/company")
@Controller
public class CompanyHrInfoController extends BaseController {

    @Autowired
    CompanyHrInfoService hrInfoService;

    @PostMapping("/updateHrInfo")
    public ModelAndView updateHrInfo(HttpServletRequest request,User user)
    {
        User user1 = (User)getAttribute(request,"company");
        user.setId(user1.getId());
        hrInfoService.updateHrInfos(user);
        User hr_user = hrInfoService.selectHrInfo(user1.getId());
        ModelAndView modelAndView = new ModelAndView("company/hrInformation");
        modelAndView.addObject("hr",hr_user);
        return modelAndView;
    }

}
