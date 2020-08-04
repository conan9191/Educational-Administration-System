package com.dao;

import com.pojo.User_Role;

public interface IUser_RoleDao {
    int deleteByPrimaryKey(Integer id);
    
    int deleteRoleByUserId(Integer userId);
    
    int insert(User_Role record);

    int insertSelective(User_Role record);

    User_Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_Role record);

    int updateByPrimaryKey(User_Role record);
}