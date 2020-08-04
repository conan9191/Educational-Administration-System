package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MenuController {
//	@Resource
//	private IMenuService menuService;
	@ResponseBody
	@RequestMapping(value="/getMenus",method=RequestMethod.GET)
	public Map<String,Object> getMenus(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String,Object> modelMap = (Map<String, Object>)session.getAttribute("menuMap");
		modelMap.put("errno", "0000");
		return modelMap;
	}
	
	
}
