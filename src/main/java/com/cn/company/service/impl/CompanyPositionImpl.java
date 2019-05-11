package com.cn.company.service.impl;

import com.cn.company.dao.CompanyMapper;
import com.cn.company.dao.PosiRequireMapper;
import com.cn.company.dao.PositionMapper;
import com.cn.company.dao.ResponsibilityMapper;
import com.cn.company.domain.Company;
import com.cn.company.domain.PosiRequire;
import com.cn.company.domain.Position;
import com.cn.company.domain.Responsibility;
import com.cn.company.service.ICompanyPositionService;
import com.cn.domain.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/8
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CompanyPositionImpl implements ICompanyPositionService {

    @Autowired
    PositionMapper positionMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    PosiRequireMapper posiRequireMapper;

    @Autowired
    ResponsibilityMapper responsibilityMapper;

    @Override
    public List<Position> queryPositionList(Integer page, Integer pageSize, User user) {
        Company company = companyMapper.selectByHrId(user.getId());
        PageHelper.startPage(page, pageSize);
        return positionMapper.queryListBycompanyId(company.getId());
    }

    @Override
    public void UpdateOrInsertPosition(User user, Position position) {

        if (position.getId() != null) {
            //更新操作
            //更新任职要求
            PosiRequire posiRequire = new PosiRequire(position.getRequireMessage(), position.getId());
            posiRequireMapper.updateByPositionIdSelective(posiRequire);
            //更新岗位职责
            Responsibility responsibility = new Responsibility(position.getResponseMessage(), position.getId());
            responsibilityMapper.updateByPositionIdSelective(responsibility);

            positionMapper.updateByPrimaryKeySelective(position);
        } else {
            //新增操作
            Company company = companyMapper.selectByHrId(user.getId());
            position.setCompanyId(company.getId());
            position.setState(1);
            positionMapper.insertSelective(position);
            //插入任职要求
            PosiRequire posiRequire = new PosiRequire(position.getRequireMessage(), position.getId());
            posiRequireMapper.insertSelective(posiRequire);

            //插入岗位职责
            Responsibility responsibility = new Responsibility(position.getResponseMessage(), position.getId());
            responsibilityMapper.insertSelective(responsibility);
        }

    }

    @Override
    public void deleteByPositionId(Integer id) {
        posiRequireMapper.deleteByPositionId(id);
        responsibilityMapper.deleteByPositionId(id);
        positionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Position> selectByPositionId(Integer id) {
        return positionMapper.selectByPositionId(id);
    }

    @Override
    public void batchDelete(List<Position> list) {
        if (!list.isEmpty()) {
            positionMapper.batchDelete(list);
        }
    }
}
