package com.cn.user.service.impl;

import com.cn.user.dao.ResumeMapper;
import com.cn.user.domain.Resume;
import com.cn.user.service.IUserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserResumeServiceImpl implements IUserResumeService {

    @Autowired
    ResumeMapper resumeMapper;

    @Override
    public void insertResume(Resume resume) {
        resumeMapper.insertSelective(resume);
    }

    @Override
    public Resume selectResume(Integer userId) {
        return resumeMapper.selectByUserId(userId);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeMapper.updateByPrimaryKeySelective(resume);
    }

    @Override
    public Resume selectById(Integer id) {
        return resumeMapper.selectByPrimaryKey(id);
    }
}
