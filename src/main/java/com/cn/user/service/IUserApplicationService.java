package com.cn.user.service;

import com.cn.domain.PositionRelation;
import javafx.application.Application;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/13
 */
public interface IUserApplicationService {

    List<PositionRelation> queryListApplication(Integer page, Integer pageSize, Integer userId);

    void deleteMyApplication(Integer id);

    void bacthDelete(List<PositionRelation> list);
}
