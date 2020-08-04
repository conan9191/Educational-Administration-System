package com.service;

import java.util.List;

import com.pojo.Student;

public interface IStudentService {
	public int registerStudent(Student record);
	public int deleteStudent(int id);
	public int updateStudent(Student record);
	public List<Student> getAllStudents();
	public Student getOneStudent(int id);	
}
