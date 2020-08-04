package com.dao;

import java.util.List;

import com.pojo.Course;

public interface ICourseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);
    
    List<Course> selectAllCourses();
    
    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}