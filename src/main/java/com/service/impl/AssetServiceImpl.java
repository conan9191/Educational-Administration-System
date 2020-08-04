package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IClassroomDao;
import com.dao.IEquipmentDao;
import com.pojo.Classroom;
import com.pojo.Equipment;
import com.service.IAssetService;
@Service("assetService")
@Transactional 
public class AssetServiceImpl implements IAssetService {
	@Resource
	private IClassroomDao classroomDao;
	@Resource
	private IEquipmentDao equipmentDao;
	
	@Override
	public int addClassroom(Classroom record) {
		// TODO Auto-generated method stub
		return classroomDao.insert(record);
	}

	@Override
	public int deleteClassroom(int id) {
		// TODO Auto-generated method stub
		return classroomDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Classroom> getAllClassrooms() {
		// TODO Auto-generated method stub
		return classroomDao.selectAllClassrooms();
	}

	@Override
	public int addEquipment(Equipment record) {
		// TODO Auto-generated method stub
		return equipmentDao.insert(record);
	}

	@Override
	public int deleteEquipment(int id) {
		// TODO Auto-generated method stub
		return equipmentDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Equipment> getAllEquipments() {
		// TODO Auto-generated method stub
		return equipmentDao.selectAllEquipments();
	}

}
