package com.cn.company.service.impl;

import com.cn.company.dao.PositionMapper;
import com.cn.company.domain.Position;
import com.cn.company.service.ICompanyApplicationService;
import com.cn.constant.Constants;
import com.cn.dao.AnnotationMapper;
import com.cn.dao.PositionRelationMapper;
import com.cn.dao.UserMapper;
import com.cn.domain.Annotation;
import com.cn.domain.PositionRelation;
import com.cn.domain.User;
import com.cn.user.domain.Resume;
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
public class CompanyApplicationSercieImpl implements ICompanyApplicationService {

    @Autowired
    PositionRelationMapper positionRelationMapper;

    @Autowired
    AnnotationMapper annotationMapper;

    @Autowired
    PositionMapper positionMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<PositionRelation> queryCompanyApplication(Integer page, Integer pageSize, Integer companyId) {
        PageHelper.startPage(page, pageSize);
        return positionRelationMapper.queryListApplicationByCompanyId(companyId);
    }

    @Override
    public void deleteById(Integer id) {
            positionRelationMapper.updateCompanyDelete(id);
    }

    @Override
    public void bacthDeleteApplicaition(List<PositionRelation> list) {
            positionRelationMapper.batchUpdateCompanyDelete(list);
    }

    @Override
    public void updateState(PositionRelation positionRelation) {
        String message = "";
        String title = "";
        Annotation annotation = new Annotation();
        title = positionRelation.getPositionName()+"岗位投递结果";
        if(Constants.PASS.equals(positionRelation.getStatus())){
            annotation.setUserId(positionRelation.getUserId());
            annotation.setTitle(title);
            message="您应聘的"+positionRelation.getCompanyName()+"公司的"+positionRelation.getPositionName()+"岗位未通过.";
            annotation.setMessage(message);
        }else if(Constants.INVITE.equals(positionRelation.getStatus())) {
            annotation.setUserId(positionRelation.getUserId());
            annotation.setTitle(title);
            message="您应聘的"+positionRelation.getCompanyName()+"公司的"+positionRelation.getPositionName()+"岗位已通过！  请保持手机畅通，等待面试通知！.";
            annotation.setMessage(message);
        }
            annotationMapper.insertSelective(annotation);
            positionRelationMapper.updateByPrimaryKeySelective(positionRelation);
    }

    @Override
    public void insertApplication(Integer positionId, Resume resume) {
        PositionRelation positionRelation = new PositionRelation();
        Position position = positionMapper.selectPosition(positionId);
        positionRelation.setCompanyId(position.getCompanyId());
        positionRelation.setCompanyName(position.getCompanyName());
        positionRelation.setPositionId(position.getId());
        positionRelation.setPositionName(position.getPositionName());
        positionRelation.setStatus("等待回复");
        positionRelation.setUserId(resume.getUserId());
        positionRelation.setUserName(resume.getName());
        positionRelation.setCompanyDelete(0);
        positionRelation.setUserDelete(0);
        positionRelationMapper.insertSelective(positionRelation);
    }

    @Override
    public PositionRelation selectByUserIdAndPositionId(PositionRelation positionRelation) {
        return positionRelationMapper.selectByUserIdAndPositionId(positionRelation);
    }
}
