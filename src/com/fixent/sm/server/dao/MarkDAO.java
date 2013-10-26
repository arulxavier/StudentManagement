package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Mark;
import com.fixent.sm.server.model.info.MarkInfo;

public class MarkDAO 
extends BaseDAO {
	
	@SuppressWarnings("deprecation")
	public int getMaxId() 
			throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from MARK;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}
		connection.close();
		session.close();
		return id;
	}
	
	public boolean createMark(Mark mark) {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(mark);
		session.getTransaction().commit();
		return true;
	}

	public List<Mark> searchMark(MarkInfo markInfo) {
		
		List<Mark> marks = new ArrayList<Mark>();
		Session session = getSession();
		Criteria criteria = session.createCriteria(Mark.class);
		Criteria criteria2 = criteria.createCriteria("syllabus");
		if (markInfo.getYear() != 0) {
			criteria2.add(Restrictions.eq("year", markInfo.getYear()));
		}
		if (markInfo.getType() != null) {
			criteria2.add(Restrictions.eq("type", markInfo.getType()));
		}
		if (markInfo.getSemaster() != 0) {
			criteria2.add(Restrictions.eq("semaster", markInfo.getSemaster()));
		}
		Criteria criteria3 = criteria.createCriteria("subject");
		if (markInfo.getSubject() != null) {
			criteria3.add(Restrictions.ilike("name", markInfo.getSubject()));
		}
		marks = criteria.list();
		return marks;
	}

	public boolean modifyMark(Mark mark) {
		
		Session session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(mark);
		session.getTransaction().commit();
		return true;
	}
}
