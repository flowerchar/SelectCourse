package com.example.dao;

import com.example.entity.AdminInfo;
import com.example.entity.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
//@org.apache.ibatis.annotations.Mapper
public interface StudentInfoDao extends Mapper<StudentInfo> {

    @Select("select * from student_info where name=#{name} and password=#{password}")
    StudentInfo findByNameAndPassword(String name, String password);

    @Select("select * from student_info where name=#{name}")
    StudentInfo findByName(String name);
}
