package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IStudentDao;
import com.dao.IUserDao;
import com.pojo.Student;
import com.service.IStudentService;
@Service("studentService")
@Transactional
public class StudentServiceImpl implements IStudentService{
	@Resource
	private IStudentDao studentDao;
	@Resource
	private IUserDao userDao;
	@Override
	public int registerStudent(Student record) {
		// TODO Auto-generated method stub
		return studentDao.insert(record);
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student condition = studentDao.selectByPrimaryKey(id);
		int deleteId = condition.getUserId();
		userDao.deleteByPrimaryKey(deleteId);
		return studentDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStudent(Student record) {
		// TODO Auto-generated method stub
		return studentDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.selectAllStudents();
	}

	@Override
	public Student getOneStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.selectByPrimaryKey(id);
	}
	
}
