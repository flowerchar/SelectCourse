package com.example.dao;

import com.example.entity.CourseInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CourseInfoDao extends Mapper<CourseInfo> {

    @Select("select a.*, b.name teacherName from course_info a left join teacher_info b on a.teacherID=b.id where a.name like concat('%',#{search},'%')")
    List<CourseInfo> findSearch(String search);

    @Select("select a.*, b.name teacherName from course_info a left join teacher_info b on a.teacherID=b.id")
    List<CourseInfo> findAll();
}
