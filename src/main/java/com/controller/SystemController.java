package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;












import com.domain.UserModel;
import com.pojo.Menu;
import com.pojo.Module;
import com.pojo.Role;
import com.pojo.User;
import com.service.ISystemService;



@Controller  
@RequestMapping("/system")
public class SystemController {
	@Resource 
	private ISystemService systemService;
	//模块管理 获取模块列表   增加   删除(启用 禁用 模块)
	@ResponseBody
	@RequestMapping(value="/getModules",method = RequestMethod.GET)  
	public Map<String,Object> getModules(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Module> moduleList = systemService.getAllModules();

		 if(moduleList.size()== 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("moduleList", moduleList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addModule",method = RequestMethod.POST)  
	 public Map<String,Object> addModule(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
	   	 Module record = systemService.getOneModule(id);
	   	 //假删除 更新status为true 启用模块
		 record.setStatus(true);
		 int result = systemService.updateModule(record);
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
	 @RequestMapping(value="/deleteModule",method = RequestMethod.POST)  
	 public Map<String,Object> deleteModule(HttpServletRequest request) throws UnsupportedEncodingException{
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("UTF-8"); 
		 int id = Integer.parseInt(request.getParameter("id").trim());
	   	 Module record = systemService.getOneModule(id);
	   	 //假删除 更新status为false
		 record.setStatus(false);
		 int result = systemService.updateModule(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 return modelMap;
	 }
	 
	 //菜单管理 获取菜单列表 增加  删除
	 @ResponseBody
	 @RequestMapping(value="/getMenus",method = RequestMethod.GET)  
	 public Map<String,Object> getMenus(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Menu> systemList =systemService.getAllMenus();
		 
		 if(systemList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("systemMenuList", systemList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addMenu",method = RequestMethod.POST)  
	 public Map<String,Object> addMenu(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 String item = request.getParameter("item");
		 int parentId = Integer.parseInt(request.getParameter("parentId"));
		 Menu record = new Menu();
		 record.setItem(item);
		 record.setUrl("#");
		 record.setParentId(parentId);
		 int result = systemService.addMenu(record);
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
	 @RequestMapping(value="/deleteMenu",method = RequestMethod.POST)  
	 public Map<String,Object> deleteMenu(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = systemService.deleteMenu(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
			 return modelMap;
	 }
	
	 //角色管理  获取列表  增加 删除
	 @ResponseBody
	 @RequestMapping(value="/getRoles",method = RequestMethod.GET)  
	 public Map<String,Object> getRoles(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Role> roleList =systemService.getAllRoles();
		 if(roleList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("roleList", roleList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addRole",method = RequestMethod.POST)  
	 public Map<String,Object> addRole(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 String name = request.getParameter("name").trim();
		 Role record = new Role();
		 record.setName(name);
		 int result = systemService.addRole(record);
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
	 @RequestMapping(value="/deleteRole",method = RequestMethod.POST)  
	 public Map<String,Object> deleteRole(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int id = Integer.parseInt(request.getParameter("id").trim());
		 int result = systemService.deleteRole(id);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
			 return modelMap;
	 }	 
	 
	 //用户管理  获取列表 （返回包含角色的用户对象列表） 获取单个用户  增加用户（同时分配角色） 删除用户 更新用户信息
	 @ResponseBody
	 @RequestMapping(value="/getUsers",method = RequestMethod.GET)  
	 public Map<String,Object> getUsers(){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<UserModel> userList =systemService.getAllUsers();
		 if(userList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("userList", userList);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/getActiveUser",method = RequestMethod.GET)  
	 public Map<String,Object> getActiveUser(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 HttpSession session = request.getSession();
		 String username = (String) session.getAttribute("username");
		 User record =systemService.getActiveUser(username);
		 if(record == null) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("user", record);
		 return modelMap;
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/addUser",method = RequestMethod.POST)  
	 public Map<String,Object> addUser(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 String username = request.getParameter("username").trim();
		 String password = request.getParameter("password").trim();
		 String roleName = request.getParameter("roleName").trim();
		 UserModel record = new UserModel();
		 record.setUsername(username);
		 record.setPassword(password);
		 record.setRoleName(roleName);
		 int result = systemService.addUser(record);
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
	 @RequestMapping(value="/deleteUser",method = RequestMethod.POST)  
	 public Map<String,Object> deleteUser(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 int userId = Integer.parseInt(request.getParameter("userId").trim());
		 int result = systemService.deleteUser(userId);
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
