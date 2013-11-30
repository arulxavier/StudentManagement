package com.fixent.sm.client.maintenance.controller;

import com.fixent.sm.server.ErrorCode;
import com.fixent.sm.server.ServerException;
import com.fixent.sm.server.model.SubjectCategory;

public class SubjectMaintenanceValidator {
	
	ServerException validateSubjectCategory(SubjectCategory subjectCategory) {
		
		ServerException exception = new ServerException("", null);
		
		if (subjectCategory.getName() == null) {
			exception.addError(ErrorCode.SUBJECT_CATEGORY_NAME_SHOULD_NOT_EMPTY.toString(), null);
			
		}
		
		return exception;
		
	}

}
