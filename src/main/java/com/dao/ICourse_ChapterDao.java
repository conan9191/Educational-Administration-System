package com.dao;

import java.util.List;

import com.pojo.Course_Chapter;

public interface ICourse_ChapterDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Course_Chapter record);

    int insertSelective(Course_Chapter record);

    Course_Chapter selectByPrimaryKey(Integer id);
    
    List<Course_Chapter> selectAllCourseChapters();
    
    int updateByPrimaryKeySelective(Course_Chapter record);

    int updateByPrimaryKey(Course_Chapter record);
}