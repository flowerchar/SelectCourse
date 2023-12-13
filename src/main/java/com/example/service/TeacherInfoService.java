package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.dao.TeacherInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.TeacherInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoService {

    @Autowired
    private TeacherInfoDao teacherInfoDao;


//    public void register(TeacherInfo teacherInfo) {
//        TeacherInfo info = teacherInfoDao.findByName(teacherInfo.getName());
//        if (ObjectUtil.isNotEmpty(info)){
//            throw new CustomException(ResultCode.USER_EXIST_ERROR);
//        }
//
//        teacherInfoDao.insertSelective(teacherInfo);
//    }

    public Account login(String name, String password) {
        TeacherInfo teacherInfo = teacherInfoDao.findByNameAndPass(name, password);
        if (ObjectUtil.isEmpty(teacherInfo)){
            throw new CustomException("-1","用户名、密码或者角色错误");
        }
        return teacherInfo;
    }

    public TeacherInfo findById(Long id) {
        return teacherInfoDao.selectByPrimaryKey(id);
    }

    public void update(TeacherInfo teacherInfo) {
        teacherInfoDao.updateByPrimaryKeySelective(teacherInfo);
    }

    public List<TeacherInfo> findAll() {
        return teacherInfoDao.findAll();
//        return teacherInfoDao.selectAll();
    }

    public void add(TeacherInfo teacherInfo) {
        TeacherInfo info = teacherInfoDao.findByName(teacherInfo.getName());
        if (ObjectUtil.isNotEmpty(info)){
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(teacherInfo.getPassword())){
            teacherInfo.setPassword("123456");
        }
//        teacherInfo.setLevel(2);
        teacherInfoDao.insertSelective(teacherInfo);
    }

    public void deleteById(Long id) {
        teacherInfoDao.deleteByPrimaryKey(id);
    }

    public PageInfo<TeacherInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TeacherInfo> list = teacherInfoDao.findAll();
        return PageInfo.of(list);
    }

    public PageInfo<TeacherInfo> findPageSearch(String search, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TeacherInfo> teacherInfos = teacherInfoDao.findByLikeName(search);
        return PageInfo.of(teacherInfos);
    }
}
