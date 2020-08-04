package com.dao;

import com.pojo.Employment;

public interface IEmploymentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Employment record);

    int insertSelective(Employment record);

    Employment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employment record);

    int updateByPrimaryKey(Employment record);
}