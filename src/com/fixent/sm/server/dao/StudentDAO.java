package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.info.StudentInfo;

public class StudentDAO 
extends BaseDAO {

	@SuppressWarnings("deprecation")
	public int getMaxId() 
			throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from STUDENT;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id;
	}

	public boolean createStudent(Student student) 
			throws Exception {

		Session session = getSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		return true;
	}

	public Student getStudent(String name) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.like("name", name));
		@SuppressWarnings("unchecked")
		List<Student> students =  criteria.list();
		return students.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getBatch() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Batch.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudents() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students =  criteria.list();
		return students;
	}

	public List<Student> searchStudent(StudentInfo studentInfo) {
		
		List<Student> students = new ArrayList<Student>();
		Session session = getSession();
		Criteria criteria = session.createCriteria(Student.class);
		Criteria criteria2 = criteria.createCriteria("batch");
		criteria2.add(Restrictions.eq("year", studentInfo.getYear()));
		criteria2.add(Restrictions.ilike("type", studentInfo.getYearType()));
		students = criteria.list();
		return students;
	}


}
