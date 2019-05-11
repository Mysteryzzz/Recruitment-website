package com.cn.company.dao;

import com.cn.company.domain.Responsibility;

public interface ResponsibilityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Responsibility record);

    int insertSelective(Responsibility record);

    Responsibility selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Responsibility record);

    int updateByPrimaryKey(Responsibility record);

    int deleteByPositionId(Integer positionId);

    int updateByPositionIdSelective(Responsibility record);
}