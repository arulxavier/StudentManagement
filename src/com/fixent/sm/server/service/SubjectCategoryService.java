package com.fixent.sm.server.service;

import com.fixent.sm.server.model.SubjectCategory;

public interface SubjectCategoryService {
	
	boolean createSubjectCategory(SubjectCategory category);
	
	SubjectCategory getSubjectCategory(String name);

}
