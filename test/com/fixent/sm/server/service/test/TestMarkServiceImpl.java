package com.fixent.sm.server.service.test;

import java.util.Date;

import com.fixent.sm.server.model.Mark;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.service.impl.MarkServiceImpl;

public class TestMarkServiceImpl {
	
	public static void main(String[] args) {
		
		Mark mark = new Mark();
		
		Syllabus syllabus = new Syllabus();
		syllabus.setId(1);
		
		Subject subject = new Subject();
		subject.setId(1);
		
		Student student = new Student();
		student.setId(1);
		
		mark.setMark(75);
		mark.setSyllabus(syllabus);
		mark.setSubject(subject);
		mark.setCreatedBy("admin");
		mark.setCreatedDate(new Date());
		mark.setStudent(student);
		
		MarkServiceImpl impl = new MarkServiceImpl();
		impl.createMark(mark);
	}

}
