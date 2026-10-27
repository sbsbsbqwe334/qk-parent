package com.qk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.entity.Dept;
import com.qk.mapper.DeptMapper;
import com.qk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public PageResult listDepts(String name, Integer status, Integer page, Integer pageSize) {
        //第一步：PageHelper开启分页
        PageHelper.startPage(page, pageSize);
        //第二步：查询数据
        List<Dept> list = deptMapper.listDepts(name,status);
        //第三步：拿到分页总数
       // long total = PageHelper.count(() -> deptMapper.listDepts(name,status));
        PageInfo pageInfo = new PageInfo(list);
        //第四步：封装返回数据
        return new PageResult(pageInfo.getTotal(), list);
    }
}
