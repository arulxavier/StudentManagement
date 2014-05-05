package com.fixent.sm.client.mark.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.mark.view.MarkEntryView;
import com.fixent.sm.server.model.Mark;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.StudentInfo;
import com.fixent.sm.server.model.info.SyllabusInfo;
import com.fixent.sm.server.service.impl.MarkServiceImpl;
import com.fixent.sm.server.service.impl.StudentServiceImpl;
import com.fixent.sm.server.service.impl.SyllabusServiceImpl;

public class MarkEntryController
extends BaseController{

	public MarkEntryView view;
	private Syllabus syllabus;
	private Set<Subject> subjects;
	List<Student> students;
	
	public MarkEntryController() {
		
		view = new MarkEntryView();
		view.getSearchButton().addActionListener(new SearchAction());
		view.getSaveButton().addActionListener(new SaveAction());
	}
	
	
	class SearchAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			SyllabusInfo syllabusInfo = new SyllabusInfo();
			view.getYearComboBox().setModel(getYears());
			syllabusInfo.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
			syllabusInfo.setType(view.getYearTypeComboBox().getSelectedItem().toString());
			syllabusInfo.setSemaster(Integer.parseInt(view.getSemasterComboBox().getSelectedItem().toString()));
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			syllabus = impl.getSyllabus(syllabusInfo); 
			subjects = syllabus.getSubjects();
			
			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			for (Subject subject : subjects) {
				
				boxModel.addElement(subject.getName());
			}
			view.getSubjectComboBox().setModel(boxModel);
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
			studentInfo.setYearType(view.getYearTypeComboBox().getSelectedItem().toString());
			
			StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
			students = studentServiceImpl.searchStudent(studentInfo);
			
			MarEntryListDataTable dataModel = new MarEntryListDataTable(students);
			view.getMarkEntryTable().getColumnModel().getColumn(1).setPreferredWidth(100);
			view.getMarkEntryTable().getColumnModel().getColumn(1).setWidth(100);
			view.getMarkEntryTable().setModel(dataModel);		
		}
		
	}
	
	class SaveAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			int row = view.getMarkEntryTable().getRowCount();
			int column = view.getMarkEntryTable().getColumnCount();
			List<Mark> marks = new ArrayList<Mark>();
			
			for (int j = 0; j  < row; j++) {
				
				Mark mark = new Mark();
				mark.setCreatedBy("Admin");
				mark.setCreatedDate(new Date());
				mark.setMark((Double)view.getMarkEntryTable().getValueAt(j, 2));
				mark.setStudent(getStudent((Integer)view.getMarkEntryTable().getValueAt(j, 0)));
				mark.setSyllabus(syllabus);
				mark.setSubject(getSubject());
				marks.add(mark);
				
			    for (int i = 0; i  < column; i++) {
			        System.out.println(view.getMarkEntryTable().getValueAt(j, i));
			    }
			}
			
			MarkServiceImpl impl = new MarkServiceImpl();
			impl.createMarks(marks);
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new MarkDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
	}
	
	
	private Subject getSubject() {
		
		String subjectName = view.getSubjectComboBox().getSelectedItem().toString();
		
		for (Subject subject : subjects) {
			
			if (subjectName.equals(subject.getName())) {
				
				return subject;
			}
		}
		return null;
	}
	
	private Student getStudent(int id) {
		
		for (Student student : students) {
			
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

}
