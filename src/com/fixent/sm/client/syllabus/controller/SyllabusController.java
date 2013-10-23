package com.fixent.sm.client.syllabus.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.maintenance.controller.SubjectListDataTable;
import com.fixent.sm.client.syllabus.view.SubjectPopupView;
import com.fixent.sm.client.syllabus.view.SyllabusView;
import com.fixent.sm.server.model.Mark;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;
import com.fixent.sm.server.service.impl.SyllabusServiceImpl;

public class SyllabusController 
extends BaseController {
	
	SyllabusView view;
	JDialog subjectPopup;
	List<Subject> subjects;
	List<Subject> selectedSubjects;
	Syllabus syllabus;
	
	public SyllabusController() {
		
		view = new SyllabusView();
		
		syllabus = (Syllabus) OBJECT_MAP.get("Syllabus");
		if (syllabus != null) {
			
			setView(syllabus);
		}
		
		selectedSubjects = new ArrayList<Subject>();
		SubjectServiceImpl impl = new SubjectServiceImpl();
		subjects = impl.getSubjects();
		
		view.getSaveButton().addActionListener(new SaveAction());
		view.getAddButton().addActionListener(new AddAction());
	}
	
	private void setView(Syllabus syllabus2) {
		
		view.getYearComboBox().setSelectedItem(String.valueOf(syllabus2.getYear()));
		view.getYearTypeComboBox().setSelectedItem(syllabus2.getType());
		view.getSemasterComboBox().setSelectedItem(String.valueOf(syllabus2.getSemaster()));
		
		SubjectListDataTable dataModel = new SubjectListDataTable(new ArrayList<Subject>(syllabus2.getSubjects()));
		view.getSubjectTable().setModel(dataModel);
		
	}

	class SaveAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Syllabus syllabus = new Syllabus();
			syllabus.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
			syllabus.setType(view.getYearTypeComboBox().getSelectedItem().toString());
			syllabus.setSemaster(Integer.parseInt(view.getSemasterComboBox().getSelectedItem().toString()));
			
			
			int row = view.getSubjectTable().getRowCount();
			int column = view.getSubjectTable().getColumnCount();
			Set<Subject> subjects = new HashSet<Subject>();
			
			for (int j = 0; j  < row; j++) {
				subjects.add(getSubject((String)view.getSubjectTable().getValueAt(j, 2)));
			}
			
			syllabus.setSubjects(subjects);
			syllabus.setCreatedBy("Admin");
			syllabus.setCreatedDate(new Date());
			
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			impl.createSyllabus(syllabus);
			
		}
		
	}
	
	class AddAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			SubjectPopupView view = new SubjectPopupView();
			
			view.getSaveButton().addActionListener(new SaveSubjectAction(view));
			view.getCancelButton().addActionListener(new CancelSubjectAction());
			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			for(Subject subject : subjects) {
				
				boxModel.addElement(subject.getName());
			}
			view.getSubjectComboBox().setModel(boxModel);
			subjectPopup = new JDialog();
			subjectPopup.add(view);
			subjectPopup.setSize(425, 300);
			subjectPopup.setResizable(false);			
			subjectPopup.setLocationRelativeTo(null);
			subjectPopup.setVisible(true);
			
		}
		
	}
	
	class SaveSubjectAction
	implements ActionListener {
		
		SubjectPopupView popupView;
		
		public SaveSubjectAction(SubjectPopupView view) {
			
			popupView = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String subjectName = popupView.getSubjectComboBox().getSelectedItem().toString();
			
			selectedSubjects.add(getSubject(subjectName));
			SubjectListDataTable dataModel = new SubjectListDataTable(selectedSubjects);
			view.getSubjectTable().setModel(dataModel);
			
			subjectPopup.dispose();
		}
		
	}
	
	class CancelSubjectAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			subjectPopup.dispose();			
		}
		
	}
	
	Subject getSubject(String subjectname) {
		
		for (Subject subject : subjects) {
			
			if (subject.getName().equals(subjectname)) {
				return subject;
			}
			
		}
		return null;
	}

}
