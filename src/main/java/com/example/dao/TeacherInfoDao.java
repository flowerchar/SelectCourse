package com.example.dao;

import com.example.entity.AdminInfo;
import com.example.entity.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
//@org.apache.ibatis.annotations.Mapper
public interface TeacherInfoDao extends Mapper<TeacherInfo> {


    @Select("select * from teacher_info where name=#{name}")
    TeacherInfo findByName(String name);

    @Select("select * from teacher_info where name=#{name} and password =#{password}")
    TeacherInfo findByNameAndPass(String name, String password);

    @Select("select * from teacher_info where name like concat('%',#{search},'%')")
    List<TeacherInfo> findByLikeName(String search);
}
