package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.model.Syllabus;

public class SubjectDAO extends BaseDAO {

	@SuppressWarnings("deprecation")
	public int getMaxId() throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from SUBJECT;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id;
	}

	public boolean createSubject(Subject subject) throws Exception {

		Session session = getSession();
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public Subject getSubject(String name) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.like("name", name));
		List<Subject> subjects = criteria.list();
		initializeSubjects(subjects);
		session.close();
		return subjects.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Subject> getSubjects() {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);
		List<Subject> subjects = criteria.list();
		initializeSubjects(subjects);
		session.close();
		return subjects;
	}

	private void initializeSubjects(List<Subject> subjects) {

		if (subjects != null && !subjects.isEmpty()) {
			for (Subject subject : subjects) {
				if (subject != null) {
					Hibernate.initialize(subject);
					if (subject.getSubjectCategory() != null) {
						Hibernate.initialize(subject.getSubjectCategory());
					}
					if (subject.getSyllabus() != null
							&& !subject.getSyllabus().isEmpty()) {
						for (Syllabus syllabus : subject.getSyllabus()) {
							if (syllabus != null) {
								Hibernate.initialize(subject
										.getSubjectCategory());
							}
						}
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
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	private Object getSubject(int id) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.like("id", id));
		List<SubjectCategory> categories = criteria.list();
		session.close();
		return categories.get(0);
	}

}
