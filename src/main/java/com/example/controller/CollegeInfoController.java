package com.example.controller;

import com.example.common.Result;
import com.example.entity.CollegeInfo;
import com.example.service.CollegeInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collegeInfo")
public class CollegeInfoController {

    @Autowired
    private CollegeInfoService collegeInfoService;

    @PostMapping
    public Result add(@RequestBody CollegeInfo collegeInfo){
        collegeInfoService.add(collegeInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<CollegeInfo> list = collegeInfoService.findAll();
        return Result.success(list);
    }

    @PutMapping
    public Result update(@RequestBody CollegeInfo collegeInfo){
        collegeInfoService.update(collegeInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        collegeInfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{search}")
    public Result find(@PathVariable String search){
        List<CollegeInfo> list = collegeInfoService.find(search);
        return Result.success(list);
    }

    @GetMapping("/page/{name}")
    public Result findPage(Integer pageNum, Integer pageSize, @PathVariable String name){
        PageInfo<CollegeInfo> info = collegeInfoService.findPageName(pageNum, pageSize, name);
        return Result.success(info);
    }

    @GetMapping("/page")
    public Result findPage(Integer pageNum, Integer pageSize){
        PageInfo<CollegeInfo> info = collegeInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }
}
