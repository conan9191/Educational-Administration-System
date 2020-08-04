package com.dao;

import java.util.List;

import com.pojo.Classroom;

public interface IClassroomDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Classroom record);

    int insertSelective(Classroom record);
    
    Classroom selectByPrimaryKey(Integer id);
    
    List<Classroom> selectAllClassrooms();
    
    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
}