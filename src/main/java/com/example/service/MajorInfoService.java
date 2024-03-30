package com.example.service;


import cn.hutool.core.util.ObjectUtil;
import com.example.dao.CollegeInfoDao;
import com.example.dao.MajorInfoDao;
import com.example.entity.CollegeInfo;
import com.example.entity.MajorInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorInfoService {

    @Autowired
    private MajorInfoDao majorInfoDao;
    @Autowired
    private CollegeInfoDao collegeInfoDao;

    public void add(MajorInfo majorInfo) {
        MajorInfo info = majorInfoDao.findByName(majorInfo.getName());
        if (ObjectUtil.isNotEmpty(info)){
            throw new CustomException("-1", "专业已存在");
        }
        majorInfoDao.insertSelective(majorInfo);
    }

    public List<MajorInfo> findAll() {
        List<MajorInfo> list = majorInfoDao.selectAll();
        for (MajorInfo majorInfo :
                list) {
            CollegeInfo info = collegeInfoDao.selectByPrimaryKey(majorInfo.getCollegeID());
            majorInfo.setCollegeName(info.getName());
        }
//        for (int  i;i<12;i++){
//            arr[i]
//        }
        return list;
    }

    public void update(MajorInfo majorInfo) {
        majorInfoDao.updateByPrimaryKeySelective(majorInfo);
    }

    public void deleteById(Long id) {
        majorInfoDao.deleteByPrimaryKey(id);
    }

    public List<MajorInfo> findSearch(String search) {
        return majorInfoDao.findBySearch(search);
    }

    public PageInfo<MajorInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MajorInfo> infos = majorInfoDao.findAll();
        return PageInfo.of(infos);
    }

    public PageInfo<MajorInfo> findPageName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<MajorInfo> infos = majorInfoDao.findByNamePage(name);
        return PageInfo.of(infos);
    }
}
