package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.dao.StudentInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.StudentInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoDao studentInfoDao;

    public Account login(String name, String password) {

        StudentInfo studentInfo = studentInfoDao.findByNameAndPassword(name, password);
        if (ObjectUtil.isEmpty(studentInfo)){
            throw new CustomException("-1","用户名、密码或者角色错误");
        }
        return studentInfo;
    }

    public void register(StudentInfo studentInfo) {
        StudentInfo info = studentInfoDao.findByName(studentInfo.getName());
        if (ObjectUtil.isNotEmpty(info)){
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        studentInfoDao.insertSelective(studentInfo);
    }

    public StudentInfo findById(Long id) {
        return studentInfoDao.selectByPrimaryKey(id);
    }

    public void update(StudentInfo studentInfo) {
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }
}
