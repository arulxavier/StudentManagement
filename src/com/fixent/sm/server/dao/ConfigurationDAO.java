package com.fixent.sm.server.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Configuration;
import com.fixent.sm.server.model.Congregation;
import com.fixent.sm.server.model.Diocese;

public class ConfigurationDAO 
extends BaseDAO {

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
		Criteria criteria = session.createCriteria(Congregation.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Diocese> getDioceses() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Diocese.class);
		return criteria.list();
	}
	
	public boolean createDiocese(Diocese diocese) {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(diocese);
		session.getTransaction().commit();
		return true;
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
		return (Diocese)criteria.list().get(0);				
	}
	
	public Congregation getCongregation(int id) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Congregation.class);
		criteria.add(Restrictions.idEq(id));
		return (Congregation)criteria.list().get(0);				
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
	

}
