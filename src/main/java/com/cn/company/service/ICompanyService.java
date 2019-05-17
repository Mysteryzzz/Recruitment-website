package com.cn.company.service;

import com.cn.company.domain.Company;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/5
 */
public interface ICompanyService {

    void updateCompanyInfo(Company company, MultipartFile companyLogo, MultipartFile idCard, MultipartFile companyBussines) throws IOException;

    Company selectCompanyInfo(Integer hrId);

    List<Company> queryAllCompany(Integer page,Integer pageSize,Company company);

    Company selectById(Integer id);
}
