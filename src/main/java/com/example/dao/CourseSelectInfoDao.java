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


    List<CourseSelectInfo> findByCondition(Long teacherID, Long studentID, String name);

    @Select("select * from course_select_info where name like concat('%',#{name},'%')")
    List<CourseSelectInfo> findByNamePage(String name);

    @Select("select a.*, b.name teacherName from course_select_info a left join teacher_info b on a.teacherID=b.id ")
    List<CourseSelectInfo> findAll();

    @Select("select * from course_select_info where studentID=#{userId}")
    List<CourseSelectInfo> findByStudentId(Long userId);

    @Select("SELECT DISTINCT name, description, majorID, credit, teacherID, required_num, time, location FROM `course_select_info` WHERE teacherID=#{id}")
    List<CourseSelectInfo> findByTeacherIDDistinct(Long id);
}
