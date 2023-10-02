package com.example.service;


import cn.hutool.core.util.ObjectUtil;
import com.example.dao.*;
import com.example.entity.*;
import com.example.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CourseSelectInfoService {

    @Autowired
    private CourseSelectInfoDao courseSelectInfoDao;

    @Autowired
    private MajorInfoDao majorInfoDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Autowired
    private CourseInfoDao courseInfoDao;

    public List<CourseSelectInfo> findAll(HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)){
            throw new CustomException("-1", "认证时间过期");
        }
        List<CourseSelectInfo> list;
        if (1==user.getLevel()){
            list = courseSelectInfoDao.selectAll();
        }else if(2==user.getLevel()){
            list =  courseSelectInfoDao.findByCondition(user.getId(), null);
        }else{
            list =  courseSelectInfoDao.findByCondition(null,user.getId());
        }


        for (CourseSelectInfo c :
                list) {
            MajorInfo majorInfo = majorInfoDao.selectByPrimaryKey(c.getMajorID());
            TeacherInfo teacherInfo = teacherInfoDao.selectByPrimaryKey(c.getTeacherID());
            StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(c.getStudentID());
            c.setMajorName(majorInfo.getName());
            c.setTeacherName(teacherInfo.getName());
            c.setStudentName(studentInfo.getName());
        }
        return list;
    }

    public void add(CourseSelectInfo courseSelectInfo) {
        courseSelectInfoDao.insertSelective(courseSelectInfo);
    }

    public CourseSelectInfo find(String name, Long teacherID, Long studentID) {
        return courseSelectInfoDao.find(name, teacherID, studentID);
    }

    public void delete(Long id) {

        CourseSelectInfo courseSelectInfo = courseSelectInfoDao.selectByPrimaryKey(id);
        CourseInfo courseInfo = courseInfoDao.findByNameAndTeacher(courseSelectInfo.getName(), courseSelectInfo.getTeacherID());
        courseSelectInfoDao.deleteByPrimaryKey(id);
        courseInfo.setSelectedNum(courseInfo.getSelectedNum()-1);
        courseInfoDao.updateByPrimaryKeySelective(courseInfo);
    }

    public void update(CourseSelectInfo courseSelectInfo) {
        courseSelectInfoDao.updateByPrimaryKeySelective(courseSelectInfo);
    }
}
