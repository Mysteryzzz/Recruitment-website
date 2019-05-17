package com.cn.company.service.impl;

import com.cn.company.service.ICompnayMessageService;
import com.cn.dao.AnnotationMapper;
import com.cn.domain.Annotation;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/14
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CompanyMessageServiceImpl implements ICompnayMessageService {

    @Autowired
    AnnotationMapper annotationMapper;

    @Override
    public List<Annotation> queryCompanyMessage(Integer page, Integer pageSize, Integer userId) {

        PageHelper.startPage(page,pageSize);
        return annotationMapper.queryListUserMessage(userId);
    }

    @Override
    public void deleteById(Integer id) {
        annotationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(List<Annotation> list) {
        annotationMapper.bacthDelete(list);
    }
}
