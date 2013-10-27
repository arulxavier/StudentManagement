package com.fixent.sm.server.model.info;

public class ChangeYearInfo {

	private int fromYear;
	private String fromType;
	private int toYear;
	private String toType;

	public int getFromYear() {
		return fromYear;
	}

	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(int fromType) {
		this.fromType = getType(fromType);
		;
	}

	public int getToYear() {
		return toYear;
	}

	public void setToYear(int toYear) {
		this.toYear = toYear;
	}

	public String getToType() {
		return toType;
	}

	public void setToType(int toType) {
		this.toType = getType(toType);
		;
	}

	public String getType(int type) {
		String yearType = String.valueOf(type);
		if ("1".equalsIgnoreCase(yearType)) {
			yearType = "First Year";
		} else if ("2".equalsIgnoreCase(yearType)) {
			yearType = "Second Year";
		} else if ("3".equalsIgnoreCase(yearType)) {
			yearType = "Third Year";
		} else if ("4".equalsIgnoreCase(yearType)) {
			yearType = "Fourth Year";
		}
		
		return yearType;
	}
}