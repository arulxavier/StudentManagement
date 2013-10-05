package com.fixent.sm.server.service.impl;

import com.fixent.sm.server.dao.SubjectDAO;
import com.fixent.sm.server.dao.SyllabusDAO;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.service.SyllabusService;

public class SyllabusServiceImpl 
implements SyllabusService {

	@Override
	public boolean createSyllabus(Syllabus syllabus) {
		
		boolean status = false;
		
		try {
			
			SyllabusDAO dao = new SyllabusDAO();
			int id = dao.getMaxId();
			syllabus.setId(id+1);
			status = dao.createSyllabus(syllabus);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}

}
