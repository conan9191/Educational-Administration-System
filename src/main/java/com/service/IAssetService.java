package com.service;

import java.util.List;

import com.pojo.Classroom;
import com.pojo.Equipment;


public interface IAssetService {
	public int addClassroom(Classroom record);
	public int deleteClassroom(int id);
	public List<Classroom> getAllClassrooms();
	
	public int addEquipment(Equipment record);
	public int deleteEquipment(int id);
	public List<Equipment> getAllEquipments();
}
