package com.cn.company.service;

import com.cn.domain.Annotation;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/14
 */
public interface ICompnayMessageService {

    List<Annotation> queryCompanyMessage(Integer page,Integer pageSize,Integer userId);

    void deleteById(Integer id);

    void batchDelete(List<Annotation>list);
}
