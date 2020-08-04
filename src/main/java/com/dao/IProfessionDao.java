package com.dao;

import java.util.List;

import com.pojo.Profession;

public interface IProfessionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer id);
    
    List<Profession> selectAllProfessions();
    
    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
}