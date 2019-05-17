package com.cn.company.dao;

import com.cn.company.domain.Company;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    Company selectByHrId(Integer hrId);

    int updateByHrIdKeySelective(Company company);

    List<Company> queryAllCompany(Company company);
}