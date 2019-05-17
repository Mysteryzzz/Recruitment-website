package com.cn.user.service;

import com.cn.domain.Annotation;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/13
 */
public interface IUserAnnotationService {

    List<Annotation> queryListUserMessage(Integer page, Integer pageSize, Integer userId);

    void bacthDeleteAnnotation(List<Annotation> list);

    void deleteById(Integer id);
}
