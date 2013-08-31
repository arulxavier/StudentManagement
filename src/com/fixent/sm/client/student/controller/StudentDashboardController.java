package com.fixent.sm.client.student.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fixent.sm.client.common.BaseLayout;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.student.view.StudentDashboardView;

public class StudentDashboardController {
	
	public StudentDashboardView view;
	AddEvent addEvent;
	SearchEvent searchEvent;
	
	public StudentDashboardController() {
		
		view = new StudentDashboardView();
		addEvent = new AddEvent();
		searchEvent = new SearchEvent();
		subscirbe();
	}
	
	private void subscirbe() {
		
		view.getAddButton().addActionListener(addEvent);
		view.getSearchButton().addActionListener(searchEvent);
		
	}

	class AddEvent
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
		
	}
	
	class SearchEvent
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentListController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
	}

}
