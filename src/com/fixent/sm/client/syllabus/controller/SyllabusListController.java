package com.fixent.sm.client.syllabus.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.fixent.sm.client.common.BaseController;
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
		
		
		SyllabusInfo syllabusInfo = (SyllabusInfo)OBJECT_MAP.get("SyllabusInfo");
		
		if (syllabusInfo != null) {
			
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			syllabuses = impl.searchSyllabus(syllabusInfo);
			SyllabusListDataTable dataModel = new SyllabusListDataTable(syllabuses);
			view.getSyllabusTable().setModel(dataModel);
			
		}
	}
	
	class ViewAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			final int row = view.getSyllabusTable().getSelectedRow();
	        System.out.println(view.getSyllabusTable().getValueAt(row, 0));
	        Syllabus syllabus = getSyllabus((Integer)view.getSyllabusTable().getValueAt(row, 0));
	        OBJECT_MAP.put("Syllabus", syllabus);
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
}
