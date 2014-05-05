package com.fixent.sm.client.maintenance.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Batch;

public class BatchListDataTable extends AbstractTableModel {

	public BatchListDataTable(List<Batch> subjects) {
		super();
		this.batches = subjects;
	}

	/**/
	private static final long serialVersionUID = 1L;

	List<Batch> batches;
	String columnList[] = new String[] { "Batch ID", "Year", "Type" };

	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return batches != null ? batches.size() : 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {

		Batch entity = batches.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getYear();
		case 2:
			return entity.getType();
		default:
			return null;
		}
	}

	
	public String getColumnName(int col) {
		return columnList[col];
	}

}
