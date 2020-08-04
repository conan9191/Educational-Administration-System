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

import com.pojo.Center;
import com.pojo.Department;
import com.service.IOrganizationService;
//组织管理
@Controller  
@RequestMapping("/organization")
public class OrganizationController {
	 @Resource 
	 private IOrganizationService organizationService;
	 //区域中心管理 涉及到查增删即可
	 @ResponseBody
	 @RequestMapping(value="/getCenters",method = RequestMethod.GET)  
	 public Map<String,Object> getCenters(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Center> centerList = organizationService.getAllCenters();
		 if(centerList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("centerList", centerList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addCenter",method = RequestMethod.POST)  
	 public Map<String,Object> addCenter(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String city = request.getParameter("city");
		 Center record = new Center();
		 record.setId(id);
		 record.setCity(city);
		 int result = organizationService.addCenter(record);
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
	 @RequestMapping(value="/deleteCenter",method = RequestMethod.POST)  
	 public Map<String,Object> deleteCenter(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = organizationService.deleteCenter(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //部门管理 涉及到查增删即可
	 @ResponseBody
	 @RequestMapping(value="/getDepartments",method = RequestMethod.GET)  
	 public Map<String,Object> getDepartements(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Department> departmentList = organizationService.getAllDepartments();
		 if(departmentList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("departemntList", departmentList);
		 return modelMap;
	 }

	 @ResponseBody
	 @RequestMapping(value="/addDepartment",method = RequestMethod.POST)  
	 public Map<String,Object> addDepartment(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8");
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String name = request.getParameter("name");
		 int centerId = Integer.parseInt(request.getParameter("centerId").trim());
		 int superiorId = Integer.parseInt(request.getParameter("superiorId").trim());
		 Department record = new Department();
		 record.setId(id);
		 record.setName(name);
		 record.setCenterId(centerId);
		 record.setSuperiorId(superiorId);
		 int result = organizationService.addDepartment(record);
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
	 @RequestMapping(value="/deleteDepartment",method = RequestMethod.POST)  
	 public Map<String,Object> deleteDepartment(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = organizationService.deleteDepartment(id);
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
