package com.example.dao;

import com.example.entity.MajorInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MajorInfoDao extends Mapper<MajorInfo> {

    @Select("select * from major_info where name=#{name}")
    MajorInfo findByName(String name);

    @Select("select a.*, b.name as collegeName from major_info as a left join college_info b on a.collegeID = b.id where a.name like concat('%', #{search}, '%')")
    List<MajorInfo> findBySearch(String search);

    @Select("select a.*, b.name collegeName from major_info a left join college_info b on a.collegeID = b.id where a.name like concat('%',#{name},'%')")
    List<MajorInfo> findByNamePage(String name);

    @Select("select a.*, b.name collegeName from major_info a left join college_info b on a.collegeID = b.id")
    List<MajorInfo> findAll();
}
