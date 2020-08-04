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

import com.pojo.Student;
import com.service.IStudentService;
import com.service.IUserService;

@Controller
@RequestMapping("/student") 
public class StudentController {
	@Resource
	private IStudentService studentService;
	@Resource
	private IUserService userService;
	@ResponseBody
	@RequestMapping(value="/getStudents",method = RequestMethod.GET)  
	 public Map<String,Object> getStudents(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Student> studentList = studentService.getAllStudents();
		 if(studentList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("studentList", studentList);
		 return modelMap;
	 }

	
	@ResponseBody
	 @RequestMapping(value="/getOneStudent",method = RequestMethod.GET)  
	 public Map<String,Object> getOneStudent(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String errno = "";
		 Student student = studentService.getOneStudent(id);
		 if(student == null) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("student", student);
		 return modelMap;
	 }		
	
	
	 
	 @ResponseBody
	 @RequestMapping(value="/deleteStudent",method = RequestMethod.POST)  
	 public Map<String,Object> deleteStudent(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = studentService.deleteStudent(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //仅能修改学生的档案 姓名 性别 组别
	 @ResponseBody
	 @RequestMapping(value="/updateStudent",method = RequestMethod.POST)  
	 public Map<String,Object> updateStudent(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String name = request.getParameter("name").trim();
		 String gender = request.getParameter("gender").trim();
		 int groupId = Integer.parseInt(request.getParameter("groupId").trim());
		 Student condition = studentService.getOneStudent(id);
		 condition.setId(id);
		 condition.setName(name);
		 condition.setGender(gender);
		 condition.setGroupId(groupId);
		 int result = studentService.updateStudent(condition);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	  
	 //仅能修改学生 组别  分组使用
	 @ResponseBody
	 @RequestMapping(value="/groupStudent",method = RequestMethod.POST)  
	 public Map<String,Object> groupStudent(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int groupId = Integer.parseInt(request.getParameter("groupId").trim());
		 Student condition = studentService.getOneStudent(id);
		 condition.setId(id);
		 condition.setGroupId(groupId);
		 int result = studentService.updateStudent(condition);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 } else {
			 errno = "0000";
			 modelMap.put("errno", errno);
		 }
	
		 return modelMap;
	 }
	
}
