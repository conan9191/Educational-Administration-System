package com.dao;

import java.util.List;

import com.pojo.Department;

public interface IDepartmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);
    
    List<Department> selectAllDepartments();
    
    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}