package com.example.dao;

import com.example.entity.CollegeInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CollegeInfoDao extends Mapper<CollegeInfo> {

    @Select("select * from college_info where name=#{name}")
    CollegeInfo findByName(String name);

    @Select("select * from college_info where name like concat('%',#{search},'%')")
    List<CollegeInfo> find(String search);

    @Select("select * from college_info where name like concat('%', #{name}, '%')")  //    %会计%
    List<CollegeInfo> findByNamePage(String name);

//    @Select("select a.*, b.status status from course_info a left join course_select_info b on a.name=b.name and a.teacherID=b.teacherID")
//    List<CollegeInfo> findAll();
}
