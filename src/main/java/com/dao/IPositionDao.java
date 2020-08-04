package com.dao;

import java.util.List;

import com.pojo.Position;

public interface IPositionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);
    
    List<Position> selectAllPositions();
    
    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    
}