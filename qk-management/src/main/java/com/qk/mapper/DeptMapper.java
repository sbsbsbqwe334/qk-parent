package com.qk.mapper;

import com.qk.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {

    /**
     * 添加部门
     */
    @Insert("insert into dept(name, status, create_time, update_time) values(#{name}, #{status}, #{createTime}, #{updateTime})")
    void insert(Dept dept);
}
