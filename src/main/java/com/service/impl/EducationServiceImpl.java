package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IClassDao;
import com.dao.ICourseDao;
import com.dao.ICourse_ChapterDao;
import com.dao.ICourse_TypeDao;
import com.dao.IProfessionDao;
import com.dao.ISchool_YearDao;
import com.dao.ISemesterDao;
import com.pojo.Course;
import com.pojo.Course_Chapter;
import com.pojo.Course_Type;
import com.pojo.Profession;
import com.pojo.School_Year;
import com.pojo.Semester;
import com.pojo.ClassObject;
import com.service.IEducationService;
@Service("educationService")
@Transactional
public class EducationServiceImpl implements IEducationService {
	@Resource
	private ISchool_YearDao school_yearDao;
	@Resource
	private ISemesterDao semesterDao;
	@Resource
	private IProfessionDao professionDao;
	@Resource
	private IClassDao classDao;
	@Resource
	private ICourse_TypeDao course_typeDao;
	@Resource
	private ICourseDao courseDao;
	@Resource
	private ICourse_ChapterDao course_chapterDao;
	
	@Override
	public int addSchoolYear(School_Year record) {
		// TODO Auto-generated method stub
		return school_yearDao.insert(record);
	}
	@Override
	public int deleteSchoolYear(int id) {
		// TODO Auto-generated method stub
		return school_yearDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<School_Year> getAllSchoolYears() {
		// TODO Auto-generated method stub
		return school_yearDao.selectAllSchoolYears();
	}
	@Override
	public int addSemester(Semester record) {
		// TODO Auto-generated method stub
		return semesterDao.insert(record);
	}
	@Override
	public int deleteSemester(int id) {
		// TODO Auto-generated method stub
		return semesterDao.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<Semester> getAllSemesters() {
		// TODO Auto-generated method stub
		return semesterDao.selectAllSemesters();
	}
	@Override
	public int addProfession(Profession record) {
		// TODO Auto-generated method stub
		return professionDao.insert(record);
	}
	@Override
	public int deleteProfession(int id) {
		// TODO Auto-generated method stub
		return professionDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Profession> getAllProfessions() {
		// TODO Auto-generated method stub
		return professionDao.selectAllProfessions();
	}
	@Override
	public int addClass(ClassObject record) {
		// TODO Auto-generated method stub
		return classDao.insert(record);
	}
	@Override
	public int deleteClass(int id) {
		// TODO Auto-generated method stub
		return classDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<ClassObject> getAllClasses() {
		// TODO Auto-generated method stub
		return classDao.selectALlClasses();
	}
	@Override
	public int addCourse(Course record) {
		// TODO Auto-generated method stub
		return courseDao.insert(record);
	}
	@Override
	public int deleteCourse(int id) {
		// TODO Auto-generated method stub
		return courseDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.selectAllCourses();
	}
	
	
	@Override
	public int addCourseType(Course_Type record) {
		// TODO Auto-generated method stub
		return course_typeDao.insert(record);
	}
	@Override
	public int deleteCourseType(int id) {
		// TODO Auto-generated method stub
		return course_typeDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Course_Type> getAllCourseTypes() {
		// TODO Auto-generated method stub
		return course_typeDao.selectAllCourseTypes();
	}
	
	
	@Override
	public int addCourseChapter(Course_Chapter record) {
		// TODO Auto-generated method stub
		return course_chapterDao.insert(record);
	}
	@Override
	public int deleteCourseChapter(int id) {
		// TODO Auto-generated method stub
		return course_chapterDao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Course_Chapter> getAllCourseChapters() {
		// TODO Auto-generated method stub
		return course_chapterDao.selectAllCourseChapters();
	}
	
	
}
