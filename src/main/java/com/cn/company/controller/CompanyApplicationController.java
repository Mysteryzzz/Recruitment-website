package com.cn.company.controller;

import com.cn.company.domain.Company;
import com.cn.company.service.ICompanyApplicationService;
import com.cn.company.service.ICompanyService;
import com.cn.controller.BaseController;
import com.cn.domain.PositionRelation;
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
public class CompanyApplicationController extends BaseController {

    @Autowired
    ICompanyApplicationService companyApplicationService;

    @Autowired
    ICompanyService companyService;

    @RequestMapping("/queryCompanyApplication")
    @ResponseBody
    public ResponseData queryCompanyApplication(@RequestParam(value ="page",defaultValue = "1") Integer page, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request){
        User user = (User)getAttribute(request,"company");
        Company company = companyService.selectCompanyInfo(user.getId());
        return new ResponseData(companyApplicationService.queryCompanyApplication(page,pageSize,company.getId()));
    }

    @PostMapping("/deleteCompanyAppById")
    @ResponseBody
    public ResponseData deleteCompanyApplicationById(@RequestParam("id") Integer id){
        companyApplicationService.deleteById(id);
        return new ResponseData();
    }

    @PostMapping("/batchDeleteCompanyApp")
    @ResponseBody
    public ResponseData batchDeleteCompanyApp(@RequestBody List<PositionRelation> list){
        companyApplicationService.bacthDeleteApplicaition(list);
        return new ResponseData();
    }

    @PostMapping("/updateApplicationState")
    @ResponseBody
    public ResponseData updateApplicationState(@RequestBody PositionRelation positionRelation){
        companyApplicationService.updateState(positionRelation);
        return new ResponseData();
    }
}
