package com.fixent.sm.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fixent.sm.server.dao.MarkDAO;
import com.fixent.sm.server.model.Mark;
import com.fixent.sm.server.model.info.MarkInfo;
import com.fixent.sm.server.model.info.SyllabusInfo;
import com.fixent.sm.server.service.MarkService;

public class MarkServiceImpl 
implements MarkService {

	@Override
	public boolean createMark(Mark mark) {
		
		boolean status = false;
		
		try {
			
			MarkDAO dao = new MarkDAO();
			int id = dao.getMaxId();
			mark.setId(id+1);
			status = dao.createMark(mark);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}
	
	public Map<String, List<Object>> getMarkDetails(SyllabusInfo syllabusInfo) {
		
		Map<String, List<Object>> markDetails = new HashMap<String, List<Object>>();
		
		try {
			
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return markDetails;
	}

	public void createMarks(List<Mark> marks) {
		
		try {
			
			for (Mark mark : marks) {
				createMark(mark);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Mark> searchMark(MarkInfo markInfo) {
		
		List<Mark> marks = new ArrayList<Mark>();
		
		try {
			
			MarkDAO dao = new MarkDAO();
			marks = dao.searchMark(markInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marks;
	}

	public void modifyMarkList(List<Mark> marks) {
		
		try {
			
			for (Mark mark : marks) {
				
				modifyMark(mark);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void modifyMark(Mark mark) {
		
		try {
			
			MarkDAO dao = new MarkDAO();
			boolean status = dao.modifyMark(mark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
