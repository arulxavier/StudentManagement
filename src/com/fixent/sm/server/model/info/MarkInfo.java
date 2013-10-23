package com.fixent.sm.server.model.info;

public class MarkInfo {
	
	int id;
	int year;
	String type;
	int semaster;
	String subject;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSemaster() {
		return semaster;
	}
	public void setSemaster(int semaster) {
		this.semaster = semaster;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
