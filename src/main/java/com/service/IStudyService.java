package com.service;

import com.pojo.Note;
import com.pojo.Project;

public interface IStudyService {
	public int addNote(Note record);
	public int updateNote(Note record);
	public Note getNoteByStudentId(Integer studentId);
	public int deleteNoteByStudentId(int studentId);
	
	public int uploadProject(Project record); 
}
