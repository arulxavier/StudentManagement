package com.fixent.sm.client.common;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

import com.fixent.component.accordion.AccordionItem;
import com.fixent.component.accordion.LeftSidePanel;
import com.fixent.component.accordion.MenuClickEvent;
import com.fixent.sm.client.maintenance.controller.DioceseCongregationController;
import com.fixent.sm.client.maintenance.controller.SubjectMaintenanceController;
import com.fixent.sm.client.student.controller.StudentDashboardController;

public class AccordionEventHandler 
extends MenuClickEvent {

	LeftSidePanel leftSidePanel;
	
	public AccordionEventHandler(LeftSidePanel leftSidePanel) {
		super(leftSidePanel);
		this.leftSidePanel =  leftSidePanel;
	}
	
	@Override
    public void mousePressed(MouseEvent e) {

    	System.out.println("Clicked"); 
    	AccordionItem item = (AccordionItem) e.getSource();
       
       System.out.println("Source name: " + item.getName() + "; Source Title: " + item.getText());
    	
       for (Component component2 : leftSidePanel.getParent().getComponents()) {
			
			if (component2 instanceof JScrollPane) {
				
				for (Component component : ((JScrollPane) component2).getComponents()) {
					
					if (component instanceof JViewport) {
						
						RightSidePanel rightSidePanel = (RightSidePanel)((JViewport) component).getComponents()[0];
						rightSidePanel.removeAll();
						if (item.getText().equalsIgnoreCase("Subject/Category")) {
							
							rightSidePanel.add(new SubjectMaintenanceController()
																		.view,BorderLayout.CENTER);
						} else if (item.getText().equalsIgnoreCase("Dio/Congregation")) {
							
							rightSidePanel.add(new DioceseCongregationController()
																		.view,BorderLayout.CENTER);
							
						} else if (item.getText().trim().equalsIgnoreCase("Student Info")) {
							
							rightSidePanel.add(new StudentDashboardController()
																		.view,BorderLayout.CENTER);
							
						} else if (item.getText().equalsIgnoreCase("Syllabus")) {
							
						} else if (item.getText().equalsIgnoreCase("Mark")) {
							
						} else if (item.getText().equalsIgnoreCase("Ministry")) {
							
						} 
						rightSidePanel.repaint();
					}
				}
				
			}
		}
        
    }

}
