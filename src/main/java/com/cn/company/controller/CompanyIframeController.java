package com.cn.company.controller;

import com.cn.annotation.Permission;
import com.cn.company.domain.Company;
import com.cn.company.service.CompanyHrInfoService;
import com.cn.company.service.ICompanyService;
import com.cn.controller.BaseController;
import com.cn.domain.User;
import com.cn.user.domain.ProjectExperience;
import com.cn.user.domain.Resume;
import com.cn.user.domain.WorkExperience;
import com.cn.user.service.IProjectExperienceService;
import com.cn.user.service.IUserResumeService;
import com.cn.user.service.IWorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    IProjectExperienceService projectExperienceService;

    @Autowired
    IWorkExperienceService workExperienceService;

    @Autowired
    IUserResumeService userResumeService;

    @Permission(module = "company",operation = "")
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

    @Permission(module = "company",operation = "")
    @RequestMapping("/resume")
    public ModelAndView postRecruitment(@RequestParam(value = "userId",required = false) Integer userId)
    {
        Resume resume = userResumeService.selectResume(userId);
        List<ProjectExperience> projectExperiences = projectExperienceService.queryListByResumeId(resume.getId());
        List<WorkExperience> workExperiences = workExperienceService.queryListByResumeId(resume.getId());
        ModelAndView modelAndView = new ModelAndView("/company/resume");
        modelAndView.addObject("resume",resume);
        modelAndView.addObject("projectList",projectExperiences);
        modelAndView.addObject("workList",workExperiences);
        return  modelAndView;
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
        return new ModelAndView("/company/companyMessage");
    }

}
