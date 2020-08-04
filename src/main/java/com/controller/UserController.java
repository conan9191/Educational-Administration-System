package com.controller;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.Student;
import com.pojo.User;  
import com.service.IStudentService;
import com.service.IUserService;  
import com.util.MessageUtil;

@Controller 
@RequestMapping("/user") 
public class UserController {  
  @Resource  
  private IUserService userService;
  @Resource
  private IStudentService studentService;
  //生成验证码
  @ResponseBody
  @RequestMapping(value="/getCode",method = RequestMethod.POST)  
  public void getCode( HttpServletRequest request){  
	  String timestamp = request.getParameter("timestamp").trim();
	  String code = MessageUtil.getMD5Str(timestamp);
	  HttpSession session = request.getSession();
	  session.setAttribute("checkcode", code);
  }
  
  //这里仅为学生信息注册账号的接口
  @ResponseBody
  @RequestMapping(value="/register",method = RequestMethod.POST)  
  public Map<String,Object> register(HttpServletRequest request){
	  Map<String,Object> modelMap = new HashMap<String,Object>();
	  String errno = "";
	  String errmsg = "";
	  String studentNumber = request.getParameter("studentNumber").trim();
	  String name = request.getParameter("name").trim();
	  String gender = request.getParameter("gender").trim();
	  
	  
	  //这里学生学号默认为账号名称以及密码
	  String username = studentNumber;
	  String password = studentNumber;
	
		  if(studentNumber.equals("")||name.equals("")) {
			  //如果接收的参数为空
			  errno = "0001";
			  errmsg = "学号或姓名为空请重新输入！";
		  } else {
			  //参数不为空则插入数据
			  User record = new User();
			  record.setUsername(username);
			  //加密存储
			  record.setPassword(MessageUtil.getMD5Str(password));
			  int result = userService.register(record);

			  if(result == 0) {
				  errno = "0002";
				  errmsg = "该学号已经注册！";
			  }else{
				  errno = "0000";
				  errmsg = "注册成功！";
				  Student condition = new Student();
				  User tmp = userService.getUserCondition(username);
				  condition.setUserId(tmp.getId());
				  condition.setStudentno(studentNumber);
				  condition.setName(name);
				  condition.setGender(gender);
				  condition.setGroupId(0);
				  condition.setBirthDate(new Date());
				  studentService.registerStudent(condition);
				  
				  
			  }  
	  }
	  
	  modelMap.put("errno", errno);
	  modelMap.put("errmsg", errmsg);
	  return modelMap;
	  
  }
  
  @ResponseBody
  @RequestMapping(value="/login",method = RequestMethod.POST)  
  public Map<String,Object> login(HttpServletRequest request){  
	  Map<String,Object> modelMap = new HashMap<String,Object>();
	  String errno = "";
	  String errmsg = "";
	  String timestamp = request.getParameter("timestamp").trim();
	  String username = request.getParameter("username").trim();
	  String password = request.getParameter("password").trim();
	  String code = MessageUtil.getMD5Str(timestamp);
	  HttpSession session = request.getSession();
      String existCode = (String)session.getAttribute("checkcode");
      
	  if(!code.equals(existCode)) {
		  //后台验证码判断
		  errno = "0001";
		  errmsg = "请校正验证码！";
	  }else {
		  if(username.equals("") || password.equals("")) {
			  errno = "0002";
			  errmsg = "用户名或者密码为空请重新输入！";
		  } else {
			  //参数不为空则查询数据
			  User record = new User();
			  record.setUsername(username);
			  record.setPassword(MessageUtil.getMD5Str(password));
			  int result = userService.login(record);
			  if(result==0) {
				  errno = "0003";
				  errmsg = "用户名或者密码有错误请重新输入！";
			  }else {
				  errno = "0000";
				  errmsg = "登录成功！";
				  //存储登录信息
				  session.setAttribute("username", username);
			  }
		  }
		  
	  }
	 
	  modelMap.put("errno", errno);
	  modelMap.put("errmsg", errmsg);
	  return modelMap;
  }
  
  
 
  

}  