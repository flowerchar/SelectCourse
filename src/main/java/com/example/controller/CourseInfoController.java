package com.example.controller;


import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.CourseInfo;
import com.example.entity.CourseSelectInfo;
import com.example.exception.CustomException;
import com.example.service.CourseInfoService;
import com.example.service.CourseSelectInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/courseInfo")
public class CourseInfoController {

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CourseSelectInfoService courseSelectInfoService;

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

    @PostMapping("/select")
    public Result select(@RequestBody CourseInfo courseInfo){

        Account user = (Account) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)){
            throw new CustomException("-1","认证时间过期");
        }

        CourseSelectInfo info = courseSelectInfoService.find(courseInfo.getName(), courseInfo.getTeacherID(), user.getId());
        if (ObjectUtil.isNotEmpty(info)){
            throw new CustomException("-1","禁止重复选课！");
        }

        CourseSelectInfo courseSelectInfo = new CourseSelectInfo();
        BeanUtils.copyProperties(courseInfo, courseSelectInfo);
        courseSelectInfo.setId(null);

        courseSelectInfo.setStudentID(user.getId());
        courseSelectInfo.setStatus("待开课");

        courseSelectInfoService.add(courseSelectInfo);

        courseInfo.setSelectedNum(courseInfo.getSelectedNum()+1);
        courseInfoService.update(courseInfo);

        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(Integer pageNum, Integer pageSize){
        PageInfo<CourseInfo> info = courseInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }

    @GetMapping("/page/{name}")
    public Result findPage(Integer pageNum, Integer pageSize, @PathVariable String name){
        PageInfo<CourseInfo> info = courseInfoService.findPageName(pageNum, pageSize, name);
        return Result.success(info);
    }
}
