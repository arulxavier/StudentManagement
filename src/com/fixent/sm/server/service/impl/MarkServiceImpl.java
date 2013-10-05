package com.fixent.sm.server.service.impl;

import com.fixent.sm.server.dao.MarkDAO;
import com.fixent.sm.server.model.Mark;
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

}
