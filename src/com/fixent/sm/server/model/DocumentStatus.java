package com.fixent.sm.server.model;

public class DocumentStatus {
	
	private int id;
	private String documentName;
	private boolean documentStatus;
	Student student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public boolean isDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(boolean documentStatus) {
		this.documentStatus = documentStatus;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
