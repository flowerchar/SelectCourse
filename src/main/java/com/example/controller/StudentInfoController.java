package com.example.controller;


import com.example.common.Result;
import com.example.dao.StudentInfoDao;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.service.StudentInfoService;
import com.example.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Result findAll(){
        List<StudentInfo> list = studentInfoService.findAll();
        return Result.success(list);
    }

    @PostMapping
    public Result add(@RequestBody StudentInfo studentInfo){
        studentInfoService.add(studentInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        studentInfoService.deleteById(id);
        return Result.success();
    }
}
