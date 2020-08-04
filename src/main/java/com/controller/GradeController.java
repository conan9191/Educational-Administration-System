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
import com.pojo.Grade;
import com.service.IGradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@Resource
	private IGradeService gradeService;
	//成绩管理涉及到 成绩录入 成绩查询 所有学生成绩查询
		 @ResponseBody
		 @RequestMapping(value="/getGrades",method = RequestMethod.GET)  
		 public Map<String,Object> getGrades(){
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 List<Grade> gradeList = gradeService.getAllGrades();
			 if(gradeList.size() == 0) {
				 errno = "0001";
				 modelMap.put("errno", errno);
				 return modelMap;
			 }
			 errno = "0000";
			 modelMap.put("errno", errno);
			 modelMap.put("gradeList", gradeList);
			 return modelMap;
		 }
		 
		 @ResponseBody
		 @RequestMapping(value="/getOneGrade",method = RequestMethod.GET)  
		 public Map<String,Object> getOneGrade(HttpServletRequest request) throws UnsupportedEncodingException{
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 request.setCharacterEncoding("UTF-8"); 
			 String studentNo = request.getParameter("studentNo").trim();
			 String courseName = request.getParameter("courseName").trim();
			 Grade condition = new Grade();
			 condition.setStudentNo(studentNo);
			 condition.setCoursename(courseName);
			 Grade record = gradeService.getOneGrade(condition);
			 if(record == null) {
				 errno = "0001";
				 modelMap.put("errno", errno);
				 return modelMap;
			 }
			 errno = "0000";
			 modelMap.put("errno", errno);
			 modelMap.put("grade", record);
			 return modelMap;
		 }
		
		 @ResponseBody
		 @RequestMapping(value="/addGrade",method = RequestMethod.POST)  
		 public Map<String,Object> addGrade(HttpServletRequest request) throws UnsupportedEncodingException{
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 request.setCharacterEncoding("UTF-8"); 
			 String studentNo = request.getParameter("studentNo").trim();
			 String courseName = request.getParameter("courseName").trim();
			 int grade = Integer.parseInt(request.getParameter("grade").trim());
			 Grade record = new Grade();
			 record.setStudentNo(studentNo);
			 record.setCoursename(courseName);
			 record.setGrade(grade);
			 int result = gradeService.addGrade(record);
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
