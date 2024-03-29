package com.fixent.sm.client.maintenance.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.SubjectCategory;

public class SubjecCategorytListDataTable extends AbstractTableModel {

	public SubjecCategorytListDataTable(List<SubjectCategory> subjectCategories) {
		super();
		this.subjectCategories = subjectCategories;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<SubjectCategory> subjectCategories;
	String columnList[] = new String[] { "ID", "Subject Category Name" };

	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return subjectCategories != null ? subjectCategories.size() : 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {

		SubjectCategory entity = subjectCategories.get(rowIndex);
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
