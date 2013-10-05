package com.fixent.sm.server.service.impl;

import com.fixent.sm.server.dao.SubjectDAO;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.service.SubjectService;

public class SubjectServiceImpl 
implements SubjectService {

	@Override
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

	@Override
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

}
