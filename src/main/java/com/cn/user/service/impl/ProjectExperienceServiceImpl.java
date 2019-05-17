package com.cn.user.service.impl;

import com.cn.user.dao.ProjectExperienceMapper;
import com.cn.user.domain.ProjectExperience;
import com.cn.user.service.IProjectExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/12
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ProjectExperienceServiceImpl implements IProjectExperienceService {

    @Autowired
    ProjectExperienceMapper projectExperienceMapper;

    @Override
    public void addResumeProject(ProjectExperience projectExperience) {
            projectExperienceMapper.insertSelective(projectExperience);
    }

    @Override
    public List<ProjectExperience> queryListByResumeId(Integer resumeId) {
        return projectExperienceMapper.queryListByResumeId(resumeId);
    }

    @Override
    public void updateResumeProject(ProjectExperience projectExperience) {
        projectExperienceMapper.updateByPrimaryKeySelective(projectExperience);
    }

    @Override
    public void deleteById(Integer id) {
        projectExperienceMapper.deleteByPrimaryKey(id);
    }
}
