package com.cn.company.service.impl;

import com.cn.company.dao.CompanyMapper;
import com.cn.company.dao.PositionMapper;
import com.cn.company.domain.Company;
import com.cn.company.domain.Position;
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

    @Override
    public List<Position> queryPositionList(Integer page,Integer pageSize,User user) {
        Company company = companyMapper.selectByHrId(user.getId());
        PageHelper.startPage(page,pageSize);
        return positionMapper.queryListBycompanyId(company.getId());
    }
}
