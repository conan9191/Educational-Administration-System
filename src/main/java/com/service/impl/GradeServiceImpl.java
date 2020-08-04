package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IGradeDao;
import com.pojo.Grade;
import com.service.IGradeService;

@Service("gradeService")
@Transactional
public class GradeServiceImpl implements IGradeService {
	@Resource
	private IGradeDao gradeDao;

	@Override
	public int addGrade(Grade record) {
		// TODO Auto-generated method stub
		return gradeDao.insert(record);
	}

	@Override
	public Grade getOneGrade(Grade condition) {
		// TODO Auto-generated method stub
		return gradeDao.selectGradeByStudentNoAndCourseName(condition);
	}

	@Override
	public List<Grade> getAllGrades() {
		// TODO Auto-generated method stub
		return gradeDao.selectAllGrades();
	}
	
}
