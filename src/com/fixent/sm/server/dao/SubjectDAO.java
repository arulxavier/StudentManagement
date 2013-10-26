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

public class SubjectDAO extends BaseDAO {

	@SuppressWarnings("deprecation")
	public int getMaxId() throws Exception {

		int id = 0;

		Session session = getSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select max(id) from SUBJECT;");
		id = (Integer) query.uniqueResult();
		return id;
	}

	public boolean createSubject(Subject subject) throws Exception {

		Session session = getSession();
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	public Subject getSubject(String name) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.like("name", name));
		Subject subject = (Subject) criteria.uniqueResult();
		initializeSubject(subject);
		return subject;
	}

	@SuppressWarnings("unchecked")
	public List<Subject> getSubjects() {

		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Subject.class);
		List<Subject> subjects = criteria.list();
		initializeSubjects(subjects);
		session.getTransaction().commit();
		return subjects;
	}

	private void initializeSubjects(List<Subject> subjects) {

		if (subjects != null && !subjects.isEmpty()) {

			for (Subject subject : subjects) {
				initializeSubject(subject);
			}
		}
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

	public boolean deleteSubject(Subject subject) {

		Session session = getSession();
		session.beginTransaction();
		session.delete(subject);
		session.getTransaction().commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	private Object getSubject(int id) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.like("id", id));
		List<SubjectCategory> categories = criteria.list();
		return categories.get(0);
	}

	public List<Subject> searchSubject(SyllabusInfo syllabusInfo) {

		List<Subject> subjects = new ArrayList<Subject>();
		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);

		if (syllabusInfo.getYear() != 0) {
			criteria.add(Restrictions.eq("year", syllabusInfo.getYear()));
		}

		if (syllabusInfo.getType() != null) {
			criteria.add(Restrictions.eq("type", syllabusInfo.getType()));
		}
		if (syllabusInfo.getSemaster() != 0) {
			criteria.add(Restrictions.eq("year", syllabusInfo.getYear()));
		}
		subjects = criteria.list();
		initializeSubjects(subjects);
		return subjects;
	}

	public boolean modifySubject(Subject subject) {

		Session session = getSession();
		session.beginTransaction();
		session.merge(subject);
		session.getTransaction().commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	public int getSubjectsCount(int subjectCategoryId) {

		Session session = getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.like("subjectCategory.id", subjectCategoryId));
		List<Subject> subjects = criteria.list();
		session.getTransaction().commit();
		return subjects != null ? subjects.size() : 0;
	}
}
