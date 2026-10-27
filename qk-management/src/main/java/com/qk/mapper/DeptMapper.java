package com.qk.mapper;

import com.qk.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 添加部门
     */
    @Insert("insert into dept(name, status, create_time, update_time) values(#{name}, #{status}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 查询部门列表
     */
    List<Dept> listDepts(String name, Integer status);

    /**
     * 根据id查询部门
     */
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);

    /**
     * 更新部门
     */
    void updateById(Dept dept);

    /**
     * 删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
