package com.cn.company.controller;

import com.cn.company.service.ICompanyPositionService;
import com.cn.controller.BaseController;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/8
 */
@RequestMapping("/company")
@Controller
public class CompanyPositionController extends BaseController {

    @Autowired
    ICompanyPositionService positionService;


    @RequestMapping(value = "/queryListByCompanyId")
    @ResponseBody
    public ResponseData queryListByCompanyId( @RequestParam(value ="page",defaultValue = "1") Integer page,@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request)
    {
        User user = (User)getAttribute(request,"company");
        return new ResponseData(positionService.queryPositionList(page,pageSize,user));
    }
}
