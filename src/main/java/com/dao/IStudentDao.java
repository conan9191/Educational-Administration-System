package com.dao;

import java.util.List;

import com.pojo.Student;

public interface IStudentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    
    Student selectByStudentNo(String studentNo);
    
    List<Student> selectAllStudents();
    
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}