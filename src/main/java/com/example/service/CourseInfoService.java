package com.example.service;


import com.example.dao.CourseInfoDao;
import com.example.entity.CourseInfo;
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
        return courseInfoDao.selectAll();
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
}
