package com.cn.company.controller;

import com.cn.company.domain.Company;
import com.cn.company.service.ICompanyRegisterService;
import com.cn.domain.User;
import com.cn.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/1
 */
@RequestMapping("/company")
@Controller
public class CompanyRegisterController
{


    @Autowired
    ICompanyRegisterService registerService;

    @PostMapping("/Register")
    public ModelAndView companyRegister(User user,HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView("/company/companyRegister1");
        request.getSession().setAttribute("registerUser",user);
        return  modelAndView;
    }

    @PostMapping("/Register1")
    public ModelAndView companyRegister1(Company company, HttpServletRequest request, @RequestParam(value = "files")MultipartFile[] files) throws IOException
    {
        User user = (User) request.getSession().getAttribute("registerUser");
        registerService.registerCompany(files,request,user,company);
        return new ModelAndView("/company/login");
    }


}
