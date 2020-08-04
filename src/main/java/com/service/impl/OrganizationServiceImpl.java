package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ICenterDao;
import com.dao.IDepartmentDao;
import com.pojo.Center;
import com.pojo.Department;
import com.service.IOrganizationService;
@Service("organizationService")
@Transactional 
public class OrganizationServiceImpl implements IOrganizationService{
	@Resource
	private ICenterDao centerDao;
	@Resource
	private IDepartmentDao departmentDao;
	
	@Override
	public int addCenter(Center record) {
		// TODO Auto-generated method stub
		return centerDao.insert(record);
	}

	@Override
	public int deleteCenter(int id) {
		// TODO Auto-generated method stub
		return centerDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Center> getAllCenters() {
		// TODO Auto-generated method stub
		return centerDao.selectAllCenters();
	}

	@Override
	public Center getOneCenter(int id) {
		// TODO Auto-generated method stub
		return centerDao.selectByPrimaryKey(id);
	}

	@Override
	public int addDepartment(Department record) {
		// TODO Auto-generated method stub
		return departmentDao.insert(record);
	}

	@Override
	public int deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return departmentDao.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.selectAllDepartments();
	}
	
	@Override
	public Department getOneDepartment(int id) {
		// TODO Auto-generated method stub
		return departmentDao.selectByPrimaryKey(id);
	}

}
