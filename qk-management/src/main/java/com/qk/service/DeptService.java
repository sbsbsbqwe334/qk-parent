package com.qk.service;

import com.qk.common.PageResult;
import com.qk.entity.Dept;

public interface DeptService {
    /**
     * 添加部门
     */
    void addDept(Dept dept);

    PageResult listDepts(String name, Integer status, Integer page, Integer pageSize);

    Dept getDept(Integer id);

    void updateDept(Dept dept);

    void removeDept(Integer id);
}
