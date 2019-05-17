package com.cn.company.service;

import com.cn.domain.PositionRelation;
import com.cn.user.domain.Resume;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/14
 */
public interface ICompanyApplicationService {

    List<PositionRelation> queryCompanyApplication(Integer page, Integer pageSize, Integer companyId);

    void deleteById(Integer id);

    void bacthDeleteApplicaition(List<PositionRelation> list);

    void updateState(PositionRelation positionRelation);

    void insertApplication(Integer positionId, Resume resume );

    PositionRelation selectByUserIdAndPositionId(PositionRelation positionRelation);
}
