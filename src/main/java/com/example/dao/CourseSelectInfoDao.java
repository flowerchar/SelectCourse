package com.example.dao;

import com.example.entity.CourseSelectInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CourseSelectInfoDao extends Mapper<CourseSelectInfo> {
}
