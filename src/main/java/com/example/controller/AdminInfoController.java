package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping
    public Result add(@RequestBody AdminInfo adminInfo){
        adminInfoService.add(adminInfo);
        return Result.success();
    }

    @GetMapping("/importStu")
    public Result importStu() {
        try {
            String command = "python C:\\Users\\DELL\\PycharmProjects\\StageTwo\\mysql\\1-导入.py";
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
            process.waitFor(); // 等待进程执行完毕
            System.out.println("Python脚本执行完成");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Result.success();
    }


    @PutMapping
    public Result update(@RequestBody AdminInfo adminInfo){
        adminInfoService.update(adminInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<AdminInfo> list = adminInfoService.findAll();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        adminInfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        PageInfo<AdminInfo> info = adminInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }
    @GetMapping("/page/{name}")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @PathVariable String name){
        PageInfo<AdminInfo> info = adminInfoService.findPageName(pageNum, pageSize, name);
        return Result.success(info);
    }
}
