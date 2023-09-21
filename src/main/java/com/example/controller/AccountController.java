package com.example.controller;


import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping("/login")
    public Result login(@RequestBody Account user, HttpServletRequest request){

        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "请完善输入信息");
        }
        Integer level = user.getLevel();
        Account loginUser = new Account();
        if (1==level){
            loginUser = adminInfoService.login(user.getName(), user.getPassword());
        }
        request.getSession().setAttribute("user", loginUser);
        return Result.success(loginUser);
    }

    @GetMapping("/getUser")
    public Result getUser(HttpServletRequest request){
        Account user = (Account) request.getSession().getAttribute("user");
        Integer level = user.getLevel();
        Account loginUser = new Account();
        if (1==level){
            AdminInfo adminInfo = adminInfoService.findById(user.getId());
            return Result.success(adminInfo);
        }

        return Result.success(new Account());
    }

}
