package com.fixent.sm.server.service.impl;

import com.fixent.sm.server.dao.SubjectCategoryDAO;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.SubjectCategoryService;

public class SubjectCategoryServiceImpl 
implements SubjectCategoryService {

	@Override
	public boolean createSubjectCategory(SubjectCategory category) {
		
		boolean status = false;
		
		try {
			
			SubjectCategoryDAO categoryDAO = new SubjectCategoryDAO();
			int id = categoryDAO.getMaxId();
			category.setId(id+1);
			status = categoryDAO.createCategory(category);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}

	@Override
	public SubjectCategory getSubjectCategory(String name) {
		
		SubjectCategory subjectCategory = null;
		
		try {
			
			SubjectCategoryDAO categoryDAO = new SubjectCategoryDAO();
			subjectCategory = categoryDAO.getSubjectCategory(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectCategory;
	
	}
	
	

}
