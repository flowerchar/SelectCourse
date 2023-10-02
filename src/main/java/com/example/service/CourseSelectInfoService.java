package com.example.service;


import com.example.dao.CourseSelectInfoDao;
import com.example.entity.CourseSelectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectInfoService {

    @Autowired
    private CourseSelectInfoDao courseSelectInfoDao;

    public List<CourseSelectInfo> findAll() {
        return courseSelectInfoDao.selectAll();
    }

    public void add(CourseSelectInfo courseSelectInfo) {
        courseSelectInfoDao.insertSelective(courseSelectInfo);
    }
}
