package com.cn.user.service.impl;

import com.cn.dao.PositionRelationMapper;
import com.cn.domain.PositionRelation;
import com.cn.user.service.IUserApplicationService;
import com.github.pagehelper.PageHelper;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/13
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserApplicationServiceImpl implements IUserApplicationService {

    @Autowired
    PositionRelationMapper positionRelationMapper;

    @Override
    public List<PositionRelation> queryListApplication(Integer page, Integer pageSize, Integer userId) {
        PageHelper.startPage(page, pageSize);
        return positionRelationMapper.queryListApplicationByUserId(userId);
    }

    @Override
    public void deleteMyApplication(Integer id) {
        positionRelationMapper.updateUserDelete(id);
    }

    @Override
    public void bacthDelete(List<PositionRelation> list) {
        if(!list.isEmpty()){
            positionRelationMapper.batchUpdateUserDelete(list);
        }
    }
}
