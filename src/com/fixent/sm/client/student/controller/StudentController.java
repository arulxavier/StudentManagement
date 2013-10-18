package com.fixent.sm.client.student.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.component.ADatePicker;
import com.fixent.sm.client.student.view.StudentView;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.impl.StudentServiceImpl;
import com.fixent.sm.server.service.util.ServiceUtil;

public class StudentController 
extends BaseController {
	
	StudentView view;
	
	SaveAction saveAction;
	CancelAction cancelAction;
	Student student;
	Map<String, List<Object>> prepopulates;
	
	public StudentController() {
		
		Student student = (Student)OBJECT_MAP.get("student");
		view = new StudentView();
		
		if (student != null) {
		
			this.student = student;
			setView();
		}
		
		saveAction = new SaveAction();
		cancelAction= new CancelAction();
		getPrepopulates();
		view.getSaveButton().addActionListener(saveAction);
//		view.getCancelBtn().addActionListener(cancelAction);
	}
	
	private void getPrepopulates() {
		
		StudentServiceImpl impl = new StudentServiceImpl();
		prepopulates = impl.getPrepopulate();	
	}

	class SaveAction 
	implements ActionListener {
		
		public SaveAction() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			student = new Student();
			student = getModel();
			student.setCreatedBy("admin");
			student.setCreatedDate(Calendar.getInstance().getTime());
			
			StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
			studentServiceImpl.createStudent(student);
					
			/*RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);*/
			
		}

		private Student getModel() {
			
			getPrimaryInfo();
			getParishInfo();
			getFamilyInfo();
			getEducationInfo();
			getDocumentStatus();
			
			return student;
		}

		@SuppressWarnings("deprecation")
		private void getPrimaryInfo() {
			
			student.setName(view.getNameTextField().getText());
			student.setGender(view.getGenderComboBox().getSelectedItem().toString());
			student.setDateOfBirth(new Date(view.getDateOfBirthDatePicker().getjTextField1()));
			student.setPlaceOfBirth(view.getPlaceOfBirthTextField().getText());
			student.setDateOfJoining(new Date(view.getDateOfJoiningDatePicker().getjTextField1()));
			student.setRemarks(view.getRemarksTextArea().getText());
			
			Date date = new Date(view.getDateOfJoiningDatePicker().getjTextField1());
			
			for (Object object : prepopulates.get("batch")) {
				
				Batch batch = (Batch)object;
				if (batch.getYear() == ServiceUtil.getYear(date) && batch.getType().equals("First Year")) {
					
					student.setBatch(batch);
					break;
				}
			}
		}

		@SuppressWarnings("deprecation")
		private void getParishInfo() {
			
			student.setDioCongLay(view.getDioConLayComboBox().getSelectedItem().toString());
			student.setNameOfDioCong(view.getDioConNameComboBox().getSelectedItem().toString());
			student.setParish(view.getParishTextField().getText());
			student.setVillage(view.getVillageTextField().getText());
			student.setDateOfBaptism(new Date(view.getDateOfBaptismDatePicker().getjTextField1()));
			student.setPlaceOfBaptism(view.getPlaceOfBaptismTextField().getText());
			student.setDateOfConfirmation(new Date(view.getDateOfConfirmationDatePicker().getjTextField1()));
			student.setPlaceOfConfirmation(view.getPlaceOfConfirmationTextField().getText());
		}

		private void getFamilyInfo() {
			
			student.setFatherName(view.getFatherNameTextField().getText());
			student.setMotherName(view.getMotherNameTextField().getText());
			student.setFatherLiving(view.getFatherLivingCheckBox().isSelected());
			student.setMotherLiving(view.getMotherLivingCheckBox().isSelected());
			student.setFatherOccupation(view.getFatherOccupationTextField().getText());
			student.setMotherOccupation(view.getMotherOccupationTextField().getText());
			student.setNoOfElderBrother(Integer.parseInt(view.getNoOfElderBrotherSpinner().getValue().toString()));
			student.setNoOfYoungerBrother(Integer.parseInt(view.getNoOfYoungerBrotherSpinner().getValue().toString()));
			student.setNoOfElderSister(Integer.parseInt(view.getNoOfElderSisterSpinner().getValue().toString()));
			student.setNoOfYoungerSister(Integer.parseInt(view.getNoOfYoungerSisterSpinner().getValue().toString()));
			student.setContactNumber(Integer.parseInt(view.getContactNumberTextField().getText()));
			student.setContactPerson(view.getContactPersonTextField().getText());
		}

		@SuppressWarnings("deprecation")
		private void getEducationInfo() {
			
			student.setMinorSeminaryName(view.getMinorSeminaryNameTextField().getText());
			student.setMinorSeminaryFromDate(new Date(view.getMinorSeminaryFromDatePicker().getjTextField1()));
			student.setMinorSeminaryToDate(new Date(view.getMinorSeminaryToDatePicker().getjTextField1()));
			student.setDegreeCourse(view.getDegreeTextField().getText());
			student.setDegreeCollege(view.getCollegeNameTextField().getText());
			student.setDegreeFromDate(new Date(view.getDegreeFromDatePicker().getjTextField1()));
			student.setDegreeToDate(new Date(view.getDegreeToDatePicker().getjTextField1()));
			student.setPhilosophySeminary(view.getPhilosophySeminaryNameTextField1().getText());
			student.setPhilosophyFromDate(new Date(view.getPhilosophyFromDatePicker().getjTextField1()));
			student.setPhilosophyToDate(new Date(view.getPhilosophyToDatePicker().getjTextField1()));
			student.setRegencyParish(view.getRegencyParishNameTextField().getText());
			student.setRegencyFromDate(new Date(view.getRegencyFromDatePicker().getjTextField1()));
			student.setRegencyToDate(new Date(view.getRegencyToDatePicker().getjTextField1()));
			student.setSpiritualitySeminary(view.getSpiritualitySeminaryNameTextField().getText());
			student.setSpiritualityFromDate(new Date(view.getSpiritualityFromDatePicker().getjTextField1()));
			student.setSpiritualityToDate(new Date(view.getSpiritualityToDatePicker().getjTextField1()));
			
		}

		private void getDocumentStatus() {
			
			student.setCertificateOfBaptism(view.getCertificateofBaptismCheckBox().isSelected());
			student.setCertificateOfConfirmation(view.getCertificateOfConfirmationCheckBox().isSelected());
			student.setMarriageCertificateOfParents(view.getMarriageCertificateOfParentsCheckBox().isSelected());
			student.setCertificateOfPhilosophy(view.getCertificateOfPhilosophyCheckBox().isSelected());
			student.setFinalReportFromThePhilosophate(view.getFinalReportOfPhilosophateCheckBox().isSelected());
			student.setRegencyReport(view.getRegencyReportCheckBox().isSelected());
			student.setSpiritualYearFinalAssessment(view.getSpiritualYearFinalCheckBox().isSelected());
			student.setDegreeCertificate(view.getDegreeCertificateCheckBox().isSelected());
			student.setPassportSizePhoto(view.getPassportSizePhotoCheckBox().isSelected());
		}
		
	}
	
	class CancelAction 
	implements ActionListener {
		
		public CancelAction() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
	}
	
	public void setView() {
		
		setPrimaryInfo();
		setParishInfo();
		setFamilyInfo();
		setEducationInfo();
		setDocumentStatus();

	}

	private void setPrimaryInfo() {
		
		view.getRegNoTextField().setText(String.valueOf(student.getRegNo()));
		view.getNameTextField().setText(student.getName());
		view.getGenderComboBox().setSelectedItem(student.getGender());
		view.getDateOfBirthDatePicker().setDateTextField(student.getDateOfBirth().toString());
		view.getPlaceOfBirthTextField().setText(student.getPlaceOfBirth());
		view.getDateOfJoiningDatePicker().setDateTextField(student.getDateOfJoining().toString());
		view.getRemarksTextArea().setText(student.getRemarks());
	}

	private void setParishInfo() {
		
		view.getDioConLayComboBox().setSelectedItem(student.getDioCongLay());
		view.getDioConNameComboBox().setSelectedItem(student.getNameOfDioCong());
		view.getParishTextField().setText(student.getParish());
		view.getVillageTextField().setText(student.getVillage());
		view.getDateOfBaptismDatePicker().setDateTextField(student.getDateOfBaptism().toString());
		view.getPlaceOfBaptismTextField().setText(student.getPlaceOfBaptism());
		view.getDateOfConfirmationDatePicker().setDateTextField(student.getDateOfConfirmation().toString());
		view.getPlaceOfConfirmationTextField().setText(student.getPlaceOfConfirmation());
	}

	private void setFamilyInfo() {
		// TODO Auto-generated method stub
		
	}

	private void setEducationInfo() {
		// TODO Auto-generated method stub
		
	}

	private void setDocumentStatus() {
		// TODO Auto-generated method stub
		
	}

}
