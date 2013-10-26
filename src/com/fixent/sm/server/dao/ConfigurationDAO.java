package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Configuration;
import com.fixent.sm.server.model.Congregation;
import com.fixent.sm.server.model.Diocese;

public class ConfigurationDAO extends BaseDAO {

	public boolean createConfiguration(Configuration configuration) {

		Session session = getSession();
		session.beginTransaction();
		session.save(configuration);
		session.getTransaction().commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Congregation> getCongregations() {

		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Congregation.class);
		List<Congregation> list = criteria.list();
		session.getTransaction().commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Diocese> getDioceses() {

		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Diocese.class);
		List<Diocese> list = criteria.list();
		session.getTransaction().commit();
		return list;
	}

	public int getDiocesesMaxId() throws Exception {

		int id = 0;

		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from DIOCESE;");
		id =  (Integer) query.uniqueResult();
		/*Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from DIOCESE;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}*/
		session.getTransaction().commit();
		return id;
	}

	public boolean createDiocese(Diocese diocese) {

		Session session = getSession();
		session.beginTransaction();
		session.save(diocese);
		session.getTransaction().commit();
		return true;
	}

	public int getCongregationMaxId() throws Exception {

		int id = 0;
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from congregation;");
		id =  (Integer) query.uniqueResult();/*
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from congregation;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}*/
		return id;
	}

	public boolean createCongregation(Congregation congregation) {

		Session session = getSession();
		session.beginTransaction();
		session.save(congregation);
		session.getTransaction().commit();
		return true;
	}

	public Diocese getDiocese(int id) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Diocese.class);
		criteria.add(Restrictions.idEq(id));
		Diocese diocese = (Diocese) criteria.list().get(0);
		return diocese;
	}

	public Congregation getCongregation(int id) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Congregation.class);
		criteria.add(Restrictions.idEq(id));
		Congregation congregation = (Congregation) criteria.list().get(0);
		return congregation;
	}

	public boolean deleteDiocese(int id) {

		Session session = getSession();
		session.beginTransaction();
		session.delete(getDiocese(id));
		session.getTransaction().commit();
		return true;
	}

	public boolean deleteCongregation(int id) {

		Session session = getSession();
		session.beginTransaction();
		session.delete(getCongregation(id));
		session.getTransaction().commit();
		return true;
	}

	public boolean modifyDiocese(Diocese diocese) {

		Session session = getSession();
		session.beginTransaction();
		session.merge(diocese);
		session.getTransaction().commit();
		return true;
	}

	public boolean modifyCongregation(Congregation congregation) {

		Session session = getSession();
		session.beginTransaction();
		session.merge(congregation);
		session.getTransaction().commit();
		return true;
	}
}
