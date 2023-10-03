package com.example.controller;

import com.example.common.Result;
import com.example.entity.CourseSelectInfo;
import com.example.service.CourseSelectInfoService;
import com.github.pagehelper.PageInfo;
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
        List<CourseSelectInfo> list = courseSelectInfoService.findAll();
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

    @GetMapping("/page/{name}")
    public Result findPageName(Integer pageNum, Integer pageSize,@PathVariable String name){
        PageInfo<CourseSelectInfo> info = courseSelectInfoService.findPageName(pageNum, pageSize, name);
        return Result.success(info);
    }

    @GetMapping("/page")
    public Result findPage(Integer pageNum, Integer pageSize){
        PageInfo<CourseSelectInfo> info = courseSelectInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }
}
