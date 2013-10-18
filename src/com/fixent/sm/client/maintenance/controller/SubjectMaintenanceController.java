package com.fixent.sm.client.maintenance.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import com.fixent.sm.client.maintenance.view.SubjectCategoryView;
import com.fixent.sm.client.maintenance.view.SubjectMaintenanceView;
import com.fixent.sm.client.maintenance.view.SubjectView;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.impl.SubjectCategoryServiceImpl;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;

public class SubjectMaintenanceController {

	public SubjectMaintenanceView view;
	List<SubjectCategory> subjectCategories;
	List<Subject> subjects;
	JDialog subjectCategoryPopup;
	JDialog subjectPopup;
	
	public SubjectMaintenanceController() {
		
		view = new SubjectMaintenanceView();
		
		view.getSubjectCategoryAddButton().addActionListener(new AddSubjectCategoryAction());
		view.getSubjectCategoryDeleteButton().addActionListener(new DeleteSubjectCategoryAction());
		
		view.getSubjectAddButton().addActionListener(new AddSubjectAction());
		view.getSubjectDeleteButton().addActionListener(new DeleteSubjectAction());
		setView();
		 
	}
	
	private void setView() {
		
		setSubjectCategoryView();
		setSubjectView();
	}

	private void setSubjectView() {
		
		SubjectServiceImpl impl = new SubjectServiceImpl();
		subjects = impl.getSubjects();
		SubjectListDataTable model = new SubjectListDataTable(subjects);
		view.getSubjectTable().setModel(model);		
	}

	private void setSubjectCategoryView() {
		
		SubjectCategoryServiceImpl subjectCategoryServiceImpl = new SubjectCategoryServiceImpl();
		subjectCategories = subjectCategoryServiceImpl.getSubjectCategories();
		SubjecCategorytListDataTable dataModel = new SubjecCategorytListDataTable(subjectCategories);
		view.getSubjectCategoryTable().setModel(dataModel);		
	}

	class AddSubjectCategoryAction
	implements ActionListener {
		
		public AddSubjectCategoryAction() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			SubjectCategoryView view = new SubjectCategoryView();
			
			view.getSaveButton().addActionListener(new SaveSubjectCategoryAction(view));
			view.getCancelButton().addActionListener(new CancelSubjectCategoryAction());
			view.getSubjectCategoryIdTextField().setEditable(false);
			
			subjectCategoryPopup = new JDialog();
			subjectCategoryPopup.add(view);
			subjectCategoryPopup.setSize(425, 300);
			subjectCategoryPopup.setResizable(false);			
			subjectCategoryPopup.setLocationRelativeTo(null);
			subjectCategoryPopup.setVisible(true);
			
		}
	}
	
	class SaveSubjectCategoryAction
	implements ActionListener {
		
		SubjectCategoryView view = null;
		public SaveSubjectCategoryAction(SubjectCategoryView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Save Action");
			SubjectCategory category = new SubjectCategory();
			category.setName(view.getSubjectCategoryNameTextField().getText());
			category.setCreatedBy("Admin");
			category.setCreatedDate(new Date());
			SubjectCategoryServiceImpl impl = new SubjectCategoryServiceImpl();
			impl.createSubjectCategory(category);			
			setSubjectCategoryView();
			subjectCategoryPopup.dispose();
			
			
			
		}
		
		
	}
	
	class CancelSubjectCategoryAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			subjectCategoryPopup.dispose();
		}
		
	}
	
	class DeleteSubjectCategoryAction
	implements ActionListener {

		public DeleteSubjectCategoryAction() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
	          final int row = view.getSubjectCategoryTable().getSelectedRow();
//	          final int column = view.getSubjectCategoryTable().getSelectedColumn();
	          System.out.println(view.getSubjectCategoryTable().getValueAt(row, 0));
	          SubjectCategoryServiceImpl impl = new SubjectCategoryServiceImpl();
	          impl.deleteSubjectCategory(Integer.parseInt(view.getSubjectCategoryTable().getValueAt(row, 0).toString()));
	          setSubjectCategoryView();
			
		}
		
	}
	
	class AddSubjectAction
	implements ActionListener {
		
		public AddSubjectAction() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			SubjectView view = new SubjectView();
			view.getSaveButton().addActionListener(new SaveSubjectAction(view));
			view.getCancelButton().addActionListener(new CancelSubjectAction());
			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			for (SubjectCategory category : subjectCategories) {
				boxModel.addElement(category.getName());
			}
			view.getSubjectCategoryComboBox().setModel(boxModel);
			subjectPopup = new JDialog();
			subjectPopup.add(view);
			subjectPopup.setSize(400, 400);
			subjectPopup.setLocationRelativeTo(null);
			subjectPopup.setVisible(true);
			
		}
	}
	
	class SaveSubjectAction
	implements ActionListener {
		
		SubjectView view = null;
		public SaveSubjectAction(SubjectView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Save Action");
			Subject category = new Subject();
			category.setName(view.getSubjectNameTextField().getText());
			category.setCredit(Integer.parseInt(view.getCreditTextField().getText()));
			category.setSubjectCategory(getSubjectGategory((String)view.getSubjectCategoryComboBox().getSelectedItem()));
			category.setCreatedBy("Admin");
			category.setCreatedDate(new Date());
			SubjectServiceImpl impl = new SubjectServiceImpl();
			impl.createSubject(category);
			setSubjectView();
			subjectPopup.dispose();
			
		}

		private SubjectCategory getSubjectGategory(String selectedItem) {
			
			for (SubjectCategory category : subjectCategories) {
				
				if (category.getName().equals(selectedItem)) {
					return category;
				}
			}
			return null;
		}
		
		
	}
	
	class CancelSubjectAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			subjectPopup.dispose();
		}
		
	}
	
	class DeleteSubjectAction
	implements ActionListener {

		public DeleteSubjectAction() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
	          final int row = view.getSubjectTable().getSelectedRow();
//	          final int column = view.getSubjectTable().getSelectedColumn();
	          System.out.println(view.getSubjectTable().getValueAt(row, 0));
	          SubjectServiceImpl impl = new SubjectServiceImpl();
	          impl.deleteSubject(getSubject(Integer.parseInt(view.getSubjectTable().getValueAt(row, 0).toString())));
	          setSubjectView();
			
		}
		
	}
	
	private Subject getSubject(int id) {
		
		for (Subject subject : subjects) {
			
			if (subject.getId() == id) {
				return subject;				
			}
		}
		return null;
		
	}

}
