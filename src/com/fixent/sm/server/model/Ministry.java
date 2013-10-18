package com.fixent.sm.server.model;

public class Ministry {
	
	private int id;
	private String nameOfTheMinistry;
	private boolean ministryStatus;
	private Student student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfTheMinistry() {
		return nameOfTheMinistry;
	}
	public void setNameOfTheMinistry(String nameOfTheMinistry) {
		this.nameOfTheMinistry = nameOfTheMinistry;
	}
	public boolean isMinistryStatus() {
		return ministryStatus;
	}
	public void setMinistryStatus(boolean ministryStatus) {
		this.ministryStatus = ministryStatus;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
