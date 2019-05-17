package com.cn.company.dao;

import com.cn.company.domain.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> queryListBycompanyId(Integer companyId);

    List<Position> selectByPositionId(Integer id);

    int batchDelete(List<Position> list);

    List<Position> queryAllList(Position position);

    Position selectPosition(Integer id);
}