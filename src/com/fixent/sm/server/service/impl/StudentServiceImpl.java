package com.fixent.sm.server.service.impl;

import java.util.List;

import com.fixent.sm.server.dao.UserDAO;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.StudentService;

public class StudentServiceImpl 
implements StudentService{

	@Override
	public void createStudent(Student student) {
		
		UserDAO dao = new UserDAO();
		boolean status = dao.createStudent(student);
		
	}
	
	public List<Student> getStudents() {
		
		UserDAO dao = new UserDAO();
		List<Student> list = dao.getStudents();
		return list;
	}

}
