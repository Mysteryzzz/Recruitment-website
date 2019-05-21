package com.cn.dao;

import com.cn.domain.Annotation;

import java.util.List;

public interface AnnotationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Annotation record);

    int insertSelective(Annotation record);

    Annotation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Annotation record);

    int updateByPrimaryKey(Annotation record);

    List<Annotation> queryListUserMessage(Integer userId);

    int bacthDelete(List<Annotation> list);
}