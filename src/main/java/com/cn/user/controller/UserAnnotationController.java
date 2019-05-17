package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.Annotation;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import com.cn.user.service.IUserAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/13
 */
@RequestMapping("/user")
@Controller
public class UserAnnotationController extends BaseController {

    @Autowired
    IUserAnnotationService annotationService;

    @ResponseBody
    @RequestMapping("/queryListUserMessage")
    public ResponseData queryListUserMessage(@RequestParam(value ="page",defaultValue = "1") Integer page, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request){
        User user =(User)getAttribute(request,"user");
        return new ResponseData(annotationService.queryListUserMessage(page,pageSize,user.getId()));
    }

    @ResponseBody
    @PostMapping("/batchDeleteAnnotation")
    public ResponseData bacthDeleteAnnotation(@RequestBody List<Annotation> list){
        annotationService.bacthDeleteAnnotation(list);
        return new ResponseData();
    }

    @ResponseBody
    @PostMapping("/deleteAnnotationById")
    public ResponseData deleteAnnotationById(@RequestParam("id") Integer id){
        annotationService.deleteById(id);
        return new ResponseData();
    }
}
