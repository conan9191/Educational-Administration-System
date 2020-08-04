package com.dao;

import java.util.List;

import com.pojo.Grade;

public interface IGradeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    Grade selectGradeByStudentNo(String studentNo);
    
    Grade selectGradeByStudentNoAndCourseName(Grade record);
    
    List<Grade> selectAllGrades();
    
    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}