package com.fixent.sm.client.student.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.student.view.StudentListView;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.impl.StudentServiceImpl;

public class StudentListController {
	
	StudentListView view;
	List<Student> students;
	
	public StudentListController() {
		view = new StudentListView();
		view.getViewBtn().addActionListener(new ViewAction());
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
//		students = studentServiceImpl.getStudents();
		setView();
	}

	private void setView() {

		StudentListDataTable model = new StudentListDataTable(students);
		view.getStudentListTable().setModel(model);
	}
	
	class ViewAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int row = view.getStudentListTable().getSelectedRow();
			System.out.println(students.get(row).getId());
			

			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		
		}
		
	}
}


