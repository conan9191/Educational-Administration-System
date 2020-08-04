package com.dao;

import java.util.List;

import com.pojo.Staff;

public interface IStaffDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);
    
    List<Staff> selectAllStaffs();
    
    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}