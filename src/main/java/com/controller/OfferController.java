package com.controller;

import java.io.File;
import java.io.IOException;
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
import com.pojo.Company;
import com.pojo.Employment;
import com.pojo.Resume;
import com.pojo.Student;
import com.service.IOfferService;
import com.util.PoiWordToHtmlUtil;

//就业管理
@Controller
@RequestMapping("/offer")
public class OfferController {
	@Resource
	private IOfferService offerService;
	@Resource
	private IStudentDao studentDao;
	private static Logger logger = Logger.getLogger(OfferController.class);
	@ResponseBody
	 @RequestMapping(value="/getAllCompanys",method = RequestMethod.GET)  
	 public Map<String,Object> getAllCompanys(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 List<Company> companyList = offerService.getAllCompanys();
		 if(companyList.size() == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("companyList", companyList);
		 return modelMap;
	 }		
	
	@ResponseBody
	@RequestMapping(value="/signOffer",method = RequestMethod.POST)  
	 public Map<String,Object> signOffer(HttpServletRequest request){
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("username");
		 Student student = studentDao.selectByStudentNo(username);
		 
		 String job = request.getParameter("job").trim();
		 String company = request.getParameter("company").trim();
		 logger.debug("job:"+job+"-----"+"company:"+company);
		 Employment record = new Employment();
		 record.setStudentId(student.getId());
		 record.setJob(job);
		 record.setCompany(company);
		 record.setResume("");;
		 int result = offerService.signOffer(record);
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
	@RequestMapping(value="/uploadResume",method = RequestMethod.POST)
	public Map<String,Object> uploadResume(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 String errno = "";
		 request.setCharacterEncoding("utf-8");
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
		 //word转换成html格式
		 String htmlfilename = null;
		 try {
			 htmlfilename = PoiWordToHtmlUtil.word2Html(realPath, originalFilename);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Resume record = new Resume();
		 //保存路径
		 record.setStudentId(student.getId());
		 record.setResume(path);;
		 //更新
		 int result = offerService.uploadResume(record);
		 if(result == 0) {
			 errno = "0001";
			 modelMap.put("errno", errno);
			 return modelMap;
		 }
		 errno = "0000";
		 modelMap.put("errno", errno);
		 modelMap.put("fileName", htmlfilename);
		 return modelMap;
	}
	
	
}
