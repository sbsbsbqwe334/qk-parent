package com.qk.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Dept;
import com.qk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/depts")
    public Result listDept(String name, Integer status,
                           @RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10")Integer pageSize){
        PageResult pageResult = deptService.listDepts(name,status,page,pageSize);
        return Result.success(pageResult);
    }

    @GetMapping("/depts/{id}")
    public Result getDept(@PathVariable Integer id){
        Dept dept = deptService.getDept(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        deptService.removeDept(id);
        return Result.success();
    }
}
