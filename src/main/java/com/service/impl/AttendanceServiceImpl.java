package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IAttendanceDao;
import com.dao.ILeaveDao;
import com.pojo.Attendance;
import com.pojo.Leave;
import com.service.IAttendanceService;
@Service("attendanceService")
@Transactional
public class AttendanceServiceImpl implements IAttendanceService {
	@Resource
	private IAttendanceDao attendanceDao;
	@Resource
	private ILeaveDao leaveDao;
	
	@Override
	public int sign(Attendance record) {
		// TODO Auto-generated method stub
		return attendanceDao.insert(record);
	}

	@Override
	public int askForLeave(Leave record) {
		// TODO Auto-generated method stub
		return leaveDao.insert(record);
	}

	@Override
	public int uploadPhoto(Leave record) {
		// TODO Auto-generated method stub
		return leaveDao.updateByPrimaryKey(record);
	}

	@Override
	public Leave getOneLeave(Integer studentId) {
		// TODO Auto-generated method stub
		return leaveDao.selectOneLeave(studentId);
	}

	@Override
	public List<Leave> getAllLeaves() {
		// TODO Auto-generated method stub
		return leaveDao.selectAllLeaves();
	}

	@Override
	public int updateLeave(Leave record) {
		// TODO Auto-generated method stub
		return leaveDao.updateByPrimaryKey(record);
	}

}
