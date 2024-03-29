package com.fixent.sm.client.maintenance.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Congregation;

public class CongregationListDataTable extends AbstractTableModel {

	public CongregationListDataTable(List<Congregation> congregations) {
		super();
		this.congregations = congregations;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Congregation> congregations;
	String columnList[] = new String[] { "ID", "Congregation Name" };

	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return congregations != null ? congregations.size() : 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {

		Congregation entity = congregations.get(rowIndex);
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
