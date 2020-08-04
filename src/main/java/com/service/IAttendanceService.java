package com.service;

import java.util.List;

import com.pojo.Attendance;
import com.pojo.Leave;

public interface IAttendanceService {
	public int sign(Attendance record);
	public int askForLeave(Leave record);
	public int updateLeave(Leave record);
	public int uploadPhoto(Leave record);
	public Leave getOneLeave(Integer studentId);
	public List<Leave> getAllLeaves();
}
