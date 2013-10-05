package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;

import com.fixent.sm.server.model.Syllabus;

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


}
