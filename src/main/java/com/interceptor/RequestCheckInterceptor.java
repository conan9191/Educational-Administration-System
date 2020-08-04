package com.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pojo.User;
import com.service.IMenuService;
import com.service.IUserService;
//实现获取菜单前应该完成登录，否则返回错误页面
public class RequestCheckInterceptor extends HandlerInterceptorAdapter {
	@Resource
	IMenuService menuService;
	@Resource 
	IUserService userService;
	private static Logger logger = Logger.getLogger(RequestCheckInterceptor.class); 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//1.判断是否是获取菜单的url 是则拦截判断，否则放行
		String path = request.getServletPath();
		logger.debug("输出path:--------"+path);
		System.out.println("输出path:--------"+path);
		if(path.equals("/getMenus")) {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			logger.debug("输出username:--------"+username);
			//2.判断用户是否登录，是则放行，否则将请求转发到404接口（ErrorController）上去。
			if(username!=null){
				Map<?, ?> menuMap = (Map<?, ?>) session.getAttribute("menuList");
				//3.如果session中没有存储菜单，则，存储菜单列表。
				if(null == menuMap) {
					User condition = userService.getUserCondition(username);
					menuMap = menuService.getAllMenus(condition.getId());
					session.setAttribute("menuMap", menuMap);
				}
			}else{
				String sendRedirectUrl = "/errorPage";
				request.getRequestDispatcher(sendRedirectUrl).forward(request, response);
				return false;
			}
		}
		return true;
		
	}

}
