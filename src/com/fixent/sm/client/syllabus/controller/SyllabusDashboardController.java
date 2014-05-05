package com.fixent.sm.client.syllabus.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.ClientConstants;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.syllabus.view.SyllabusDashboardView;
import com.fixent.sm.server.model.info.SyllabusInfo;

public class SyllabusDashboardController 
extends BaseController {
	
	public SyllabusDashboardView view;
	
	public SyllabusDashboardController() {
		
		view = new SyllabusDashboardView();
		view.getYearComboBox().setModel(getYears());
		view.getSearchButton().addActionListener(new SearchAction());
		view.getAddButton().addActionListener(new AddAction());
	}
	
	class SearchAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			SyllabusInfo syllabusInfo = new SyllabusInfo();
			
			if (!"Select One".equals(view.getYearComboBox().getSelectedItem().toString())) {
				
				syllabusInfo.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
			}
			if (!"Select One".equals(view.getTypeComboBox().getSelectedItem().toString())) {
				
				syllabusInfo.setType(view.getTypeComboBox().getSelectedItem().toString());
			}
			if (!"Select One".equals(view.getSemasterComboBox().getSelectedItem().toString())) {
				
				syllabusInfo.setSemaster(Integer.parseInt(view.getSemasterComboBox().getSelectedItem().toString()));
			}
			
			push("SyllabusInfo", syllabusInfo);
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new SyllabusListController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
		
	}
	
	class AddAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			push(ClientConstants.SCREEN_MODE, ClientConstants.ADD);
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new SyllabusController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
	}

}
