package com.dao;

import com.pojo.Project;

public interface IProjectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);
    
    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}