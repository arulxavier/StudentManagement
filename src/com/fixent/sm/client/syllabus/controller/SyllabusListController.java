package com.fixent.sm.client.syllabus.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.ClientConstants;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.syllabus.view.SyllabusListView;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.SyllabusInfo;
import com.fixent.sm.server.service.impl.SyllabusServiceImpl;

public class SyllabusListController 
extends BaseController {

	
	SyllabusListView view;
	List<Syllabus> syllabuses;
	
	public SyllabusListController() {
		
		view = new SyllabusListView();
		
		view.getViewButton().addActionListener(new ViewAction());
		view.getModifyButton().addActionListener(new ModifyAction());
		view.getCancelButton().addActionListener(new CancelAction());
		
		SyllabusInfo syllabusInfo = (SyllabusInfo) pop("SyllabusInfo");
		push("SyllabusInfo", syllabusInfo);
		
		if (syllabusInfo != null) {
			
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			syllabuses = impl.searchSyllabus(syllabusInfo);
			SyllabusListDataTable dataModel = new SyllabusListDataTable(syllabuses);
			view.getSyllabusTable().setModel(dataModel);
			
		}
	}
	
	class ViewAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
		
			push(ClientConstants.SCREEN_MODE, ClientConstants.VIEW);
			final int row = view.getSyllabusTable().getSelectedRow();
	        Syllabus syllabus = getSyllabus((Integer)view.getSyllabusTable().getValueAt(row, 0));
	        
	        push("Syllabus", syllabus);
	        RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new SyllabusController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
		
	}
	
	Syllabus getSyllabus(int id) {
		
		for (Syllabus syllabus : syllabuses) {
			
			if (syllabus.getId() == id) {
				return syllabus;
			}
		}
		return null;
	}
	
	
	class CancelAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new SyllabusDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
		
	}
	
	class ModifyAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
		
			push(ClientConstants.SCREEN_MODE, ClientConstants.MODIFY);
			final int row = view.getSyllabusTable().getSelectedRow();
	        Syllabus syllabus = getSyllabus((Integer)view.getSyllabusTable().getValueAt(row, 0));
	        push("Syllabus", syllabus);
	        RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new SyllabusController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
	}
}
