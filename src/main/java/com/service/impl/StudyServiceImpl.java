package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.INoteDao;
import com.dao.IProjectDao;
import com.pojo.Note;
import com.pojo.Project;
import com.service.IStudyService;
@Service("studyService")
@Transactional
public class StudyServiceImpl implements IStudyService {
@Resource
private INoteDao noteDao;
@Resource IProjectDao projectDao;
	@Override
	public int addNote(Note record) {
		// TODO Auto-generated method stub
		return noteDao.insert(record);
	}

	@Override
	public int deleteNoteByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return noteDao.deleteByStudentId(studentId);
	}

	@Override
	public int updateNote(Note record) {
		// TODO Auto-generated method stub
		return noteDao.updateByPrimaryKey(record);
	}

	@Override
	public Note getNoteByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return noteDao.selectByStudentId(studentId);
	}

	@Override
	public int uploadProject(Project record) {
		// TODO Auto-generated method stub
		return projectDao.insert(record);
	}

}
