package com.fixent.sm.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fixent.sm.server.dao.StudentDAO;
import com.fixent.sm.server.model.Ministry;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.info.StudentInfo;
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

	@Override
	public boolean createMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Map<String, List<Object>> getPrepopulate() {
		
		Map<String, List<Object>> prepopulates = new HashMap<String, List<Object>>();
		try {
			
			StudentDAO dao = new StudentDAO();
			prepopulates.put("batch", dao.getBatch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prepopulates;
	}
	
	public List<Student> getStudents() {
		
		List<Student> students = null;
		
		try {
			
			StudentDAO dao = new StudentDAO();
			students = dao.getStudents();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public List<Student> searchStudent(StudentInfo studentInfo) {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			
			StudentDAO dao = new StudentDAO();
			students = dao.searchStudent(studentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
}
