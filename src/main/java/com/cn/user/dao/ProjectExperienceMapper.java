package com.cn.user.dao;

import com.cn.user.domain.ProjectExperience;

import java.util.List;

public interface ProjectExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectExperience record);

    int insertSelective(ProjectExperience record);

    ProjectExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectExperience record);

    int updateByPrimaryKey(ProjectExperience record);

    List<ProjectExperience> queryListByResumeId(Integer resumeId);
}