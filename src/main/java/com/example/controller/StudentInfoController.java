package com.example.controller;


import com.example.common.Result;
import com.example.dao.StudentInfoDao;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.service.StudentInfoService;
import com.example.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @PutMapping
    public Result update(@RequestBody StudentInfo studentInfo){
        studentInfoService.update(studentInfo);
        return Result.success();
    }
}
