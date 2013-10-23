package com.fixent.sm.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fixent.sm.server.dao.SyllabusDAO;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.SyllabusInfo;
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
	
	public List<Syllabus> searchSyllabus(SyllabusInfo syllabusInfo) {
		
		List<Syllabus> syllabuses = new ArrayList<Syllabus>();
		try {
			
			SyllabusDAO dao = new SyllabusDAO();
			syllabuses = dao.searchSyllabus(syllabusInfo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return syllabuses;
	}
	
	public Syllabus getSyllabus(SyllabusInfo syllabusInfo) {
		
		try {
			
			return searchSyllabus(syllabusInfo).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
