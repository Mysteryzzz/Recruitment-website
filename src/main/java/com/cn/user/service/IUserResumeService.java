package com.cn.user.service;

import com.cn.domain.User;
import com.cn.user.domain.Resume;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/11
 */
public interface IUserResumeService {

    void insertResume(Resume resume);

    Resume selectResume(Integer userId);

    void updateResume(Resume resume);

    Resume selectById(Integer id);

}
