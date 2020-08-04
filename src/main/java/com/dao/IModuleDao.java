package com.dao;

import java.util.List;

import com.pojo.Module;

public interface IModuleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer id);

    List<Module> selectAllModules();

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}