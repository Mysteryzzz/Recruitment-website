package com.cn.company.dao;

import com.cn.company.domain.PosiRequire;

public interface PosiRequireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PosiRequire record);

    int insertSelective(PosiRequire record);

    PosiRequire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PosiRequire record);

    int updateByPrimaryKey(PosiRequire record);

    int deleteByPositionId(Integer positionId);

    int updateByPositionIdSelective(PosiRequire record);
}