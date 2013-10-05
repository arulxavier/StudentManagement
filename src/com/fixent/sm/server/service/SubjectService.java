package com.fixent.sm.server.service;

import com.fixent.sm.server.model.Subject;

public interface SubjectService {
	
	boolean createSubject(Subject subject);
	
	Subject getSubject(String name);

}
