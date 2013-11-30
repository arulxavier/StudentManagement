package com.fixent.sm.server.service.impl;

import java.util.List;

import com.fixent.sm.server.BaseService;
import com.fixent.sm.server.ErrorCode;
import com.fixent.sm.server.ServerException;
import com.fixent.sm.server.dao.SubjectCategoryDAO;
import com.fixent.sm.server.dao.SubjectDAO;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.SubjectCategoryService;

public class SubjectCategoryServiceImpl
extends BaseService
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
	
	public List<SubjectCategory> getSubjectCategories() 
	throws ServerException {
		
		List<SubjectCategory> subjectCategories = null;
		try {
			
			SubjectCategoryDAO dao = new SubjectCategoryDAO();
			subjectCategories = dao.getSubjectCategories();
		} catch (Throwable th) {
			handleServiceException(th, ErrorCode.CAN_NOT_FETCH_SUBJECT_CATEGORIES.toString(), null);
		}
		return subjectCategories;
	}
	
	
	
	public boolean deleteSubjectCategory(int id) {
		
		boolean status = false;
		try {
			
			SubjectCategoryDAO dao = new SubjectCategoryDAO();
			SubjectDAO subjectDAO = new SubjectDAO();
			if (subjectDAO.getSubjectsCount(id) > 0)
			{
				return false;
			} 
			status = dao.deleteSubjectCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean modifySubjectCategory(SubjectCategory subjectCategory) {
		
		boolean status = false;
		try {
			
			SubjectCategoryDAO dao = new SubjectCategoryDAO();
			status = dao.modifySubjectCategory(subjectCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
