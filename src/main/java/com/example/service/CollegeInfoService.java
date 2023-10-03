package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.CollegeInfoDao;
import com.example.entity.CollegeInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public List<CollegeInfo> find(String search) {

        return collegeInfoDao.find(search);
    }

    public PageInfo<CollegeInfo> findPageName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<CollegeInfo> infos = collegeInfoDao.findByNamePage(name);
        return PageInfo.of(infos);
    }

    public PageInfo<CollegeInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CollegeInfo> infos = collegeInfoDao.findAll();
        return PageInfo.of(infos);
    }
}
