package com.fixent.sm.server.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.SubjectCategory;

public class SubjectCategoryDAO 
extends BaseDAO {
	
	@SuppressWarnings("deprecation")
	public int getMaxId() 
	throws Exception {
		
		int id = 0;
		
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from SUBJECT_CATEGORY;");
		if (query.uniqueResult() != null) {
			id = (Integer) query.uniqueResult();
		}
		session.getTransaction().commit();
		
		return id;
	}
	
	public boolean createCategory(SubjectCategory category) 
	throws Exception {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		return true;
	}

	public SubjectCategory getSubjectCategory(String name) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(SubjectCategory.class);
		criteria.add(Restrictions.like("name", name));
		@SuppressWarnings("unchecked")
		List<SubjectCategory> categories=  criteria.list();
		return categories.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<SubjectCategory> getSubjectCategories() {
		
		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(SubjectCategory.class);
		List<SubjectCategory> categories=  criteria.list();
		session.getTransaction().commit();
		return categories;
	}

	public boolean deleteSubjectCategory(int id) {
		
		Session session = getSession();
		session.beginTransaction();
		session.delete(getSubjectCategories(id));
		session.getTransaction().commit();
		return true;
	}

	private Object getSubjectCategories(int id) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(SubjectCategory.class);
		criteria.add(Restrictions.like("id", id));
		@SuppressWarnings("unchecked")
		List<SubjectCategory> categories=  criteria.list();
		return categories.get(0);
	}

	public boolean modifySubjectCategory(SubjectCategory subjectCategory) {
		
		Session session = getSession();
		session.beginTransaction();
		session.merge(subjectCategory);
		session.getTransaction().commit();
		return true;
	}

}
