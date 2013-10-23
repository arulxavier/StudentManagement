package com.fixent.sm.client.syllabus.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.Syllabus;

public class SyllabusListDataTable extends AbstractTableModel {

	public SyllabusListDataTable(List<Syllabus> syllabus) {
		super();
		this.syllabus = syllabus;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Syllabus> syllabus;
	String columnList[] = new String[] { "Syllabus ID", "Year", "Type", "Semaster" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return syllabus.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Syllabus entity = syllabus.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getYear();
		case 2:
			return entity.getType();
		case 3:
			return entity.getSemaster();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}

}
