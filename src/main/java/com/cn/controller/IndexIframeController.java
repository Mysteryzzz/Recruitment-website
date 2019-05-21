package com.cn.controller;

import com.cn.annotation.Permission;
import com.cn.company.domain.Company;
import com.cn.company.domain.Position;
import com.cn.company.service.ICompanyApplicationService;
import com.cn.company.service.ICompanyPositionService;
import com.cn.company.service.ICompanyService;
import com.cn.domain.PositionRelation;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/4/25
 */
@RequestMapping("/indexIframe")
@Controller
public class IndexIframeController extends BaseController
{

    @Autowired
    ICompanyPositionService positionService;

    @Autowired
    ICompanyService companyService;

    @Autowired
    ICompanyApplicationService companyApplicationService;

    @Permission(module = "user")
    @RequestMapping("/positionList")
    public ModelAndView positionList(@RequestParam(value = "name",required = false) String name)
    {
        ModelAndView modelAndView = new ModelAndView("positionList");
        modelAndView.addObject("name",name);
        return modelAndView;
    }

    @RequestMapping("/positionInfo")
    public ModelAndView positionInfo(HttpServletRequest request, @RequestParam(value = "id") Integer id)
    {
        User user = (User)getAttribute(request,"user");
        PositionRelation positionRelation1 = new PositionRelation();
        if(user!=null){
            PositionRelation positionRelation = new PositionRelation();
            positionRelation.setUserId(user.getId());
            positionRelation.setPositionId(id);
            positionRelation1 = companyApplicationService.selectByUserIdAndPositionId(positionRelation);

        }
        ModelAndView modelAndView = new ModelAndView("positionInfo");
        modelAndView.addObject("isApplied",positionRelation1);
        Position position = positionService.selectPosition(id);
        modelAndView.addObject("position",position);
        return modelAndView;
    }

    @RequestMapping("/companyInfo")
    public ModelAndView companyInfo(@RequestParam("id") Integer id)
    {
        Company company = companyService.selectById(id);
        ModelAndView modelAndView  = new ModelAndView("companyInfo");
        modelAndView.addObject("companyInfo",company);
        return modelAndView;
    }

    @RequestMapping("/companyList")
    public ModelAndView companyList()
    {
        return  new ModelAndView("companyList");
    }

    @ResponseBody
    @RequestMapping("/queryNewPosition")
    public ResponseData queryNewPosition(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return new ResponseData(positionService.queryNewPosition(page,pageSize));
    }
}
