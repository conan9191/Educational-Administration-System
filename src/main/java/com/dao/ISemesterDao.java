package com.dao;

import java.util.List;

import com.pojo.Semester;

public interface ISemesterDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Semester record);

    int insertSelective(Semester record);

    Semester selectByPrimaryKey(Integer id);
    
    List<Semester> selectAllSemesters();
    
    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);
}