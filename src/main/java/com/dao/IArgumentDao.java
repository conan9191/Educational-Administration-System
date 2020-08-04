package com.dao;

import com.pojo.Argument;

public interface IArgumentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Argument record);

    int insertSelective(Argument record);

    Argument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Argument record);

    int updateByPrimaryKey(Argument record);
}