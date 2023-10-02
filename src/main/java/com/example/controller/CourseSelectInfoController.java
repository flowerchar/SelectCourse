package com.example.controller;

import com.example.common.Result;
import com.example.entity.CourseSelectInfo;
import com.example.service.CourseSelectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/courseSelectInfo")
public class CourseSelectInfoController {

    @Autowired
    private CourseSelectInfoService courseSelectInfoService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public Result findAll(){
        List<CourseSelectInfo> list = courseSelectInfoService.findAll(request);
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        courseSelectInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody CourseSelectInfo courseSelectInfo){
        courseSelectInfoService.update(courseSelectInfo);
        return Result.success();
    }
}
