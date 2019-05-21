package com.cn.dao;

import com.cn.domain.PositionRelation;

import java.util.List;

public interface PositionRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PositionRelation record);

    int insertSelective(PositionRelation record);

    PositionRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PositionRelation record);

    int updateByPrimaryKey(PositionRelation record);

    List<PositionRelation> queryListApplicationByUserId(Integer userId);

    int updateUserDelete(Integer id);

    int updateCompanyDelete(Integer id);

    int batchUpdateUserDelete(List<PositionRelation> list);

    int batchUpdateCompanyDelete(List<PositionRelation> list);

    List<PositionRelation> queryListApplicationByCompanyId(Integer companyId);

    PositionRelation selectByUserIdAndPositionId(PositionRelation positionRelation);
}