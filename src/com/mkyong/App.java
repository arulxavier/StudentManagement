package com.mkyong;

import java.util.Date;

import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;


public class App {
	public static void main(String[] args) {
		
		SubjectCategory category = new SubjectCategory();
		category.setId(1);
		/*category.setName("Category Name 2");
		category.setCreatedBy("admin");
		category.setCreatedDate(Calendar.getInstance().getTime());*/
		
		/*SubjectCategoryServiceImpl impl = new SubjectCategoryServiceImpl();
		System.out.println(impl.createSubjectCategory(category));*/
		
		Subject subject = new Subject();
		subject.setName("Subject One4");
		subject.setCredit(2);
		subject.setCreatedBy("system");
		subject.setCreatedDate(new Date());
		subject.setSubjectCategory(category);
		
		SubjectServiceImpl impl = new SubjectServiceImpl();
		impl.createSubject(subject);
		
		
		/*session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(104);
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

//		session.save(user);
		session.getTransaction().commit();*/
	}
}
