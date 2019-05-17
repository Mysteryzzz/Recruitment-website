package com.cn.user.service;

import com.cn.user.domain.ProjectExperience;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/12
 */
public interface IProjectExperienceService {

    void addResumeProject(ProjectExperience projectExperience);

    List<ProjectExperience> queryListByResumeId(Integer resumeId);

    void updateResumeProject(ProjectExperience projectExperience);

    void deleteById(Integer id);
}
