package com.cn.user.service.impl;

import com.cn.user.dao.WorkExperienceMapper;
import com.cn.user.domain.WorkExperience;
import com.cn.user.service.IWorkExperienceService;
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
public class WorkExperienceServiceImpl implements IWorkExperienceService {

    @Autowired
    WorkExperienceMapper workExperienceMapper;


    @Override
    public void addResumeWork(WorkExperience workExperience) {

        workExperienceMapper.insertSelective(workExperience);
    }

    @Override
    public List<WorkExperience> queryListByResumeId(Integer resumeId) {
        return workExperienceMapper.queryListByResumeId(resumeId);
    }

    @Override
    public void updateResumeWork(WorkExperience workExperience) {
        workExperienceMapper.updateByPrimaryKeySelective(workExperience);
    }

    @Override
    public void deleteByid(Integer id) {
        workExperienceMapper.deleteByPrimaryKey(id);
    }
}
