package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.ClassObject;
import com.pojo.Course;
import com.pojo.Course_Chapter;
import com.pojo.Course_Type;
import com.pojo.Profession;
import com.pojo.School_Year;
import com.pojo.Semester;
import com.service.IEducationService;


@Controller
@RequestMapping("/education")
public class EducationController {
	@Resource
	private IEducationService educationService;
	
	//学年管理  涉及到 查所有 增 删 
	 @ResponseBody
	 @RequestMapping(value="/getSchoolYears",method = RequestMethod.GET)  
	 public Map<String,Object> getSchoolYears(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<School_Year> schoolYearList = educationService.getAllSchoolYears();
		 if(schoolYearList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("schoolYearList", schoolYearList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addSchoolYear",method = RequestMethod.POST)  
	 public Map<String,Object> addSchoolYear(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 String name = request.getParameter("name").trim();
		 School_Year record = new School_Year();
		 record.setName(name);
		 int result = educationService.addSchoolYear(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteSchoolYear",method = RequestMethod.POST)  
	 public Map<String,Object> deleteSchoolYear(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteSchoolYear(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //学期管理 增 涉及到 查所有 增 删
	 @ResponseBody
	 @RequestMapping(value="/getSemesters",method = RequestMethod.GET)  
	 public Map<String,Object> getSemesters(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Semester> semesterList = educationService.getAllSemesters();
		 if(semesterList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("semesterList", semesterList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addSemester",method = RequestMethod.POST)  
	 public Map<String,Object> addSemester(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int schoolYearId = Integer.parseInt(request.getParameter("schoolYearId").trim());
		 String trainingType = request.getParameter("trainingType").trim();
		 String name = request.getParameter("name").trim();
		 Semester record = new Semester();
		 record.setName(name);
		 record.setSchoolYearId(schoolYearId);
		 record.setTrainingType(trainingType);
		 int result = educationService.addSemester(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteSemester",method = RequestMethod.POST)  
	 public Map<String,Object> deleteSemester(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteSemester(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //专业管理 增 涉及到 查所有 增 删
	 @ResponseBody
	 @RequestMapping(value="/getProfessions",method = RequestMethod.GET)  
	 public Map<String,Object> getProfessions(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Profession> professionList = educationService.getAllProfessions();
		 if(professionList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("professionList", professionList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addProfession",method = RequestMethod.POST)  
	 public Map<String,Object> addProfession(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 String name = request.getParameter("name").trim();
		 Profession record = new Profession();
		 record.setName(name);
		 int result = educationService.addProfession(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteProfession",method = RequestMethod.POST)  
	 public Map<String,Object> deleteProfession(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteProfession(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //班级管理 增 涉及到 查所有 增 删
	 @ResponseBody
	 @RequestMapping(value="/getClasses",method = RequestMethod.GET)  
	 public Map<String,Object> getClasses(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<ClassObject> classList = educationService.getAllClasses();
		 if(classList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("classList", classList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addClass",method = RequestMethod.POST)  
	 public Map<String,Object> addClass(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 String name = request.getParameter("name").trim();
		 int centerId = Integer.parseInt(request.getParameter("centerId").trim());
		 int schoolYearId = Integer.parseInt(request.getParameter("schoolYearId").trim());		 
		 int professionId = Integer.parseInt(request.getParameter("professionId").trim());
		 ClassObject record = new ClassObject();
		 record.setName(name);
		 record.setCenterId(centerId);
		 record.setSchoolYearId(schoolYearId);
		 record.setProfessionId(professionId);
		 int result = educationService.addClass(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteClass",method = RequestMethod.POST)  
	 public Map<String,Object> deleteClass(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteClass(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //课程类型管理 增 涉及到 查所有 增 删
	 @ResponseBody
	 @RequestMapping(value="/getCourseTypes",method = RequestMethod.GET)  
	 public Map<String,Object> getCourseTypes(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Course_Type> courseTypeList = educationService.getAllCourseTypes();
		 if(courseTypeList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("courseTypeList", courseTypeList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addCourseType",method = RequestMethod.POST)  
	 public Map<String,Object> addCourseType(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 String name = request.getParameter("name").trim();
		 Course_Type record = new Course_Type();
		 record.setName(name);
		 int result = educationService.addCourseType(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteCourseType",method = RequestMethod.POST)  
	 public Map<String,Object> deleteCourseType(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteCourseType(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //课程管理 增 涉及到 查所有 增 删
	 @ResponseBody
	 @RequestMapping(value="/getCourses",method = RequestMethod.GET)  
	 public Map<String,Object> getCourses(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Course> courseList = educationService.getAllCourses();
		 if(courseList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("courseList", courseList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addCourse",method = RequestMethod.POST)  
	 public Map<String,Object> addCourse(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 String name = request.getParameter("name").trim();
		 String courseHour = request.getParameter("courseHour").trim();
		 String courseFile = request.getParameter("courseFile").trim();
		 Float proportion = Float.parseFloat(request.getParameter("proportion").trim());
		 int courseTypeId = Integer.parseInt(request.getParameter("courseTypeId").trim());
		 
		 Course record = new Course();
		 record.setName(name);
		 record.setCourseHour(courseHour);
		 record.setCourseFile(courseFile);
		 record.setProportion(proportion);
		 record.setCourseTypeId(courseTypeId);
		 int result = educationService.addCourse(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteCourse",method = RequestMethod.POST)  
	 public Map<String,Object> deleteCourse(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteCourse(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //课程章、节管理 增删改查
	 @ResponseBody
	 @RequestMapping(value="/getCourseChapters",method = RequestMethod.GET)  
	 public Map<String,Object> getCourseChapters(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Course_Chapter> courseChapterList = educationService.getAllCourseChapters();
		 if(courseChapterList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("courseChapterList", courseChapterList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addCourseChapter",method = RequestMethod.POST)  
	 public Map<String,Object> addCourseChapter(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 String name = request.getParameter("name").trim();
		 String content = request.getParameter("content").trim();
		 String chapterFile = request.getParameter("chapterFile").trim();
		 int courseId = Integer.parseInt(request.getParameter("courseId").trim());
		 int superiorId = Integer.parseInt(request.getParameter("superiorId").trim());
		 Course_Chapter record = new Course_Chapter();
		 record.setName(name);
		 record.setContent(content);
		 record.setChapterFile(chapterFile);
		 record.setCourseId(courseId);
		 record.setSuperiorId(superiorId);
		 int result = educationService.addCourseChapter(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteCourseChapter",method = RequestMethod.POST)  
	 public Map<String,Object> deleteCourseChapter(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = educationService.deleteCourseChapter(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
}
