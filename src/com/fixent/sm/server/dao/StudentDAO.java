package com.fixent.sm.server.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;

import com.fixent.sm.server.model.Address;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.DocumentStatus;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.info.StudentInfo;

public class StudentDAO 
extends BaseDAO {

	@SuppressWarnings("deprecation")
	public int getMaxId() 
			throws Exception {

		int id = 0;
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from STUDENT;");
		if (query.uniqueResult() != null) {
			id =  (Integer) query.uniqueResult();
		}
		session.getTransaction().commit();
		return id;
	}
	
	@SuppressWarnings("deprecation")
	public int getRegNo() 
			throws Exception {

		int id = 0;

		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(REG_NO) from STUDENT;");
		if (query.uniqueResult() != null) {
			id =  (Integer) query.uniqueResult();
		}
		session.getTransaction().commit();
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
	public List<Student> getStudents() {
		
		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students =  criteria.list();
		initializeStudent(students);
		return students;
	}

	private void initializeStudent(List<Student> students) {
		
		for (Student student : students) {
			
			Hibernate.initialize(student);
			Hibernate.initialize(student.getBatch());
			Hibernate.initialize(student.getAddress());
			if (student.getAddress() instanceof HibernateProxy) {
				HibernateProxy hibernateProxy = (HibernateProxy) student.getAddress();
				Set<Address> addresses = (Set<Address>) hibernateProxy;
			}
			for (Address address : student.getAddress()) {
				Hibernate.initialize(address);
			}
			Hibernate.initialize(student.getDocumentStatus());
			for (DocumentStatus documentStatus : student.getDocumentStatus()) {
				Hibernate.initialize(documentStatus);
			}
		}
		
	}

	public List<Student> searchStudent(StudentInfo studentInfo) {
		
		List<Student> students = new ArrayList<Student>();
		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Student.class);
		Criteria criteria2 = criteria.createCriteria("batch");
		criteria2.add(Restrictions.eq("year", studentInfo.getYear()));
		criteria2.add(Restrictions.ilike("type", studentInfo.getYearType()));
		students = criteria.list();
		return students;
	}

	public boolean modifyStudent(Student student) {
		
		Session session = getSession();
		session.beginTransaction();
		session.merge(student);
		session.getTransaction().commit();
		return true;
	}

	public boolean changeYear(List<Integer> studentsIds, Batch batch) {
		
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("update STUDENT s set s.BATCH_ID = ? where s.ID in (:ids)");
		query.setParameter(0, batch.getId());
		query.setParameterList("ids", studentsIds);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		return true;
	}


}
