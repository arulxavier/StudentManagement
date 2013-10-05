package com.fixent.sm.server.service.impl;

import com.fixent.sm.server.dao.StudentDAO;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.StudentService;

public class StudentServiceImpl 
implements StudentService {

	@Override
	public boolean createStudent(Student student) {
		
		boolean status = false;
		
		try {
			
			StudentDAO dao = new StudentDAO();
			int id = dao.getMaxId();
			student.setId(id+1);
			status = dao.createStudent(student);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}
	
}
