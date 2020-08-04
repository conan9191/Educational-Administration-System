package com.dao;

import java.util.List;

import com.pojo.Role;

public interface IRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    Role selectRoleByUserId(Integer userId);
    
    Role selectRoleByName(String name);
    
    List<Role> selectALlRoles();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}