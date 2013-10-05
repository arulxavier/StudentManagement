package com.fixent.sm.server.service.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;
import com.fixent.sm.server.service.impl.SyllabusServiceImpl;

public class TestSyllabusServiceImpl {
	
	public static void main(String[] args) {
		
		List<Syllabus> syllabusList = new ArrayList<Syllabus>();
		
		Set<Subject> subjects = new HashSet<Subject>();
		subjects.add(new SubjectServiceImpl().getSubject("Catechetics"));
		
		Syllabus syllabus = new Syllabus();
		syllabus.setYear(2013);
		syllabus.setType("First Year");
		syllabus.setSemaster(1);
		syllabus.setSubjects(subjects);
		syllabus.setCreatedBy("admin");
		syllabus.setCreatedDate(Calendar.getInstance().getTime());
		syllabusList.add(syllabus);
		
		Set<Subject> subjects1 = new HashSet<Subject>();
		subjects1.add(new SubjectServiceImpl().getSubject("Parables and Miracles"));
		
		Syllabus syllabus1 = new Syllabus();
		syllabus1.setYear(2013);
		syllabus1.setType("First Year");
		syllabus1.setSemaster(2);
		syllabus1.setSubjects(subjects1);
		syllabus1.setCreatedBy("admin");
		syllabus1.setCreatedDate(Calendar.getInstance().getTime());
		syllabusList.add(syllabus1);
		//------------------------------------------------------------------------------------------
		Set<Subject> subjects2 = new HashSet<Subject>();
		subjects2.add(new SubjectServiceImpl().getSubject("Sexuality and Marriage"));
		
		Syllabus syllabus2 = new Syllabus();
		syllabus2.setYear(2013);
		syllabus2.setType("Second Year");
		syllabus2.setSemaster(1);
		syllabus2.setSubjects(subjects2);
		syllabus2.setCreatedBy("admin");
		syllabus2.setCreatedDate(Calendar.getInstance().getTime());
		syllabusList.add(syllabus2);
		
		
		Set<Subject> subjects3 = new HashSet<Subject>();
		subjects3.add(new SubjectServiceImpl().getSubject("Wisdom Literature"));
		
		Syllabus syllabus3 = new Syllabus();
		syllabus3.setYear(2013);
		syllabus3.setType("Second Year");
		syllabus3.setSemaster(2);
		syllabus3.setSubjects(subjects3);
		syllabus3.setCreatedBy("admin");
		syllabus3.setCreatedDate(Calendar.getInstance().getTime());
		syllabusList.add(syllabus3);
		//-----------------------------------------------------------------------------
		
		Set<Subject> subjects4 = new HashSet<Subject>();
		subjects4.add(new SubjectServiceImpl().getSubject("Sexuality and Marriage"));
		
		Syllabus syllabus4 = new Syllabus();
		syllabus4.setYear(2013);
		syllabus4.setType("Third Year");
		syllabus4.setSemaster(1);
		syllabus4.setSubjects(subjects4);
		syllabus4.setCreatedBy("admin");
		syllabus4.setCreatedDate(Calendar.getInstance().getTime());
		syllabusList.add(syllabus4);
		
		
		Set<Subject> subjects5 = new HashSet<Subject>();
		subjects5.add(new SubjectServiceImpl().getSubject("Wisdom Literature"));
		
		Syllabus syllabus5 = new Syllabus();
		syllabus5.setYear(2013);
		syllabus5.setType("Third Year");
		syllabus5.setSemaster(2);
		syllabus5.setSubjects(subjects5);
		syllabus5.setCreatedBy("admin");
		syllabus5.setCreatedDate(Calendar.getInstance().getTime());
		syllabusList.add(syllabus5);
		
		for (Syllabus syllabus6 : syllabusList) {
			
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			impl.createSyllabus(syllabus6);
		}
	}

}
