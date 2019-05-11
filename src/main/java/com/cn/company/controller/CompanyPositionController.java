package com.cn.company.controller;

import com.cn.company.domain.Position;
import com.cn.company.service.ICompanyPositionService;
import com.cn.controller.BaseController;
import com.cn.domain.ResponseData;
import com.cn.domain.User;
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

    @ResponseBody
    @RequestMapping(value = "/insertPosition")
    public ResponseData insertOrUpdatePosition(HttpServletRequest request, Position position)
    {
        User user = (User)getAttribute(request,"company");
        positionService.UpdateOrInsertPosition(user,position);
        return  new ResponseData();
    }

    @ResponseBody
    @PostMapping("/deleteByPositionId")
    public ResponseData deleteByPositionId(@RequestParam("id") Integer id)
    {
        positionService.deleteByPositionId(id);
        return new ResponseData();
    }

    @PostMapping("/selectByPositionId")
    @ResponseBody
    public ResponseData selectByPositionId(@RequestParam("id") Integer id)
    {
        return new ResponseData(positionService.selectByPositionId(id));
    }

    @PostMapping("/batchDelete")
    @ResponseBody
    public ResponseData batchDelete(@RequestBody  List<Position> list)
    {
        positionService.batchDelete(list);
        return  new ResponseData();
    }
}
