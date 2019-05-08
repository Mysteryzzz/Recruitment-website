package com.cn.company.service;

import com.cn.company.domain.Company;
import com.cn.domain.User;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/5
 */
public interface CompanyHrInfoService {

    void updateHrInfos(User user);

    User selectHrInfo(int id);
}
