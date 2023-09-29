package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void add(AdminInfo adminInfo) {

        AdminInfo info = adminInfoDao.findByName(adminInfo.getName());
        if (ObjectUtil.isNotEmpty(info)){
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(adminInfo.getPassword())){
            adminInfo.setPassword("123456");
        }
        adminInfoDao.insertSelective(adminInfo);
    }

    public List<AdminInfo> findAll() {
        return adminInfoDao.selectAll();
    }

    public void deleteById(Long id) {
        adminInfoDao.deleteByPrimaryKey(id);
    }

    public PageInfo<AdminInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdminInfo> infos = adminInfoDao.selectAll();
        return PageInfo.of(infos);
    }

    public PageInfo<AdminInfo> findPageName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<AdminInfo> infos = adminInfoDao.findByNamePage(name);
        return PageInfo.of(infos);
    }
}
