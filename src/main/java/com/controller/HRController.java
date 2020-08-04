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

import com.pojo.Position;
import com.pojo.Staff;
import com.service.IHRService;
//人事管理
@Controller  
@RequestMapping("/hr")
public class HRController {
	@Resource
	private IHRService hrService;
	
	//职位管理 增删查
	@ResponseBody
	 @RequestMapping(value="/getPositions",method = RequestMethod.GET)  
	 public Map<String,Object> getPositions(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Position> positionList = hrService.getAllPositions();
		 if(positionList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("positionList", positionList);
		 return modelMap;
	 }

	 @ResponseBody
	 @RequestMapping(value="/addPosition",method = RequestMethod.POST)  
	 public Map<String,Object> addPosition(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String name = request.getParameter("name");
		 int departmentId = Integer.parseInt(request.getParameter("departmentId").trim());
		 Position record = new Position();
		 record.setId(id);
		 record.setName(name);
		 record.setDepartmentId(departmentId);
		 int result = hrService.addPosition(record);
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
	 @RequestMapping(value="/deletePosition",method = RequestMethod.POST)  
	 public Map<String,Object> deletePosition(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = hrService.deletePosition(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	
	//教职工信息 增删改查
		@ResponseBody
		 @RequestMapping(value="/getStaffs",method = RequestMethod.GET)  
		 public Map<String,Object> getStaffs(){
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 List<Staff> staffList = hrService.getAllStaffs();
			 if(staffList.size() == 0) {
				 errno = "0001";
				 modelMap.put("errno", errno);
				 return modelMap;
			 }
			 errno = "0000";
			 modelMap.put("errno", errno);
			 modelMap.put("staffList", staffList);
			 return modelMap;
		 }

		
		@ResponseBody
		 @RequestMapping(value="/getOneStaff",method = RequestMethod.GET)  
		 public Map<String,Object> getOneStaff(HttpServletRequest request){
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 int id = Integer.parseInt(request.getParameter("id").trim());
			 String errno = "";
			 Staff staff = hrService.getOneStaff(id);
			 if(staff == null) {
				 errno = "0001";
				 modelMap.put("errno", errno);
				 return modelMap;
			 }
			 errno = "0000";
			 modelMap.put("errno", errno);
			 modelMap.put("staff", staff);
			 return modelMap;
		 }		
		
		 @ResponseBody
		 @RequestMapping(value="/addStaff",method = RequestMethod.POST)  
		 public Map<String,Object> addStaff(HttpServletRequest request) throws UnsupportedEncodingException{
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 request.setCharacterEncoding("UTF-8"); 
			 int id = Integer.parseInt(request.getParameter("id").trim());
			 int userId = Integer.parseInt(request.getParameter("userId").trim());
			 String name = request.getParameter("name");
			 int positionId = Integer.parseInt(request.getParameter("positionId").trim());
			 int departmentId = Integer.parseInt(request.getParameter("departmentId").trim());
			 Staff record = new Staff();
			 record.setId(id);
			 record.setUserId(userId);
			 record.setName(name);
			 record.setPositionId(positionId);
			 record.setDepartmentId(departmentId);
			 int result = hrService.addStaff(record);
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
		 @RequestMapping(value="/deleteStaff",method = RequestMethod.POST)  
		 public Map<String,Object> deleteStaff(HttpServletRequest request){
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 int id = Integer.parseInt(request.getParameter("id").trim());
			 int result = hrService.deleteStaff(id);
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
		 @RequestMapping(value="/updateStaff",method = RequestMethod.POST)  
		 public Map<String,Object> updateStaff(HttpServletRequest request) throws UnsupportedEncodingException{
			 Map<String,Object> modelMap = new HashMap<String,Object>();
			 String errno = "";
			 request.setCharacterEncoding("UTF-8"); 
			 int id = Integer.parseInt(request.getParameter("id").trim());
			 int userId = Integer.parseInt(request.getParameter("userId").trim());
			 String name = request.getParameter("name");
			 int positionId = Integer.parseInt(request.getParameter("positionId").trim());
			 int departmentId = Integer.parseInt(request.getParameter("departmentId").trim());
			 Staff record = new Staff();
			 record.setId(id);
			 record.setUserId(userId);
			 record.setName(name);
			 record.setPositionId(positionId);
			 record.setDepartmentId(departmentId);
			 int result = hrService.updateStaff(record);
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
