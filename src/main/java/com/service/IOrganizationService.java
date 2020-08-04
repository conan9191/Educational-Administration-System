package com.service;

import java.util.List;

import com.pojo.Center;
import com.pojo.Department;

//组织管理 
public interface IOrganizationService {
	public int addCenter(Center record);
	public int deleteCenter(int id);
	public List<Center> getAllCenters();
	public Center getOneCenter(int id);
	
	public int addDepartment(Department record);
	public int deleteDepartment(int id);
	public List<Department> getAllDepartments();
	public Department getOneDepartment(int id);
}
