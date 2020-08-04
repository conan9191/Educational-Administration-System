package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.IStudentDao;
import com.pojo.Note;
import com.pojo.Project;
import com.pojo.Student;
import com.service.IStudyService;

@Controller
@RequestMapping("/study") 
public class StudyController {
	
	@Resource
	private IStudyService studyService;
	@Resource
	private IStudentDao studentDao;
	private static Logger logger = Logger.getLogger(StudyController.class);
	
	//增加笔记  查询自己的笔记  删除笔记 更新笔记
	@ResponseBody
	@RequestMapping(value="/addNote",method = RequestMethod.POST)  
	 public Map<String,Object> addNote(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 String name = request.getParameter("name").trim();
		 int scheduleId = Integer.parseInt(request.getParameter("scheduleId").trim());
		 String content = request.getParameter("content").trim();
		 String projectFile = request.getParameter("projectFile").trim();
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		 Student student = studentDao.selectByStudentNo(username);
		 Note record = new Note();
		 record.setName(name);
		 record.setStudentId(student.getId());
		 record.setScheduleId(scheduleId);
		 record.setProjectFile(projectFile);
		 record.setContent(content);
		 int result = studyService.addNote(record);
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
	 @RequestMapping(value="/getOwnNote",method = RequestMethod.GET)  
	 public Map<String,Object> getOwnNote(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		//session中取到studentId 
		// int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		 Student student = studentDao.selectByStudentNo(username);
		 String errno = "";
		 Note record = studyService.getNoteByStudentId(student.getId());
		 if(record == null) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("note", record);
		 return modelMap;
	 }		
	
	
	 
//	 @ResponseBody
//	 @RequestMapping(value="/deleteNote",method = RequestMethod.POST)  
//	 public Map<String,Object> deleteStudent(HttpServletRequest request){
//		 Map<String,Object> modelMap = new HashMap<String,Object>();
//		 String errno = "";
//		 HttpSession session = request.getSession();
//		 String username = (String)session.getAttribute("username");
//		 Student student = studentDao.selectByStudentNo(username);
//		 int result = studyService.deleteNoteByStudentId(student.getId());
//		 if(result == 0) {
//			 errno = "0001";
//			 modelMap.put("errno", errno);
//			 return modelMap;
//		 }
//		 errno = "0000";
//		 modelMap.put("errno", errno);
//		 return modelMap;
//	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/updateNote",method = RequestMethod.POST)  
	 public Map<String,Object> updateNote(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		 Student student = studentDao.selectByStudentNo(username);
		 String content = request.getParameter("content");
		 Note record = studyService.getNoteByStudentId(student.getId());
		 record.setContent(content);
		 int result = studyService.updateNote(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //提交项目s
	 @ResponseBody
		@RequestMapping(value="/uploadProject",method = RequestMethod.POST)
		public Map<String,Object> uploadProject(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 //这里可以设置成从session中获取
			 //int studentId = Integer.parseInt(request.getParameter("studentId").trim());
			 HttpSession session = request.getSession();
			 String username = (String)session.getAttribute("username");
			 Student student = studentDao.selectByStudentNo(username);
			 //路径
			 String realPath = request.getSession().getServletContext().getRealPath("/upload/file");
			 //文件名
			 String originalFilename = file.getOriginalFilename();
			 logger.debug("realPath:"+realPath);
			 logger.debug("originalFilename:"+originalFilename);
			 //拼装成完整的路径
			 String path=realPath+"\\\\"+originalFilename;
			 File newFile=new File(path);
			 file.transferTo(newFile);
			 
			 Project record = new Project();
			 record.setStudentId(student.getId());
			 record.setProject(path);
			 //更新
			 int result = studyService.uploadProject(record);
			 if(result == 0) {
				 errno = "0001";
				 modelMap.put("errno", errno);
				 return modelMap;
			 }
			 errno = "0000";
			 modelMap.put("errno", errno);
			 modelMap.put("fileName", originalFilename);
			 return modelMap;
		}
	 
	  
}
