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

import com.pojo.Classroom;
import com.pojo.Equipment;
import com.service.IAssetService;

//资产管理
@Controller  
@RequestMapping("/asset")
public class AssetController {
	@Resource
	private IAssetService assetService;
	//教室管理涉及到查增删即可
	 @ResponseBody
	 @RequestMapping(value="/getClassrooms",method = RequestMethod.GET)  
	 public Map<String,Object> getClassrooms(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Classroom> classroomList = assetService.getAllClassrooms();
		 if(classroomList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("classroomList", classroomList);
		 return modelMap;
	 }

	 @ResponseBody
	 @RequestMapping(value="/addClassroom",method = RequestMethod.POST)  
	 public Map<String,Object> addClassroom(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String name = request.getParameter("name").trim();
		 int centerId = Integer.parseInt(request.getParameter("centerId").trim());
		 Classroom record = new Classroom();
		 record.setId(id);
		 record.setName(name);
		 record.setCenterId(centerId);
		 int result = assetService.addClassroom(record);
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
	 @RequestMapping(value="/deleteClassroom",method = RequestMethod.POST)  
	 public Map<String,Object> deleteCenter(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = assetService.deleteClassroom(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	//教学设备管理 涉及到查所有、增删、改数量
	 @ResponseBody
	 @RequestMapping(value="/getEquipments",method = RequestMethod.GET)  
	 public Map<String,Object> getEquipments(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Equipment> equipmentList = assetService.getAllEquipments();
		 if(equipmentList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("equipmentList", equipmentList);
		 return modelMap;
	 }

	 @ResponseBody
	 @RequestMapping(value="/addEquipment",method = RequestMethod.POST)  
	 public Map<String,Object> addEquipment(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 String category = request.getParameter("category").trim();
		 int centerId = Integer.parseInt(request.getParameter("centerId").trim());
		 Equipment record = new Equipment();
		 record.setId(id);
		 record.setCategory(category);
		 record.setCenterId(centerId);
		 int result = assetService.addEquipment(record);
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
	 @RequestMapping(value="/deleteEquipment",method = RequestMethod.POST)  
	 public Map<String,Object> deleteEquipment(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = assetService.deleteEquipment(id);
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
