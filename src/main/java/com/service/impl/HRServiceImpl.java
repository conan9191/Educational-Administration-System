package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IPositionDao;
import com.dao.IStaffDao;
import com.pojo.Position;
import com.pojo.Staff;
import com.service.IHRService;
@Service("hrService")
@Transactional 
public class HRServiceImpl implements IHRService{
	@Resource
	private IPositionDao positionDao;
	@Resource
	private IStaffDao staffDao;
	
	@Override
	public int addPosition(Position record) {
		// TODO Auto-generated method stub
		return positionDao.insert(record);
	}

	@Override
	public int deletePosition(int id) {
		// TODO Auto-generated method stub
		return positionDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Position> getAllPositions() {
		// TODO Auto-generated method stub
		return positionDao.selectAllPositions();
	}

	@Override
	public int addStaff(Staff record) {
		// TODO Auto-generated method stub
		return staffDao.insert(record);
	}

	@Override
	public int deleteStaff(int id) {
		// TODO Auto-generated method stub
		return staffDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateStaff(Staff record) {
		// TODO Auto-generated method stub
		return staffDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffDao.selectAllStaffs();
	}

	@Override
	public Staff getOneStaff(int id) {
		// TODO Auto-generated method stub
		return staffDao.selectByPrimaryKey(id);
	}
	
	
	
}
