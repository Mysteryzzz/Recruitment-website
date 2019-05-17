package com.cn.user.service.impl;

import com.cn.dao.AnnotationMapper;
import com.cn.domain.Annotation;
import com.cn.user.service.IUserAnnotationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/13
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserAnnotationServiceImpl implements IUserAnnotationService {

    @Autowired
    AnnotationMapper annotationMapper;

    @Override
    public List<Annotation> queryListUserMessage(Integer page, Integer pageSize, Integer userId) {
        PageHelper.startPage(page, pageSize);
        return annotationMapper.queryListUserMessage(userId);
    }

    @Override
    public void bacthDeleteAnnotation(List<Annotation> list) {
        if(!list.isEmpty()){
            annotationMapper.bacthDelete(list);
        }
    }

    @Override
    public void deleteById(Integer id) {
        annotationMapper.deleteByPrimaryKey(id);
    }
}
