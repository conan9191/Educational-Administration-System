package com.dao;

import java.util.List;

import com.pojo.Course_Type;

public interface ICourse_TypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Course_Type record);

    int insertSelective(Course_Type record);

    Course_Type selectByPrimaryKey(Integer id);

    List<Course_Type> selectAllCourseTypes();
    
    int updateByPrimaryKeySelective(Course_Type record);

    int updateByPrimaryKey(Course_Type record);
}