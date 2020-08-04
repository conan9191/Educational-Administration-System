package com.dao;

import java.util.List;

import com.pojo.Equipment;

public interface IEquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    List<Equipment> selectAllEquipments();
    
    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}