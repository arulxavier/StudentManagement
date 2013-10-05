package com.fixent.sm.server.service.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.impl.SubjectCategoryServiceImpl;

public class TestSubjectCategoryServiceImpl {
	
	public static void main(String[] args) {
		
		List<SubjectCategory> categories = new ArrayList<SubjectCategory>();
		
		SubjectCategory category = new SubjectCategory();
		category.setName("Scripture");
		category.setCreatedBy("admin");
		category.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category);
		
		SubjectCategory category1 = new SubjectCategory();
		category1.setName("Bible");
		category1.setCreatedBy("admin");
		category1.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category1);
		
		SubjectCategory category2 = new SubjectCategory();
		category2.setName("System Theology");
		category2.setCreatedBy("admin");
		category2.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category2);
		
		SubjectCategory category3 = new SubjectCategory();
		category3.setName("Moral Theory");
		category3.setCreatedBy("admin");
		category3.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category3);
		
		SubjectCategory category5 = new SubjectCategory();
		category5.setName("Liturgy");
		category5.setCreatedBy("admin");
		category5.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category5);
		
		SubjectCategory category6 = new SubjectCategory();
		category6.setName("Church History");
		category6.setCreatedBy("admin");
		category6.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category6);
		
		SubjectCategory category7 = new SubjectCategory();
		category7.setName("Spirituality");
		category7.setCreatedBy("admin");
		category7.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category7);
		
		SubjectCategory category8 = new SubjectCategory();
		category8.setName("Canon Law");
		category8.setCreatedBy("admin");
		category8.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category8);
		
		SubjectCategory category9 = new SubjectCategory();
		category9.setName("Varia");
		category9.setCreatedBy("admin");
		category9.setCreatedDate(Calendar.getInstance().getTime());
		categories.add(category9);
		
		for (SubjectCategory category10 : categories) {
			
			SubjectCategoryServiceImpl impl = new SubjectCategoryServiceImpl();
			System.out.println(impl.createSubjectCategory(category10));
		}
	}

}
