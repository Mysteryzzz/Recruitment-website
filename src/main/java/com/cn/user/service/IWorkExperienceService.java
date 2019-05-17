package com.cn.user.service;

import com.cn.user.domain.WorkExperience;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/12
 */
public interface IWorkExperienceService {

    void addResumeWork(WorkExperience workExperience);

    List<WorkExperience> queryListByResumeId(Integer resumeId);

    void updateResumeWork(WorkExperience workExperience);

    void deleteByid(Integer id);
 }
