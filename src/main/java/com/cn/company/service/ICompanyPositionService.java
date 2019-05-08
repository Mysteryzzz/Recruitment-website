package com.cn.company.service;

import com.cn.company.domain.Position;
import com.cn.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/8
 */
public interface ICompanyPositionService {

    List<Position> queryPositionList(Integer page,Integer pageSize,User user);
}
