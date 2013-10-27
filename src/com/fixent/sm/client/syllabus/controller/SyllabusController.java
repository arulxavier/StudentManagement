package com.fixent.sm.client.syllabus.controller;

import java.awt.BorderLayout;
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
import com.fixent.sm.client.common.ClientConstants;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.maintenance.controller.SubjectListDataTable;
import com.fixent.sm.client.syllabus.view.SubjectPopupView;
import com.fixent.sm.client.syllabus.view.SyllabusView;
import com.fixent.sm.server.model.Subject;
import com.fixent.sm.server.model.Syllabus;
import com.fixent.sm.server.model.info.SyllabusInfo;
import com.fixent.sm.server.service.impl.SubjectServiceImpl;
import com.fixent.sm.server.service.impl.SyllabusServiceImpl;

public class SyllabusController extends BaseController {

	SyllabusView view;
	JDialog subjectPopup;
	List<Subject> subjects;
	List<Subject> selectedSubjects;
	Syllabus syllabus;
	SyllabusInfo syllabusInfo;
	String screenMode;

	public SyllabusController() {

		view = new SyllabusView();
		view.getYearComboBox().setModel(getYears());
		screenMode = (String) pop(ClientConstants.SCREEN_MODE);
		syllabusInfo = (SyllabusInfo) pop("SyllabusInfo");
		selectedSubjects = new ArrayList<Subject>();
		view.getMainDeleteButton().setVisible(false);
		if (ClientConstants.MODIFY.equalsIgnoreCase(screenMode)) {
			syllabus = (Syllabus) pop("Syllabus");
			if (syllabus != null) {

				setView(syllabus);
			}
		} else if (ClientConstants.VIEW.equals(screenMode)) {

			syllabus = (Syllabus) pop("Syllabus");
			if (syllabus != null) {

				setView(syllabus);
				setViewMode();
			}
		}

		SubjectServiceImpl impl = new SubjectServiceImpl();
		subjects = impl.getSubjects();

		view.getSaveButton().addActionListener(new SaveAction());
		view.getAddButton().addActionListener(new AddAction());
		view.getCancelButton().addActionListener(new CancelAction());
		view.getDeleteButton().addActionListener(new DeleteAction());
		view.getMainDeleteButton().addActionListener(new MainDeleteAction());
	}

	private void setViewMode() {

		view.getYearComboBox().setEnabled(false);
		view.getYearTypeComboBox().setEnabled(false);
		view.getSemasterComboBox().setEnabled(false);
		view.getSubjectTable().setEnabled(false);
		view.getAddButton().setVisible(false);
		view.getDeleteButton().setVisible(false);
		view.getSaveButton().setVisible(false);
		view.getMainDeleteButton().setVisible(true);

	}

	private void setView(Syllabus syllabus2) {

		view.getYearComboBox().setSelectedItem(
				String.valueOf(syllabus2.getYear()));
		view.getYearTypeComboBox().setSelectedItem(syllabus2.getType());
		view.getSemasterComboBox().setSelectedItem(
				String.valueOf(syllabus2.getSemaster()));
		SubjectListDataTable dataModel = new SubjectListDataTable(
				new ArrayList<Subject>(syllabus2.getSubjects()));
		view.getSubjectTable().setModel(dataModel);
		selectedSubjects.addAll(syllabus2.getSubjects());
	}

	class SaveAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMessages(view.getParent(), "");
			SyllabusServiceImpl impl = new SyllabusServiceImpl();
			if(checkErrors() && ClientConstants.ADD.equalsIgnoreCase(screenMode))
			{
				setErrorMessages(view.getParent(), "Syllabus created for the entered year & semester");
				return;
			}
			if(ClientConstants.ADD.equalsIgnoreCase(screenMode))
			{
				syllabus = new Syllabus();
				syllabus.setYear(Integer.parseInt(view.getYearComboBox()
						.getSelectedItem().toString()));
				syllabus.setType(view.getYearTypeComboBox().getSelectedItem()
						.toString());
				syllabus.setSemaster(Integer.parseInt(view.getSemasterComboBox()
						.getSelectedItem().toString()));
				Set<Subject> subjects = new HashSet<Subject>();
				subjects.addAll(selectedSubjects);
				syllabus.setSubjects(subjects);
				syllabus.setCreatedBy("Admin");
				syllabus.setCreatedDate(new Date());
				impl.createSyllabus(syllabus);
				
			} else {
				syllabus.setYear(Integer.parseInt(view.getYearComboBox()
						.getSelectedItem().toString()));
				syllabus.setType(view.getYearTypeComboBox().getSelectedItem()
						.toString());
				syllabus.setSemaster(Integer.parseInt(view.getSemasterComboBox()
						.getSelectedItem().toString()));
				Set<Subject> subjects = new HashSet<Subject>();
				subjects.addAll(selectedSubjects);
				syllabus.setSubjects(subjects);
				syllabus.setUpdatedBy("Admin");
				syllabus.setUpdatedDate(new Date());
				impl.modifySyllabus(syllabus);
			}
			
			push("SyllabusInfo", syllabusInfo);
			RightSidePanel rightSidePanel = (RightSidePanel) view.getParent();
			rightSidePanel.removeAll();
			if(ClientConstants.ADD.equalsIgnoreCase(screenMode))
			{
				rightSidePanel.add(new SyllabusDashboardController().view,
						BorderLayout.CENTER);
			} else {
				rightSidePanel.add(new SyllabusListController().view,
						BorderLayout.CENTER);
			}
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);

		}

	}

	class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMessages(view.getParent(), "");
			SubjectPopupView view = new SubjectPopupView();
			view.getSaveButton().addActionListener(new SaveSubjectAction(view));
			view.getCancelButton().addActionListener(new CancelSubjectAction());
			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			for (Subject subject : subjects) {

				boxModel.addElement(subject.getName());
			}
			view.getSubjectComboBox().setModel(boxModel);
			subjectPopup = new JDialog();
			subjectPopup.add(view);
			subjectPopup.setSize(425, 200);
			subjectPopup.setResizable(false);
			subjectPopup.setLocationRelativeTo(null);
			subjectPopup.setVisible(true);
		}
	}

	class SaveSubjectAction implements ActionListener {

		SubjectPopupView popupView;

		public SaveSubjectAction(SubjectPopupView view) {

			popupView = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMessages(view.getParent(), "");
			String subjectName = popupView.getSubjectComboBox()
					.getSelectedItem().toString();
			Subject subject = getSubject(subjectName);
			if (!selectedSubjects.contains(subject)) {
				selectedSubjects.add(subject);
			}
			SubjectListDataTable dataModel = new SubjectListDataTable(
					selectedSubjects);
			view.getSubjectTable().setModel(dataModel);
			subjectPopup.dispose();
		}

	}

	class CancelSubjectAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			setErrorMessages(view.getParent(), "");
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

	public boolean checkErrors() {
		
		SyllabusServiceImpl serviceImpl = new SyllabusServiceImpl();
		List<Syllabus> serList = serviceImpl.searchSyllabus(syllabusInfo);
		if (serList != null && serList.size() >0 )
		{
			return true;
		}
		return false;
	}

	class CancelAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMessages(view.getParent(), "");
			push("SyllabusInfo", syllabusInfo);
			RightSidePanel rightSidePanel = (RightSidePanel) view.getParent();
			rightSidePanel.removeAll();
			if(ClientConstants.ADD.equalsIgnoreCase(screenMode))
			{
				rightSidePanel.add(new SyllabusDashboardController().view,
						BorderLayout.CENTER);
			} else {
				rightSidePanel.add(new SyllabusListController().view,
						BorderLayout.CENTER);
			}
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}

	}

	class DeleteAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMessages(view.getParent(), "");
			final int row = view.getSubjectTable().getSelectedRow();
			selectedSubjects.remove(row);
			SubjectListDataTable dataModel = new SubjectListDataTable(
					selectedSubjects);
			view.getSubjectTable().setModel(dataModel);
		}
	}
	

	class MainDeleteAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			SyllabusServiceImpl syllabusServiceImpl = new SyllabusServiceImpl();
			boolean result = syllabusServiceImpl.isSyllabusConfigured(syllabus);
			if (result)
			{
				setErrorMessages(view.getParent(), "Cannot delete syllabus - Mark has been entered for the corresponding syllabus");
			} else 
			{
				syllabusServiceImpl.deleteSyllabus(syllabus);
			}
			push("SyllabusInfo", syllabusInfo);
			RightSidePanel rightSidePanel = (RightSidePanel) view.getParent();
			rightSidePanel.removeAll();
			if(ClientConstants.ADD.equalsIgnoreCase(screenMode))
			{
				rightSidePanel.add(new SyllabusDashboardController().view,
						BorderLayout.CENTER);
			} else {
				rightSidePanel.add(new SyllabusListController().view,
						BorderLayout.CENTER);
			}
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
	}

}
