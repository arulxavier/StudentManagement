package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Subject;

public class SubjectDAO 
extends BaseDAO {
	
	@SuppressWarnings("deprecation")
	public int getMaxId() 
	throws Exception {
		
		int id = 0;
		
		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from SUBJECT;");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}
		
		return id;
	}
	
	public boolean createSubject(Subject subject) 
	throws Exception {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
		return true;
	}

	public Subject getSubject(String name) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.like("name", name));
		@SuppressWarnings("unchecked")
		List<Subject> subjects =  criteria.list();
		return subjects.get(0);
	}

}
