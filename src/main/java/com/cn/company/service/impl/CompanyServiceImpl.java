package com.cn.company.service.impl;

import com.cn.company.dao.CompanyMapper;
import com.cn.company.domain.Company;
import com.cn.company.service.ICompanyService;
import com.cn.constant.Constants;
import com.cn.util.QiniuUtil;
import com.cn.util.Utils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/5
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public void updateCompanyInfo(Company company, MultipartFile companyLogo, MultipartFile idCard, MultipartFile companyBussines) throws IOException {
        if(!companyLogo.isEmpty()) {
            String companyLogoPath =  QiniuUtil.fileUpload(companyLogo.getInputStream(), Utils.makeFileName(companyLogo.getOriginalFilename()));
            company.setCompanyLogo(companyLogoPath);
        }
        if(!idCard.isEmpty()) {
            String idCardPath = QiniuUtil.fileUpload(idCard.getInputStream(), Utils.makeFileName(idCard.getOriginalFilename()));
            company.setIdCard(idCardPath);
        }
        if (!companyBussines.isEmpty()) {
            String companyBussinesPath = QiniuUtil.fileUpload(companyBussines.getInputStream(), Utils.makeFileName(companyBussines.getOriginalFilename()));
            company.setCompanyBussines(companyBussinesPath);
        }
        companyMapper.updateByHrIdKeySelective(company);
    }

    @Override
    public Company selectCompanyInfo(Integer hrId) {
        return companyMapper.selectByHrId(hrId);
    }

    @Override
    public List<Company> queryAllCompany(Integer page,Integer pageSize ,Company company) {
        PageHelper.startPage(page,pageSize);
        return companyMapper.queryAllCompany(company);
    }

    @Override
    public Company selectById(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }
}
