package com.cn.company.controller;

import com.cn.company.service.ICompnayMessageService;
import com.cn.controller.BaseController;
import com.cn.domain.Annotation;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/14
 */
@RequestMapping("/company")
@Controller
public class CompanyMessageController  extends BaseController {

    @Autowired
    ICompnayMessageService compnayMessageService;

    @RequestMapping("/queryCompanyMessage")
    @ResponseBody
    public ResponseData queryCompanyMessage(@RequestParam(value ="page",defaultValue = "1") Integer page, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request){
        User user = (User)getAttribute(request,"company");
        return new ResponseData(compnayMessageService.queryCompanyMessage(page,pageSize,user.getId()));
    }

    @PostMapping("/deleteCompanyMessageById")
    @ResponseBody
    public ResponseData deleteCompanyMessageById(@RequestParam("id") Integer id){
        compnayMessageService.deleteById(id);
        return new ResponseData();
    }

    @PostMapping("/batchdeleteCompanyMessage")
    @ResponseBody
    public ResponseData batchdeleteCompanyMessage(@RequestBody List<Annotation> list){
        compnayMessageService.batchDelete(list);
        return new ResponseData();
    }
}
