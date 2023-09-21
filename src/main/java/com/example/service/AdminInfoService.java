package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.AdminInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoService {

    @Autowired
    private AdminInfoDao adminInfoDao;

    public Account login(String name, String password) {

        AdminInfo adminInfo = adminInfoDao.findByNameAndPassword(name, password);

        if (ObjectUtil.isEmpty(adminInfo)){
            throw new CustomException("-1","用户名、密码和角色错误");
        }
        return adminInfo;
    }

    public AdminInfo findById(Long id) {
        return adminInfoDao.selectByPrimaryKey(id);
    }

    public void update(AdminInfo adminInfo) {
        adminInfoDao.updateByPrimaryKeySelective(adminInfo);
    }
}
