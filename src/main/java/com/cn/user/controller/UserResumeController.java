package com.cn.user.controller;

import com.cn.company.service.ICompanyApplicationService;
import com.cn.controller.BaseController;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import com.cn.user.domain.ProjectExperience;
import com.cn.user.domain.Resume;
import com.cn.user.domain.WorkExperience;
import com.cn.user.service.IProjectExperienceService;
import com.cn.user.service.IUserResumeService;
import com.cn.user.service.IWorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
@RequestMapping("/user")
@Controller
public class UserResumeController extends BaseController {

    @Autowired
    IUserResumeService userResumeService;

    @Autowired
    IProjectExperienceService projectExperienceService;

    @Autowired
    IWorkExperienceService workExperienceService;

    @Autowired
    ICompanyApplicationService applicationService;

    @PostMapping("/createMyResume")
    public ModelAndView createMyResume(Resume resume, HttpServletRequest request){
        User user = (User)getAttribute(request,"user");
        resume.setUserId(user.getId());
        userResumeService.insertResume(resume);
        Resume myResume = userResumeService.selectResume(user.getId());
        ModelAndView modelAndView = new ModelAndView("/user/myResume");
        modelAndView.addObject("myResume",myResume);
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/selectResume")
    public ResponseData selectResume(HttpServletRequest request) {
        User user = (User)getAttribute(request,"user");
        List<Resume> list = new ArrayList<>();
        list.add(userResumeService.selectResume(user.getId()));
        return new ResponseData(list);
    }

    @ResponseBody
    @PostMapping("/updateMyResume")
    public ModelAndView updateMyResume(HttpServletRequest request,Resume resume){
        userResumeService.updateResume(resume);
        return new ModelAndView("/user/myResume");
    }


    @PostMapping("/addOrUpdateResumeProject")
    public ModelAndView addResumeProject(HttpServletRequest request, ProjectExperience projectExperience){
        User user =(User)getAttribute(request,"user");
        Resume resume = userResumeService.selectResume(user.getId());
        if(projectExperience.getId()!=null)
        {
            //更新操作
            projectExperienceService.updateResumeProject(projectExperience);
        }
        else {
            //插入操作
            projectExperience.setResumeId(resume.getId());
            projectExperienceService.addResumeProject(projectExperience);
        }
        return setMyResumeAttribute(resume);
    }

    @PostMapping("/addOrUpdateResumeWork")
    public ModelAndView addResumeWork(HttpServletRequest request,WorkExperience workExperience){
        User user = (User)getAttribute(request,"user");
        Resume resume= userResumeService.selectResume(user.getId());
        if(workExperience.getId()!=null){
            workExperienceService.updateResumeWork(workExperience);
        }
        else {
            workExperience.setResumeId(resume.getId());
            workExperienceService.addResumeWork(workExperience);
        }
        return setMyResumeAttribute(resume);
    }

    @ResponseBody
    @PostMapping("/deleteProjectById")
    public ResponseData deleteProjectById(HttpServletRequest request, @RequestBody ProjectExperience projectExperience){
        User user = (User)getAttribute(request,"user");
        Resume resume= userResumeService.selectResume(user.getId());
        projectExperienceService.deleteById(projectExperience.getId());
        return new ResponseData();
    }

    @ResponseBody
    @PostMapping("/deleteWorkById")
    public ResponseData deleteWorkById(HttpServletRequest request,@RequestBody WorkExperience workExperience){
        User user = (User)getAttribute(request,"user");
        Resume resume= userResumeService.selectResume(user.getId());
        workExperienceService.deleteByid(workExperience.getId());
        return new ResponseData();
    }

    private ModelAndView setMyResumeAttribute(Resume resume){
        List<ProjectExperience> projectExperiences = projectExperienceService.queryListByResumeId(resume.getId());
        List<WorkExperience> workExperiences = workExperienceService.queryListByResumeId(resume.getId());
        ModelAndView modelAndView = new ModelAndView("/user/myResume");
        modelAndView.addObject("projectList",projectExperiences);
        modelAndView.addObject("workList",workExperiences);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/isResumeCreate")
    public ResponseData isResumeCreate(HttpServletRequest request,@RequestParam(value = "id") Integer id){
        User user = (User)getAttribute(request,"user");
        Resume resume = userResumeService.selectResume(user.getId());
        if(resume!=null){
            applicationService.insertApplication(id,resume);
            return new ResponseData();
        }else {
            ResponseData responseData = new ResponseData();
            responseData.setMsg("请先去个人中心创建简历");
            return  responseData;
        }
    }
}
