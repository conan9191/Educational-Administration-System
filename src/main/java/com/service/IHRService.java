package com.service;

import java.util.List;

import com.pojo.Position;
import com.pojo.Staff;


public interface IHRService {
	public int addPosition(Position record);
	public int deletePosition(int id);
	public List<Position> getAllPositions();
	
	public int addStaff(Staff record);
	public int deleteStaff(int id);
	public int updateStaff(Staff record);
	public List<Staff> getAllStaffs();
	public Staff getOneStaff(int id);
}
