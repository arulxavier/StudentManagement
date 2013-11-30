package com.fixent.sm.server.service.util;

import java.util.List;

import com.fixent.sm.server.ServerException;
import com.fixent.sm.server.ServiceMessage;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;

public class SubjectServiceUtil {
	
	public static ServiceMessage getSubjects() {
		
		ServiceMessage message = new ServiceMessage();
		try {
			
			SubjectServiceImpl subjectServiceImpl = new SubjectServiceImpl();
			List<Subject> subject = subjectServiceImpl.getSubjects();
			message.setInfo(subject);
			return message;
		} catch (ServerException e) {
			message.setErrorCode(e.getErrorCode());
			message.setStatus("KO");
		}
		return message;
	}

}
