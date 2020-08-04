package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.pojo.Attendance;
import com.pojo.Leave;
import com.pojo.Student;
import com.service.IAttendanceService;

@Controller
@RequestMapping("/attendance") 
public class AttendanceController {
	@Resource
	private IAttendanceService attendanceService;
	@Resource
	private IStudentDao studentDao;
	private static Logger logger = Logger.getLogger(AttendanceController.class);
	//签到打卡
	 @ResponseBody
	 @RequestMapping(value="/sign",method = RequestMethod.POST)  
	 public Map<String,Object> sign(HttpServletRequest request) {
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 //int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		 Student student = studentDao.selectByStudentNo(username);
		 Attendance record = new Attendance();
		 record.setStudentId(student.getId());
		 record.setClockDate(new Date());
		 int result = attendanceService.sign(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	//请假
	@ResponseBody
	@RequestMapping(value="/askForLeave",method = RequestMethod.POST)
	public Map<String,Object> askForLeave(HttpServletRequest request) {
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 //int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		 Student student = studentDao.selectByStudentNo(username);
		 String leaveType = request.getParameter("leaveType");
		 Leave record = new Leave();
		 record.setStudentid(student.getId());
		 record.setLeavetype(leaveType);
		 int result = attendanceService.askForLeave(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	}
	
	//上传假条  根据学号上传假条
	@ResponseBody
	@RequestMapping(value="/uploadPhoto",method = RequestMethod.POST)
	public Map<String,Object> uploadPhoto(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
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
		 Leave record = attendanceService.getOneLeave(student.getId());
		 //保存路径
		 record.setPhoto(path);
		 //更新
		 int result = attendanceService.updateLeave(record);
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
	
	
	//管理员获得请假列表
	@ResponseBody
	@RequestMapping(value="/getAllLeaves",method = RequestMethod.GET)
	public Map<String,Object> getAllLeaves(HttpServletRequest request) {
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Leave> leaveList = attendanceService.getAllLeaves();
		 int result = leaveList.size();
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("leaveList", leaveList);
		 return modelMap;
	}
	
	//管理员批准
	@ResponseBody
	@RequestMapping(value="/permitLeave",method = RequestMethod.POST)
	public Map<String,Object> permitLeave(HttpServletRequest request) {
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		 Leave record = attendanceService.getOneLeave(studentId);
		 record.setStatus(true);
		 int result = attendanceService.updateLeave(record);
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
