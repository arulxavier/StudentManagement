package com.fixent.sm.server.service.impl;

import java.util.List;

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
	
	public List<SubjectCategory> getSubjectCategories() {
		
		List<SubjectCategory> subjectCategories = null;
		try {
			
			SubjectCategoryDAO dao = new SubjectCategoryDAO();
			subjectCategories = dao.getSubjectCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectCategories;
	}
	
	public boolean deleteSubjectCategory(int id) {
		
		boolean status = false;
		try {
			
			SubjectCategoryDAO dao = new SubjectCategoryDAO();
			status = dao.deleteSubjectCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
