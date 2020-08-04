package com.dao;

import java.util.List;

import com.pojo.Company;

public interface ICompanyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);
    
    List<Company> selectAllCompanys();
    
    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}