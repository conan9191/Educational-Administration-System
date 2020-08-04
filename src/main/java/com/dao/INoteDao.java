package com.dao;

import com.pojo.Note;

public interface INoteDao {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByStudentId(Integer studentId);
    
    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer id);
    
    Note selectByStudentId(Integer studentId);
    
    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}