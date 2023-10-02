package com.example.dao;

import com.example.entity.CourseSelectInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CourseSelectInfoDao extends Mapper<CourseSelectInfo> {

    @Select("select * from course_select_info where name=#{name} and teacherID=#{teacherID} and studentID=#{studentID}")
    CourseSelectInfo find(String name, Long teacherID, Long studentID);


    List<CourseSelectInfo> findByCondition(Long teacherID, Long studentID);
}
