package com.example.service;


import com.example.dao.CourseInfoDao;
import com.example.entity.CourseInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInfoService {

    @Autowired
    private CourseInfoDao courseInfoDao;


    public void add(CourseInfo courseInfo) {
        courseInfoDao.insertSelective(courseInfo);
    }

    public List<CourseInfo> findAll() {
        return courseInfoDao.findAll();
    }

    public void update(CourseInfo courseInfo) {
        courseInfoDao.updateByPrimaryKeySelective(courseInfo);
    }

    public void delete(Long id) {
        courseInfoDao.deleteByPrimaryKey(id);
    }

    public List<CourseInfo> findSearch(String search) {

        return courseInfoDao.findSearch(search);
    }

    public PageInfo<CourseInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CourseInfo> infos = courseInfoDao.findAll();
        return PageInfo.of(infos);
    }

    public PageInfo<CourseInfo> findPageName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<CourseInfo> infos = courseInfoDao.findByNamePage(name);
        return PageInfo.of(infos);
    }
}
