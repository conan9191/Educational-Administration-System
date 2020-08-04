package com.dao;

import java.util.List;

import com.pojo.School_Year;

public interface ISchool_YearDao {
    int deleteByPrimaryKey(Integer id);

    int insert(School_Year record);

    int insertSelective(School_Year record);

    School_Year selectByPrimaryKey(Integer id);
    
    List<School_Year> selectAllSchoolYears();
    
    int updateByPrimaryKeySelective(School_Year record);

    int updateByPrimaryKey(School_Year record);
}