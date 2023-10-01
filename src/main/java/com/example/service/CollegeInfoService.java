package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.CollegeInfoDao;
import com.example.entity.CollegeInfo;
import com.example.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeInfoService {

    @Autowired
    private CollegeInfoDao collegeInfoDao;

    public void add(CollegeInfo collegeInfo) {
        CollegeInfo info = collegeInfoDao.findByName(collegeInfo.getName());
        if (ObjectUtil.isNotEmpty(info)){
            throw new CustomException("-1","该学院已经存在");
        }
        collegeInfoDao.insertSelective(collegeInfo);
    }

    public List<CollegeInfo> findAll() {
//        List<CollegeInfo> list = collegeInfoDao.selectAll();
        return collegeInfoDao.selectAll();
    }

    public void update(CollegeInfo collegeInfo) {
        collegeInfoDao.updateByPrimaryKeySelective(collegeInfo);
    }

    public void deleteById(Long id) {
        collegeInfoDao.deleteByPrimaryKey(id);
    }
}
