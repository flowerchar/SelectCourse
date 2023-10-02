package com.example.controller;

import com.example.common.Result;
import com.example.entity.CourseSelectInfo;
import com.example.service.CourseSelectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseSelectInfo")
public class CourseSelectInfoController {

    @Autowired
    private CourseSelectInfoService courseSelectInfoService;

    @GetMapping
    public Result findAll(){
        List<CourseSelectInfo> list = courseSelectInfoService.findAll();
        return Result.success(list);
    }
}
