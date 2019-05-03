package com.cn.company.service;

import com.cn.company.domain.Company;
import com.cn.domain.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/3
 */
public interface ICompanyRegisterService {

    void registerCompany(MultipartFile[] files, HttpServletRequest request, User user, Company company)throws IOException;
}
