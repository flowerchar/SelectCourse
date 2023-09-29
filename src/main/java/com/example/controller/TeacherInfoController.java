package com.example.controller;


import com.example.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacherInfo")
public class TeacherInfoController {

    @Autowired
    private TeacherInfoService teacherInfoService;


}
