package com.fixent.sm.client.mark.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.mark.view.MarkDashboardView;

public class MarkDashboardController 
extends BaseController {

	
	public MarkDashboardView view;
	
	public MarkDashboardController() {
		
		view = new MarkDashboardView();
		view.getAddButton().addActionListener(new AddAction());
		view.getModifyButton().addActionListener(new ModifyAction());
	}
	
	class AddAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new MarkEntryController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
	}
	
	class ModifyAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new MarkModifyController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
		
	}
}
