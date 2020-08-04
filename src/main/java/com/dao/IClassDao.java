package com.dao;

import java.util.List;

import com.pojo.ClassObject;

public interface IClassDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassObject record);

    int insertSelective(ClassObject record);

    ClassObject selectByPrimaryKey(Integer id);

    List<ClassObject> selectALlClasses();
    
    int updateByPrimaryKeySelective(ClassObject record);

    int updateByPrimaryKey(ClassObject record);
}