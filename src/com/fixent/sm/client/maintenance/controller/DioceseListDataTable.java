package com.fixent.sm.client.maintenance.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Diocese;

public class DioceseListDataTable extends AbstractTableModel {

	public DioceseListDataTable(List<Diocese> dioceses) {
		super();
		this.dioceses = dioceses;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Diocese> dioceses;
	String columnList[] = new String[] { "ID", "Diocese Name" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return dioceses != null ? dioceses.size() : 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Diocese entity = dioceses.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
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
