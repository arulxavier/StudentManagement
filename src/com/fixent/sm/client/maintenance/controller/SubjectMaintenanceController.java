package com.fixent.sm.client.maintenance.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.maintenance.view.SubjectCategoryView;
import com.fixent.sm.client.maintenance.view.SubjectMaintenanceView;
import com.fixent.sm.client.maintenance.view.SubjectView;
import com.fixent.sm.server.ServiceMessage;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.SubjectCategory;
import com.fixent.sm.server.service.impl.SubjectCategoryServiceImpl;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;
import com.fixent.sm.server.service.util.SubjectCategoryServiceUtil;
import com.fixent.sm.server.service.util.SubjectServiceUtil;

public class SubjectMaintenanceController 
extends BaseController {

	public SubjectMaintenanceView view;
	List<SubjectCategory> subjectCategories;
	List<Subject> subjects;
	JDialog subjectCategoryPopup;
	JDialog subjectPopup;
	Subject subject;
	SubjectCategory subjectCategory;

	public SubjectMaintenanceController() {

		view = new SubjectMaintenanceView();
	}
	
	public void init() {
		

		view.getSubjectCategoryAddButton().addActionListener(
				new AddSubjectCategoryAction());
		view.getSubjectCategoryDeleteButton().addActionListener(
				new DeleteSubjectCategoryAction());

		view.getSubjectAddButton().addActionListener(new AddSubjectAction());
		view.getSubjectDeleteButton().addActionListener(
				new DeleteSubjectAction());
		view.getSubjectTable().addMouseListener(new SubjectTableClickAction());
		view.getSubjectCategoryTable().addMouseListener(
				new SubjectCategoryTableClickAction());
		setView();
		
	}

	private void setView() {

		setSubjectCategoryView();
		setSubjectView();
	}

	@SuppressWarnings("unchecked")
	private void setSubjectView() {

		ServiceMessage serviceMessage = SubjectServiceUtil.getSubjects();
		if (!serviceMessage.getStatus().equals("KO")) {
			subjects = (List<Subject>) serviceMessage.getInfo();
		} else {
			setErrorMessages(view.getParent(), "Can't Fetch Subject");
		}
		SubjectListDataTable model = new SubjectListDataTable(subjects);
		view.getSubjectTable().setModel(model);
		view.getSubjectTable().getColumnModel().getColumn(0).setPreferredWidth(25);
		view.getSubjectTable().getColumnModel().getColumn(0).setMaxWidth(25);
	}

	@SuppressWarnings("unchecked")
	private void setSubjectCategoryView() {
		
		ServiceMessage serviceMessage =  SubjectCategoryServiceUtil.getSubjectCategories();
		
		if (!serviceMessage.getStatus().equals("KO")) {
			
			subjectCategories = (List<SubjectCategory>) serviceMessage.getInfo();
		} else {
			setErrorMessages(view.getParent(), "Can't Fetch Subject Category");
		}
		SubjecCategorytListDataTable dataModel = new SubjecCategorytListDataTable(
																				subjectCategories);
		view.getSubjectCategoryTable().setModel(dataModel);
		view.getSubjectCategoryTable().getColumnModel().getColumn(0).setPreferredWidth(25);
		view.getSubjectCategoryTable().getColumnModel().getColumn(0).setMaxWidth(25);
	}

	class AddSubjectCategoryAction 
	implements ActionListener {

		public AddSubjectCategoryAction() {
		}

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			SubjectCategoryView view = new SubjectCategoryView();
			view.getSaveButton().addActionListener(
					new SaveSubjectCategoryAction(view));
			view.getCancelButton().addActionListener(
					new CancelSubjectCategoryAction());
			subjectCategoryPopup = new JDialog();
			subjectCategoryPopup.add(view);
			subjectCategoryPopup.setSize(425, 300);
			subjectCategoryPopup.setResizable(false);
			subjectCategoryPopup.setLocationRelativeTo(null);
			subjectCategoryPopup.setVisible(true);

		}
	}

	class SaveSubjectCategoryAction implements ActionListener {

		SubjectCategoryView view = null;

		public SaveSubjectCategoryAction(SubjectCategoryView view) {
			this.view = view;
		}

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			SubjectCategoryServiceImpl impl = new SubjectCategoryServiceImpl();
			if (subjectCategory == null) {
				subjectCategory = new SubjectCategory();
				subjectCategory.setCreatedBy("Admin");
				subjectCategory.setCreatedDate(new Date());
				subjectCategory.setName(view.getSubjectCategoryNameTextField()
						.getText());
				impl.createSubjectCategory(subjectCategory);
			} else {
				SubjectCategory localSubjectCategory = new SubjectCategory();
				localSubjectCategory.setCreatedBy(subjectCategory
						.getCreatedBy());
				localSubjectCategory.setCreatedDate(subjectCategory
						.getCreatedDate());
				localSubjectCategory.setId(subjectCategory.getId());
				localSubjectCategory.setUpdatedBy("Admin");
				localSubjectCategory.setUpdatedDate(new Date());
				localSubjectCategory.setName(view
						.getSubjectCategoryNameTextField().getText());
				impl.modifySubjectCategory(localSubjectCategory);
			}
			subjectCategory = null;
			setSubjectCategoryView();
			setSubjectView();
			subjectCategoryPopup.dispose();
		}

	}

	class CancelSubjectCategoryAction implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			subjectCategory = null;
			subjectCategoryPopup.dispose();
		}

	}

	class DeleteSubjectCategoryAction implements ActionListener {

		public DeleteSubjectCategoryAction() {
		}

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			final int row = view.getSubjectCategoryTable().getSelectedRow();
			SubjectCategory deleteObject = subjectCategories.get(row);
			SubjectCategoryServiceImpl impl = new SubjectCategoryServiceImpl();
			if (!impl.deleteSubjectCategory(deleteObject.getId())) {

				setErrorMessages(view.getParent(),
						"Cannot delete subject category when it is associated with subject");
			}
			setSubjectCategoryView();

		}

	}

	class AddSubjectAction implements ActionListener {

		public AddSubjectAction() {
		}

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			SubjectView subjectView = new SubjectView();
			subjectView.getSaveButton().addActionListener(
					new SaveSubjectAction(subjectView));
			subjectView.getCancelButton().addActionListener(
					new CancelSubjectAction());
			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			for (SubjectCategory category : subjectCategories) {
				boxModel.addElement(category.getName());
			}
			subjectView.getSubjectCategoryComboBox().setModel(boxModel);
			subjectPopup = new JDialog();
			subjectPopup.add(subjectView);
			subjectPopup.setSize(400, 400);
			subjectPopup.setLocationRelativeTo(null);
			subjectPopup.setVisible(true);

		}
	}

	class SaveSubjectAction implements ActionListener {

		SubjectView view = null;

		public SaveSubjectAction(SubjectView view) {
			this.view = view;
		}

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			SubjectServiceImpl impl = new SubjectServiceImpl();
			if (subject == null) {
				subject = new Subject();
				subject.setCreatedBy("Admin");
				subject.setCreatedDate(new Date());
				subject.setName(view.getSubjectNameTextField().getText());
				try {
					subject.setCredit(Integer.parseInt(view.getCreditTextField()
							.getText()));
				} catch (NumberFormatException e1) {
					setErrorMsg("Please enter a numerice value");
					e1.printStackTrace();
					return;
				}
				subject.setSubjectCategory(getSubjectGategory((String) view
						.getSubjectCategoryComboBox().getSelectedItem()));
				impl.createSubject(subject);
			} else {
				Subject localSubject = new Subject();
				localSubject.setCreatedBy(subject.getCreatedBy());
				localSubject.setCreatedDate(subject.getCreatedDate());
				localSubject.setId(subject.getId());
				localSubject.setUpdatedBy("Admin");
				localSubject.setUpdatedDate(new Date());
				localSubject.setName(view.getSubjectNameTextField().getText());
				try {
					localSubject.setCredit(Integer.parseInt(view.getCreditTextField()
							.getText()));
				} catch (NumberFormatException e1) {
					setErrorMsg("Please enter anumerice value");
					e1.printStackTrace();
					return;
				}
				localSubject
						.setSubjectCategory(getSubjectGategory((String) view
								.getSubjectCategoryComboBox().getSelectedItem()));
				impl.modifySubject(subject);
			}
			subject = null;
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

	class CancelSubjectAction implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			subject = null;
			subjectPopup.dispose();
		}

	}

	class DeleteSubjectAction implements ActionListener {

		public DeleteSubjectAction() {
		}

		
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			final int row = view.getSubjectTable().getSelectedRow();
			SubjectServiceImpl impl = new SubjectServiceImpl();
			impl.deleteSubject(getSubject(Integer.parseInt(view
					.getSubjectTable().getValueAt(row, 0).toString())));
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

	class SubjectTableClickAction extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			setErrorMsg("");
			if (e.getClickCount() == 2) {
				final int row = view.getSubjectTable().getSelectedRow();
				SubjectView subjectView = new SubjectView();
				subjectView.getSaveButton().addActionListener(
						new SaveSubjectAction(subjectView));
				subjectView.getCancelButton().addActionListener(
						new CancelSubjectAction());
				DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
				boxModel.addElement("Select One");
				for (SubjectCategory category : subjectCategories) {
					boxModel.addElement(category.getName());
				}
				subjectView.getSubjectCategoryComboBox().setModel(boxModel);
				subject = getSubjectBasedOnRowId(row);
				subjectView.getCreditTextField().setText(
						String.valueOf(subject.getCredit()));
				subjectView.getSubjectNameTextField()
						.setText(subject.getName());
				subjectView.getSubjectCategoryComboBox().setSelectedItem(
						subject.getSubjectCategory().getName());
				subjectPopup = new JDialog();
				subjectPopup.add(subjectView);
				subjectPopup.setSize(400, 400);
				subjectPopup.setLocationRelativeTo(null);
				subjectPopup.setVisible(true);
			}
		}
	}

	class SubjectCategoryTableClickAction extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			setErrorMsg("");
			if (e.getClickCount() == 2) {
				final int row = view.getSubjectCategoryTable().getSelectedRow();
				subjectCategory = subjectCategories.get(row);

				SubjectCategoryView view = new SubjectCategoryView();
				view.getSaveButton().addActionListener(
						new SaveSubjectCategoryAction(view));
				view.getCancelButton().addActionListener(
						new CancelSubjectCategoryAction());
				view.getSubjectCategoryNameTextField().setText(
						subjectCategory.getName());
				subjectCategoryPopup = new JDialog();
				subjectCategoryPopup.add(view);
				subjectCategoryPopup.setSize(425, 300);
				subjectCategoryPopup.setResizable(false);
				subjectCategoryPopup.setLocationRelativeTo(null);
				subjectCategoryPopup.setVisible(true);
			}
		}
	}

	private Subject getSubjectBasedOnRowId(int id) {

		return subjects.get(id);
	}

	private void setErrorMsg(String msg) {
		setErrorMessages(view.getParent(), msg);
	}

}