package com.fixent.sm.client.mark.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.mark.view.MarkModifyView;
import com.fixent.sm.server.model.Mark;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.MarkInfo;
import com.fixent.sm.server.model.info.SyllabusInfo;
import com.fixent.sm.server.service.impl.MarkServiceImpl;
import com.fixent.sm.server.service.impl.SyllabusServiceImpl;

public class MarkModifyController 
extends BaseController {

	MarkModifyView view;
	List<Mark> marks;
	
	public MarkModifyController() {
		
		view = new MarkModifyView();
		view.getYearComboBox().setModel(getYears());
		view.getSemasterComboBox().addItemListener(new SemasterChangeEvent());
		view.getSubjectComboBox().addItemListener(new SubjectChangeEvent());
		view.getSaveButton().addActionListener(new SaveAction());
	}
	
	class SemasterChangeEvent
	implements ItemListener {

		
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
		          Object item = e.getItem();
		          System.out.println(item);
		          
		          SyllabusInfo syllabusInfo = new SyllabusInfo();
		          syllabusInfo.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
		          syllabusInfo.setType(view.getYearTypeComboBox().getSelectedItem().toString());
		          syllabusInfo.setSemaster(Integer.parseInt(view.getSemasterComboBox().getSelectedItem().toString()));
		          SyllabusServiceImpl impl = new SyllabusServiceImpl();
		          Syllabus syllabus = impl.getSyllabus(syllabusInfo); 
		          Set<Subject> subjects = syllabus.getSubjects();

		          DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		          boxModel.addElement("Select One");
		          for (Subject subject : subjects) {

		        	  boxModel.addElement(subject.getName());
		          }
		          view.getSubjectComboBox().setModel(boxModel);
		    }
		}
		
	}
	
	class SubjectChangeEvent
	implements ItemListener {

		
		public void itemStateChanged(ItemEvent e) {

			if (e.getStateChange() == ItemEvent.SELECTED) {
		          Object item = e.getItem();
		          
		          MarkInfo markInfo = new MarkInfo();
		          markInfo.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
		          markInfo.setType(view.getYearTypeComboBox().getSelectedItem().toString());
		          markInfo.setSemaster(Integer.parseInt(view.getSemasterComboBox().getSelectedItem().toString()));
		          markInfo.setSubject(view.getSubjectComboBox().getSelectedItem().toString());
		          
		          MarkServiceImpl impl = new MarkServiceImpl();
		          marks = impl.searchMark(markInfo);
		          
		          MarkListDataTable dataModel = new MarkListDataTable(marks);
		          view.getMarkTable().setModel(dataModel);
		    }
		}
		
	}
	
	class SaveAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			
			int row = view.getMarkTable().getRowCount();
			int column = view.getMarkTable().getColumnCount();
			
			for (int j = 0; j  < row; j++) {
				
				Mark mark = getMark((Integer)view.getMarkTable().getValueAt(j, 0));
				mark.setMark((Double)view.getMarkTable().getValueAt(j, 3));
			}
			
			MarkServiceImpl impl = new MarkServiceImpl();
			impl.modifyMarkList(marks);
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new MarkDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
		
	}
	
	Mark getMark(int id) {
		
		for (Mark mark : marks) {
			
			if (mark.getId() == id) {
				return mark;
			}
		}
		return null;
	}
	
}
