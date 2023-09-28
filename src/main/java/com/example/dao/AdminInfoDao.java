package com.example.dao;

import com.example.entity.Account;
import com.example.entity.AdminInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
//@org.apache.ibatis.annotations.Mapper
public interface AdminInfoDao extends Mapper<AdminInfo> {

    @Select("select * from admin_info where name=#{name} and password = #{password}")
    //这里不用Param
    AdminInfo findByNameAndPassword(@Param("name") String name,@Param("password") String password);

    @Select("select * from admin_info where name=#{name}")
    AdminInfo findByName(String name);
}
