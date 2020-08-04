package com.service;

import java.util.List;

import com.pojo.Grade;

public interface IGradeService {
	public int addGrade(Grade record);
	
	public Grade getOneGrade(Grade condition);
	
	public List<Grade> getAllGrades();
}
