package com.domain;

import java.util.List;

import com.pojo.Menu;

public class MenuModel {
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Menu> getChildrenMenuList() {
		return childrenMenuList;
	}
	public void setChildrenMenuList(List<Menu> childrenMenuList) {
		this.childrenMenuList = childrenMenuList;
	}
	private String name;
	private String url;
	private List<Menu> childrenMenuList;
	
}
