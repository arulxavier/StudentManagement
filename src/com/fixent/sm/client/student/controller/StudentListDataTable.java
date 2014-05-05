package com.fixent.sm.client.student.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Student;

public class StudentListDataTable extends AbstractTableModel {

	public StudentListDataTable(List<Student> studentList) {
		super();
		this.studentList = studentList;
	}

	/**/
	private static final long serialVersionUID = 1L;
	List<Student> studentList;
	String columnList[] = new String[] { "Student ID", "Name" };

	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return studentList != null ? studentList.size() : 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {

		Student entity = studentList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getName();
		default:
			return null;
		}
	}

	
	public String getColumnName(int col) {
		return columnList[col];
	}

}
