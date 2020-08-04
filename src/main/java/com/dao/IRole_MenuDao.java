package com.dao;

import com.pojo.Role_Menu;

public interface IRole_MenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role_Menu record);

    int insertSelective(Role_Menu record);

    Role_Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role_Menu record);

    int updateByPrimaryKey(Role_Menu record);
}