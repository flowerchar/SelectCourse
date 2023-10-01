package com.example.dao;

import com.example.entity.CollegeInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CollegeInfoDao extends Mapper<CollegeInfo> {

    @Select("select * from college_info where name=#{name}")
    CollegeInfo findByName(String name);
}
