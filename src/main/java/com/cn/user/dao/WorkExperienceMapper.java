package com.cn.user.dao;

import com.cn.user.domain.WorkExperience;

import java.util.List;

public interface WorkExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkExperience record);

    int insertSelective(WorkExperience record);

    WorkExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkExperience record);

    int updateByPrimaryKey(WorkExperience record);

    List<WorkExperience> queryListByResumeId(Integer resumeId);
}