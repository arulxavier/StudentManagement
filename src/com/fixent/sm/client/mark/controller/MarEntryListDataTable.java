package com.fixent.sm.client.mark.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Student;

public class MarEntryListDataTable extends AbstractTableModel {

	public MarEntryListDataTable(List<Student> students) {
		super();
		this.students = students;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Student> students;
	String columnList[] = new String[] {
			"Student ID", "Student Name", "Mark" 
	};
	 private final Class[] columnClass = new Class[] {
		        Integer.class, String.class, Double.class
	};
	 
	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return students.size();
	}
	
	@Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		
		if (col == 2) {
			
			return true; 
		}
		return false;
	 }
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Student entity = students.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getName();
		case 2:
			return entity.getMark();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}
	
	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
		Student row = students.get(rowIndex);
        if(0 == columnIndex) {
            row.setId((Integer) aValue);
        }
        else if(1 == columnIndex) {
            row.setName((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setMark((Double) aValue);
        }
    }

}
