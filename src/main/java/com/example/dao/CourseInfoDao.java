package com.example.dao;

import com.example.entity.CourseInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CourseInfoDao extends Mapper<CourseInfo> {

    @Select("select * from course_info where name like concat('%',#{search},'%')")
    List<CourseInfo> findSearch(String search);
}
