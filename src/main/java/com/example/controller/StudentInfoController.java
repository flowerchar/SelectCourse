package com.example.controller;


import com.example.common.Result;
import com.example.dao.StudentInfoDao;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.service.StudentInfoService;
import com.example.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;  //StudentInfoService studentInfoService = new StudentInfoService();

//    @Autowired
//    private HttpServletRequest request;

    @PutMapping
    public Result update(@RequestBody StudentInfo studentInfo){
        studentInfoService.update(studentInfo);
        // return new Result("0", "成功")
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

    @GetMapping("/page")
    public Result findPage(Integer pageNum, Integer pageSize){
        PageInfo<StudentInfo> info = studentInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }

    @GetMapping("/page/{name}")
    public Result findPage(Integer pageNum, Integer pageSize, @PathVariable String name){
        PageInfo<StudentInfo> info = studentInfoService.findPageName(pageNum, pageSize, name);
        return Result.success(info);
    }

    @GetMapping("/export")
    public Result export(HttpServletResponse response){
        studentInfoService.exportCourseTable(response);
        return Result.success();
    }
}
