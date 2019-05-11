package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.User;
import com.cn.user.domain.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
@RequestMapping("/user")
@Controller
public class userResumeController extends BaseController {


    @RequestMapping("/createMyResume")
    public ModelAndView createMyResume(Resume resume, HttpServletRequest request){
        User user = (User)getAttribute(request,"user");
        resume.setUserId(user.getId());
        ModelAndView modelAndView = new ModelAndView("/user/myResume");
        return modelAndView;
    }
}
