package com.service;

import java.util.List;

import com.pojo.ClassObject;
import com.pojo.Course;
import com.pojo.Course_Chapter;
import com.pojo.Course_Type;
import com.pojo.Profession;
import com.pojo.School_Year;
import com.pojo.Semester;

public interface IEducationService {
	public int addSchoolYear (School_Year record);
	public int deleteSchoolYear(int id);
	public List<School_Year> getAllSchoolYears();
	
	public int addSemester (Semester record);
	public int deleteSemester(int id);
	public List<Semester> getAllSemesters();
	
	public int addProfession (Profession record);
	public int deleteProfession(int id);
	public List<Profession> getAllProfessions();
	
	public int addClass (ClassObject record);
	public int deleteClass(int id);
	public List<ClassObject> getAllClasses();
	
	public int addCourse (Course record);
	public int deleteCourse(int id);
	public List<Course> getAllCourses();
	
	public int addCourseType (Course_Type record);
	public int deleteCourseType(int id);
	public List<Course_Type> getAllCourseTypes();
	
	public int addCourseChapter (Course_Chapter record);
	public int deleteCourseChapter(int id);
	public List<Course_Chapter> getAllCourseChapters();
	
	
}
