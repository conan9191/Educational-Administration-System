package com.dao;

import java.util.List;

import com.pojo.Menu;

public interface IMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);
    
    List<Menu> selectAllMenus();
    
    List<Menu> selectAllParentMenus(Integer id);
    
    List<Menu> selectAllChildrenMenus(Integer id);
    
    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}