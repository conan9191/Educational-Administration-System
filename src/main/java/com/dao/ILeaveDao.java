package com.dao;

import java.util.List;

import com.pojo.Leave;

public interface ILeaveDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer id);
    
    List<Leave> selectAllLeaves();
    
    Leave selectOneLeave(Integer studentid); 
    
    
    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);
    
    
}