package com.cn.company.service;

import com.cn.company.domain.Company;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/5
 */
public interface ICompanyService {

    void updateCompanyInfo(Company company, MultipartFile companyLogo, MultipartFile idCard, MultipartFile companyBussines) throws IOException;

    Company selectCompanyInfo(Integer hrId);
}
