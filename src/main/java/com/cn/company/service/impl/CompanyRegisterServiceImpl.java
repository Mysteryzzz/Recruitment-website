package com.cn.company.service.impl;

import com.cn.company.dao.CompanyMapper;
import com.cn.company.domain.Company;
import com.cn.company.service.ICompanyRegisterService;
import com.cn.constant.AuthType;
import com.cn.dao.UserMapper;
import com.cn.domain.User;
import com.cn.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/3
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CompanyRegisterServiceImpl implements ICompanyRegisterService {


    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void registerCompany(MultipartFile[] files, HttpServletRequest request, User user, Company company) throws IOException {

        //得到文件上传的保存目录
        String path = "D:/upload/";
        String companyLogo = path + Utils.makeFileName(files[0].getOriginalFilename());
        String companyIdCard = path + Utils.makeFileName(files[1].getOriginalFilename());
        String companyBussines = path + Utils.makeFileName(files[2].getOriginalFilename());
        company.setCompanyLogo(companyLogo);
        company.setIdCard(companyIdCard);
        company.setCompanyBussines(companyBussines);
        Utils.upload(files[0], companyLogo);
        Utils.upload(files[1], companyIdCard);
        Utils.upload(files[2], companyBussines);
        user.setType(AuthType.COMPANY_TYPE);
        user.setEnable("1");
        userMapper.insertSelective(user);
        company.setHrId(user.getId());
        companyMapper.insertSelective(company);

    }
}
