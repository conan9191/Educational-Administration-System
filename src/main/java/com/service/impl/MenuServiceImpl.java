package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;















import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IMenuDao;
import com.domain.MenuModel;
import com.pojo.Menu;
import com.service.IMenuService;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements IMenuService {
	@Resource
	private IMenuDao menuDao;
	@Override
	public Map<String, List<MenuModel>> getAllMenus(Integer id) {
		// TODO Auto-generated method stub
		Map<String, List<MenuModel>> modelMap = new HashMap<String, List<MenuModel>>();
		List<Menu> parentMenus = menuDao.selectAllParentMenus(id);
		Iterator<Menu> it = parentMenus.iterator();
		List<MenuModel> menulist = new ArrayList<MenuModel>();
		Menu temp = new Menu();
		while(it.hasNext()) {
			MenuModel mm = new MenuModel();
			temp = (Menu)it.next();
			List<Menu> childrenList = menuDao.selectAllChildrenMenus(temp.getId());
//			Iterator it2 = childrenList.iterator();
//			while(it2.hasNext()) {
//				Menu temp2 = (Menu)it2.next();
//			}
//			modelMap.put(temp.getItem(), childrenList);
			mm.setName(temp.getItem());
			mm.setUrl(temp.getUrl());
			mm.setChildrenMenuList(childrenList);
			menulist.add(mm);
		}
		modelMap.put("menuList",menulist);
		return modelMap;
	}

}
