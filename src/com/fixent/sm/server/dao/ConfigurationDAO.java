package com.fixent.sm.server.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Batch;
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
		if (query.uniqueResult() != null) {
			id = (Integer) query.uniqueResult();
		}
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
		Query query = session
				.createSQLQuery("select max(id) from congregation;");
		if (query.uniqueResult() != null) {
			id = (Integer) query.uniqueResult();
		}
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

	@SuppressWarnings("unchecked")
	public List<Batch> getBatchs() {

		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Batch.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Batch getBatch(int year, String type) {

		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Batch.class);
		criteria.add(Restrictions.eq("year", year));
		criteria.add(Restrictions.ilike("type", type));
		return (Batch) criteria.uniqueResult();
	}

	public Batch getBatch(int id) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Batch.class);
		criteria.add(Restrictions.idEq(id));
		Batch congregation = (Batch) criteria.list().get(0);
		return congregation;
	}

	public boolean deletebatch(Batch batch) {

		Session session = getSession();
		session.beginTransaction();
		session.delete(batch);
		session.getTransaction().commit();
		return true;
	}

	public boolean modifybatch(Batch batch) {

		Session session = getSession();
		session.beginTransaction();
		session.merge(batch);
		session.getTransaction().commit();
		return true;
	}

	public int getBatchMaxId() {

		int id = 0;
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from batch;");
		if (query.uniqueResult() != null) {
			id = (Integer) query.uniqueResult();
		}
		return id;
	}

	public boolean createbatch(Batch batch) {

		Session session = getSession();
		session.beginTransaction();
		session.save(batch);
		session.getTransaction().commit();
		return true;
	}
}
