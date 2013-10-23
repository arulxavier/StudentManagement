package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.SyllabusInfo;

public class SyllabusDAO 
extends BaseDAO {

	
	@SuppressWarnings("deprecation")
	public int getMaxId() 
	throws Exception {
		
		int id = 0;
		
		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from SYLLABUS;");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}
		
		return id;
	}
	
	public boolean createSyllabus(Syllabus syllabus) 
	throws Exception {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(syllabus);
		session.getTransaction().commit();
		return true;
	}

	public List<Syllabus> searchSyllabus(SyllabusInfo syllabusInfo) {

		List<Syllabus> syllabuses = new ArrayList<Syllabus>();
		Session session = getSession();
		Criteria criteria = session.createCriteria(Syllabus.class);

		if (syllabusInfo.getYear() != 0) {
			criteria.add(Restrictions.eq("year", syllabusInfo.getYear()));
		}

		if (syllabusInfo.getType() != null) {
			criteria.add(Restrictions.eq("type", syllabusInfo.getType()));
		}
		if (syllabusInfo.getSemaster() != 0) {
			criteria.add(Restrictions.eq("semaster", syllabusInfo.getSemaster()));
		}
		syllabuses = criteria.list();
		if (syllabuses != null && !syllabuses.isEmpty()) {
			for (Syllabus syllabus : syllabuses) {
				Hibernate.initialize(syllabus);
				if (syllabus.getSubjects() != null
						&& !syllabus.getSubjects().isEmpty()) {
					for (Subject subject : syllabus.getSubjects()) {
						Hibernate.initialize(subject);
						System.out.println(subject);
					}
				}

			}
		}
		return syllabuses;
	}


}
