package com.cn.company.controller;

import com.cn.company.domain.Company;
import com.cn.company.service.ICompanyService;
import com.cn.controller.BaseController;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/7
 */
@RequestMapping("/company")
@Controller
public class CompanyInfoController  extends BaseController {

    @Autowired
    ICompanyService companyService;

    @RequestMapping(value = "/updateCompanyInfo",method = RequestMethod.POST)
    public ModelAndView updateCompanyInfo(HttpServletRequest request, Company company, @RequestParam(value = "file1")MultipartFile companyLogo,
                                          @RequestParam(value = "file2")MultipartFile idCard,@RequestParam(value = "file3")MultipartFile companyBussines) throws Exception {
        //获取session中的user信息
        User user =(User) getAttribute(request,"company");
        ModelAndView modelAndView = new ModelAndView("/company/companyInfo");
        company.setHrId(user.getId());
        //更新公司信息
        companyService.updateCompanyInfo(company,companyLogo,idCard,companyBussines);
        //查询公司信息
        Company companyInfo = companyService.selectCompanyInfo(user.getId());
        //查询后的公司信息放入域中
        modelAndView.addObject("companyInfo",companyInfo);
        return modelAndView;
    }
}
