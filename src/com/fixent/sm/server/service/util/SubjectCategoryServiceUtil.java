package com.fixent.sm.server.service.util;

import java.util.List;

import com.fixent.sm.server.ServerException;
import com.fixent.sm.server.ServiceMessage;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.impl.SubjectCategoryServiceImpl;

public class SubjectCategoryServiceUtil {
	
	public static ServiceMessage getSubjectCategories() {
		
		ServiceMessage message = new ServiceMessage();
		try {
			
			SubjectCategoryServiceImpl subjectCategoryServiceImpl = new SubjectCategoryServiceImpl();
			List<SubjectCategory> subjectCategories = subjectCategoryServiceImpl.getSubjectCategories();
			message.setInfo(subjectCategories);
		} catch (ServerException e) {
			message.setErrorCode(e.getErrorCode());
			message.setStatus("KO");
		}
		return message;
	}

}
