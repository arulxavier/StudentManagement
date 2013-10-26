package com.fixent.sm.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;

import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.SyllabusInfo;

public class SyllabusDAO extends BaseDAO {

	public int getMaxId() throws Exception {

		int id = 0;
		
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from SYLLABUS;");
		id =  (Integer) query.uniqueResult();
		session.getTransaction().commit();
		
		return id;
	}

	public boolean createSyllabus(Syllabus syllabus) throws Exception {

		Session session = getSession();
		session.beginTransaction();
		session.save(syllabus);
		session.getTransaction().commit();
		return true;
	}

	public List<Syllabus> searchSyllabus(SyllabusInfo syllabusInfo) {

		List<Syllabus> syllabuses = new ArrayList<Syllabus>();
		Session session = getSession();
		session.beginTransaction();
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
						
						initializeSubject(subject);
					}
				}

			}
		}
		session.getTransaction().commit();
		return syllabuses;
	}
	
	private void initializeSubject(Subject subject) {

		if (subject != null) {

			Hibernate.initialize(subject);

			if (subject.getSubjectCategory() != null) {

				Hibernate.initialize(subject.getSubjectCategory());
				Hibernate.initialize(subject.getSubjectCategory().getName());
			}
			if (subject.getSubjectCategory() instanceof HibernateProxy) {
				HibernateProxy proxy = (HibernateProxy) subject
						.getSubjectCategory();
				SubjectCategory subjectCategory = (SubjectCategory) proxy
						.getHibernateLazyInitializer().getImplementation();
				subject.setSubjectCategory(subjectCategory);
			}
			if (subject.getSyllabus() != null
					&& !subject.getSyllabus().isEmpty()) {

				for (Syllabus syllabus : subject.getSyllabus()) {

					if (syllabus != null) {

						Hibernate.initialize(syllabus.getSubjects());
					}
				}
			}
		}
	}

	public boolean check(Syllabus syllabus) throws Exception {

		Session session = getSession();
		session.beginTransaction();
		session.save(syllabus);
		session.getTransaction().commit();
		return true;
	}

	public boolean modifySyllabus(Syllabus syllabus) {
		
		Session session = getSession();
		session.beginTransaction();
		session.merge(syllabus);
		session.getTransaction().commit();
		return true;
	}
	
	public boolean deleteSyllabus(Syllabus syllabus) {
		
		Session session = getSession();
		session.beginTransaction();
		session.delete(syllabus);
		session.getTransaction().commit();
		return true;
	}

}
