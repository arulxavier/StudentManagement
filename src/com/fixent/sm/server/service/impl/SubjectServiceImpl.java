package com.fixent.sm.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fixent.sm.server.BaseService;
import com.fixent.sm.server.ErrorCode;
import com.fixent.sm.server.dao.SubjectDAO;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.info.SyllabusInfo;
import com.fixent.sm.server.service.SubjectService;

public class SubjectServiceImpl 
extends BaseService
implements SubjectService {

	
	public boolean createSubject(Subject subject) {
		
		boolean status = false;
		
		try {
			
			SubjectDAO dao = new SubjectDAO();
			int id = dao.getMaxId();
			subject.setId(id+1);
			status = dao.createSubject(subject);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}

	
	public Subject getSubject(String name) {
		
		Subject subject = null;
		
		try {
			SubjectDAO dao = new SubjectDAO();
			subject = dao.getSubject(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}
	
	public List<Subject> getSubjects() {
		
		List<Subject> subjects = null;
		
		try {
			
			SubjectDAO dao = new SubjectDAO();
			subjects = dao.getSubjects();
			
		} catch (Throwable th) {
			handleServiceException(th, ErrorCode.CAN_NOT_FETCH_SUBJECTS.toString(), null);
		}
		return subjects;
	}

	public boolean deleteSubject(Subject subject) {
		
		boolean status = false;
		try {
			
			SubjectDAO dao = new SubjectDAO();
			status = dao.deleteSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Subject> searchSubject(SyllabusInfo syllabusInfo) {
		
		List<Subject> subjects = new ArrayList<Subject>();
		try {
			
			SubjectDAO dao = new SubjectDAO();
			subjects = dao.searchSubject(syllabusInfo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return subjects;
	}

	public boolean modifySubject(Subject subject) {
		
		boolean status = false;
		try {
			
			SubjectDAO dao = new SubjectDAO();
			status = dao.modifySubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
