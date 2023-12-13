package com.example.dao;

import com.example.entity.CourseInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CourseInfoDao extends Mapper<CourseInfo> {

    @Select("select a.*, b.name teacherName, c.name majorName from course_info a left join major_info c on a.majorID = c.id left join teacher_info b on a.teacherID=b.id where a.name like concat('%',#{search},'%')")
    List<CourseInfo> findSearch(String search);

    @Select("select a.*, b.name teacherName, c.name majorName from course_info a left join teacher_info b on a.teacherID=b.id left join major_info c on a.majorID = c.id")
    List<CourseInfo> findAll();

    @Select("select * from course_info where name=#{name} and teacherID=#{teacherID}")
    CourseInfo findByNameAndTeacher(String name, Long teacherID);

    @Select("select a.*, b.name teacherName, c.name majorName from course_info a  left join major_info c on a.majorID = c.id left join teacher_info b on a.teacherID=b.id where a.name like concat('%',#{name},'%')")
    List<CourseInfo> findByNamePage(String name);
}
