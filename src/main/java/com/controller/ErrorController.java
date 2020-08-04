package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
	//前端专门写一个404页面用于处理错误
	@ResponseBody
	@RequestMapping(value="/errorPage")
	public Map<String,Object> errorPage(){
		Map<String,Object> modelMap= new HashMap<String,Object>();
		  modelMap.put("errno", "404");
		return modelMap;
	}
}
