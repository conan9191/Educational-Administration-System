package com.dao;

import java.util.List;

import com.pojo.Center;

public interface ICenterDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Center record);

    int insertSelective(Center record);

    Center selectByPrimaryKey(Integer id);
    
    List<Center> selectAllCenters();
    
    int updateByPrimaryKeySelective(Center record);

    int updateByPrimaryKey(Center record);
}