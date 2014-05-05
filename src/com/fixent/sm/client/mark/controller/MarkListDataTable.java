package com.fixent.sm.client.mark.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.sm.server.model.Mark;

public class MarkListDataTable extends AbstractTableModel {

	public MarkListDataTable(List<Mark> marks) {
		super();
		this.marks = marks;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Mark> marks;
	String columnList[] = new String[] {
			"Mark ID", "Student Name", "Subject name", "Mark" 
	};
	 private final Class[] columnClass = new Class[] {
		        Integer.class, String.class, String.class, Double.class
	};
	 
	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return marks.size();
	}
	
	
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
	
	
	public boolean isCellEditable(int row, int col) {
		
		if (col == 3) {
			
			return true; 
		}
		return false;
	 }
	
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {

		Mark entity = marks.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getStudent().getName();
		case 2:
			return entity.getSubject().getName();
		case 3:
			return entity.getMark();
		default:
			return null;
		}
	}

	
	public String getColumnName(int col) {
		return columnList[col];
	}
	
	
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
		Mark row = marks.get(rowIndex);
        if(0 == columnIndex) {
            row.setId((Integer) aValue);
        }
        else if(1 == columnIndex) {
            row.getSubject().setName((String) aValue);
        }
        else if(2 == columnIndex) {
            row.getSubject().setName((String) aValue);
        }
        else if(3 == columnIndex) {
            row.setMark((Double) aValue);
        }
    }

}
