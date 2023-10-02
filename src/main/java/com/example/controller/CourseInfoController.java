package com.example.controller;


import com.example.common.Result;
import com.example.entity.CourseInfo;
import com.example.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseInfo")
public class CourseInfoController {

    @Autowired
    private CourseInfoService courseInfoService;

    @PostMapping
    public Result add(@RequestBody CourseInfo courseInfo){
        courseInfoService.add(courseInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<CourseInfo> list = courseInfoService.findAll();
        return Result.success(list);
    }

    @PutMapping
    public Result update(@RequestBody CourseInfo courseInfo){
        courseInfoService.update(courseInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        courseInfoService.delete(id);
        return Result.success();
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search){
        List<CourseInfo> list = courseInfoService.findSearch(search);
        return Result.success(list);
    }
}
