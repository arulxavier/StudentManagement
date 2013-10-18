package com.fixent.sm.client.maintenance.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Subject;

public class SubjectListDataTable extends AbstractTableModel {

	public SubjectListDataTable(List<Subject> subjects) {
		super();
		this.subjects = subjects;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Subject> subjects;
	String columnList[] = new String[] { "Subject ID", "Category Name", "Subject Name" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return subjects.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Subject entity = subjects.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getSubjectCategory().getName();
		case 2:
			return entity.getName();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}

}
