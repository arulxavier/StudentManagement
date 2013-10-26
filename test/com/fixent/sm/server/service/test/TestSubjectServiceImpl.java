package com.fixent.sm.server.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.service.impl.SubjectCategoryServiceImpl;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;

public class TestSubjectServiceImpl {
	
	public static void main(String[] args) {
		
		List<Subject> subjects = new ArrayList<Subject>();
						
		Subject subject = new Subject();
		subject.setName("Bible Greek and Hebrew");
		subject.setCredit(2);
		subject.setCreatedBy("admin");
		subject.setCreatedDate(new Date());
		subject.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject);
		
		Subject subject1 = new Subject();
		subject1.setName("Infancy Passion and Resurrection Narratives");
		subject1.setCredit(2);
		subject1.setCreatedBy("admin");
		subject1.setCreatedDate(new Date());
		subject1.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject1);
		
		Subject subject2 = new Subject();
		subject2.setName("Introduction to the Bible");
		subject2.setCredit(2);
		subject2.setCreatedBy("admin");
		subject2.setCreatedDate(new Date());
		subject2.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject2);
		
		Subject subject3 = new Subject();
		subject3.setName("Introduction to Synoptics and Sermon on the Mount");
		subject3.setCredit(2);
		subject3.setCreatedBy("admin");
		subject3.setCreatedDate(new Date());
		subject3.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject3);
		
		Subject subject4 = new Subject();
		subject4.setName("Psalms");
		subject4.setCredit(2);
		subject4.setCreatedBy("admin");
		subject4.setCreatedDate(new Date());
		subject4.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject4);
		
		Subject subject5 = new Subject();
		subject5.setName("Parables and Miracles");
		subject5.setCredit(2);
		subject5.setCreatedBy("admin");
		subject5.setCreatedDate(new Date());
		subject5.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject5);
		
		Subject subject16 = new Subject();
		subject16.setName("Acts of the Apostoles");
		subject16.setCredit(1);
		subject16.setCreatedBy("admin");
		subject16.setCreatedDate(new Date());
		subject16.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject16);
		
		Subject subject17 = new Subject();
		subject17.setName("Historical Books and Midrash Literature");
		subject17.setCredit(3);
		subject17.setCreatedBy("admin");
		subject17.setCreatedDate(new Date());
		subject17.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject17);
		
		Subject subject18 = new Subject();
		subject18.setName("Pauline Letters");
		subject18.setCredit(3);
		subject18.setCreatedBy("admin");
		subject18.setCreatedDate(new Date());
		subject18.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject18);
		
		Subject subject19 = new Subject();
		subject19.setName("Pentateuch");
		subject19.setCredit(2);
		subject19.setCreatedBy("admin");
		subject19.setCreatedDate(new Date());
		subject19.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject19);
		
		Subject subject20 = new Subject();
		subject20.setName("Wisdom Literature");
		subject20.setCredit(2);
		subject20.setCreatedBy("admin");
		subject20.setCreatedDate(new Date());
		subject20.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Scripture"));
		subjects.add(subject20);
		
		
		
		//-------------------------------------------------------------------------------------------------
		Subject subject6 = new Subject();
		subject6.setName("Faith and Revelation");
		subject6.setCredit(3);
		subject6.setCreatedBy("admin");
		subject6.setCreatedDate(new Date());
		subject6.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject6);
		
		Subject subject7 = new Subject();
		subject7.setName("Feminist Theology");
		subject7.setCredit(1);
		subject7.setCreatedBy("admin");
		subject7.setCreatedDate(new Date());
		subject7.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject7);
		
		Subject subject8 = new Subject();
		subject8.setName("Introduction to Sacraments Baptism and Confirmation");
		subject8.setCredit(2);
		subject8.setCreatedBy("admin");
		subject8.setCreatedDate(new Date());
		subject8.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject8);
		
		Subject subject9 = new Subject();
		subject9.setName("Introduction to theology and Research - Methodology");
		subject9.setCredit(2);
		subject9.setCreatedBy("admin");
		subject9.setCreatedDate(new Date());
		subject9.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject9);
		
		Subject subject10 = new Subject();
		subject10.setName("Theology of Vat. Council-II");
		subject10.setCredit(1);
		subject10.setCreatedBy("admin");
		subject10.setCreatedDate(new Date());
		subject10.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject10);
		
		Subject subject21 = new Subject();
		subject21.setName("Christology");
		subject21.setCredit(3);
		subject21.setCreatedBy("admin");
		subject21.setCreatedDate(new Date());
		subject21.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject21);
		
		
		Subject subject22 = new Subject();
		subject22.setName("Ecclesiology");
		subject22.setCredit(2);
		subject22.setCreatedBy("admin");
		subject22.setCreatedDate(new Date());
		subject22.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject22);
		
		Subject subject23 = new Subject();
		subject23.setName("Eucharist");
		subject23.setCredit(2);
		subject23.setCreatedBy("admin");
		subject23.setCreatedDate(new Date());
		subject23.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject23);
		
		Subject subject24 = new Subject();
		subject24.setName("Holy Orders");
		subject24.setCredit(2);
		subject24.setCreatedBy("admin");
		subject24.setCreatedDate(new Date());
		subject24.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject24);
		
		Subject subject25 = new Subject();
		subject25.setName("Indian Christian Theology");
		subject25.setCredit(1);
		subject25.setCreatedBy("admin");
		subject25.setCreatedDate(new Date());
		subject25.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject25);
		
		Subject subject26 = new Subject();
		subject26.setName("Reconciliation and Anointing");
		subject26.setCredit(1);
		subject26.setCreatedBy("admin");
		subject26.setCreatedDate(new Date());
		subject26.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("System Theology"));
		subjects.add(subject26);
		
		
		//---------------------------------------------------------------------------------------------------
		Subject subject11 = new Subject();
		subject11.setName("Fun. Morals I");
		subject11.setCredit(2);
		subject11.setCreatedBy("admin");
		subject11.setCreatedDate(new Date());
		subject11.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Moral Theory"));
		subjects.add(subject11);
		
		Subject subject12 = new Subject();
		subject12.setName("Fun. Morals II");
		subject12.setCredit(2);
		subject12.setCreatedBy("admin");
		subject12.setCreatedDate(new Date());
		subject12.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Moral Theory"));
		subjects.add(subject12);
		
		Subject subject27 = new Subject();
		subject27.setName("Sexuality and Marriage");
		subject27.setCredit(3);
		subject27.setCreatedBy("admin");
		subject27.setCreatedDate(new Date());
		subject27.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Moral Theory"));
		subjects.add(subject27);
		
		Subject subject28 = new Subject();
		subject28.setName("Ecology");
		subject28.setCredit(1);
		subject28.setCreatedBy("admin");
		subject28.setCreatedDate(new Date());
		subject28.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Moral Theory"));
		subjects.add(subject28);
		
		
		//---------------------------------------------------------------------------------------------------
		Subject subject13 = new Subject();
		subject13.setName("Introduction to Liturgy");
		subject13.setCredit(2);
		subject13.setCreatedBy("admin");
		subject13.setCreatedDate(new Date());
		subject13.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Liturgy"));
		subjects.add(subject13);
		
		Subject subject29 = new Subject();
		subject29.setName("Liturgical Year and Sacraments");
		subject29.setCredit(1);
		subject29.setCreatedBy("admin");
		subject29.setCreatedDate(new Date());
		subject29.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Liturgy"));
		subjects.add(subject29);
		
		
		//---------------------------------------------------------------------------------------------
		Subject subject14 = new Subject();
		subject14.setName("Church History I");
		subject14.setCredit(2);
		subject14.setCreatedBy("admin");
		subject14.setCreatedDate(new Date());
		subject14.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Church History"));
		subjects.add(subject14);
		
		Subject subject15 = new Subject();
		subject15.setName("Patrology");
		subject15.setCredit(1);
		subject15.setCreatedBy("admin");
		subject15.setCreatedDate(new Date());
		subject15.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Church History"));
		subjects.add(subject15);
		
		Subject subject30 = new Subject();
		subject30.setName("Church History II");
		subject30.setCredit(3);
		subject30.setCreatedBy("admin");
		subject30.setCreatedDate(new Date());
		subject30.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Church History"));
		subjects.add(subject30);
		
		//---------------------------------------------------------------------------------------------------------
		
		Subject subject31 = new Subject();
		subject31.setName("Canon Law I (General)");
		subject31.setCredit(3);
		subject31.setCreatedBy("admin");
		subject31.setCreatedDate(new Date());
		subject31.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Canon Law"));
		subjects.add(subject31);
		
		Subject subject32 = new Subject();
		subject32.setName("Canon Law II (Marriage)");
		subject32.setCredit(3);
		subject32.setCreatedBy("admin");
		subject32.setCreatedDate(new Date());
		subject32.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Canon Law"));
		subjects.add(subject32);
		
		//-------------------------------------------------------------------------------------------------
		
		Subject subject33 = new Subject();
		subject33.setName("Catechetics");
		subject33.setCredit(2);
		subject33.setCreatedBy("admin");
		subject33.setCreatedDate(new Date());
		subject33.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Varia"));
		subjects.add(subject33);
		
		Subject subject34 = new Subject();
		subject34.setName("Homiletics");
		subject34.setCredit(1);
		subject34.setCreatedBy("admin");
		subject34.setCreatedDate(new Date());
		subject34.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Varia"));
		subjects.add(subject34);
		
		Subject subject35 = new Subject();
		subject35.setName("Religion of Tamils");
		subject35.setCredit(1);
		subject35.setCreatedBy("admin");
		subject35.setCreatedDate(new Date());
		subject35.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Varia"));
		subjects.add(subject35);
		
		Subject subject36 = new Subject();
		subject36.setName("Latin");
		subject36.setCredit(2);
		subject36.setCreatedBy("admin");
		subject36.setCreatedDate(new Date());
		subject36.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Varia"));
		subjects.add(subject36);
		
		Subject subject37 = new Subject();
		subject37.setName("Hebrew");
		subject37.setCredit(1);
		subject37.setCreatedBy("admin");
		subject37.setCreatedDate(new Date());
		subject37.setSubjectCategory(new SubjectCategoryServiceImpl().getSubjectCategory("Varia"));
		subjects.add(subject37);
		
		//---------------------------------------------------------------------------------------------------------
		
		for (Subject subject38 : subjects) {
			
			SubjectServiceImpl impl = new SubjectServiceImpl();
			impl.createSubject(subject38);
		}
	}

}
