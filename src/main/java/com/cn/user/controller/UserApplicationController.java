package com.cn.user.controller;

import com.cn.controller.BaseController;
import com.cn.domain.PositionRelation;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import com.cn.user.service.IUserApplicationService;
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
public class UserApplicationController extends BaseController {


    @Autowired
    IUserApplicationService userApplicationService;

    @RequestMapping("/queryListApplication")
    @ResponseBody
    public ResponseData queryListAppliction(@RequestParam(value ="page",defaultValue = "1") Integer page, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request){
        User user = (User)getAttribute(request,"user");
        return new ResponseData(userApplicationService.queryListApplication(page,pageSize,user.getId()));
    }

    @ResponseBody
    @PostMapping("/deleteMyApplication")
    public ResponseData deleteMyApplication(@RequestParam("id") Integer id){
        userApplicationService.deleteMyApplication(id);
        return new ResponseData();
    }

    @ResponseBody
    @PostMapping("/batchDeleteMyApplication")
    public ResponseData batchDeleteMyApplication(@RequestBody List<PositionRelation> list){
        userApplicationService.bacthDelete(list);
        return new ResponseData();
    }
}
