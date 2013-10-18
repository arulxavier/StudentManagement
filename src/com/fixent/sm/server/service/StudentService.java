package com.fixent.sm.server.service;

import com.fixent.sm.server.model.Ministry;
import com.fixent.sm.server.model.Student;

public interface StudentService {
	
	boolean createStudent(Student student);
	
	boolean createMinistry(Ministry ministry);
}
