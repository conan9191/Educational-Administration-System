package com.dao;

import java.util.List;

import com.pojo.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
    
    User selectByUsername(String username);
    
    int userIsExist(String username);
    
    int selectByUser(User record);
    
    List<User> selectAllUsers();
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}