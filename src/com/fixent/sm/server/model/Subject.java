package com.fixent.sm.server.model;

import java.util.Date;
import java.util.Set;

public class Subject {

	int id;
	String name;
	int credit;
	SubjectCategory subjectCategory;
	String createdBy;
	Date createdDate;
	String updatedBy;
	Date updatedDate;
	Set<Syllabus> syllabus;
	
	public Subject()
	{
		
	}

	public Subject(int id, String name, int credit,
			SubjectCategory subjectCategory, String createdBy,
			Date createdDate, String updatedBy, Date updatedDate,
			Set<Syllabus> syllabus) {
		
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.subjectCategory = subjectCategory;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.syllabus = syllabus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public SubjectCategory getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(SubjectCategory subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<Syllabus> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Set<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}

}
