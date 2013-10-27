package com.fixent.sm.client.student.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.ClientConstants;
import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.student.view.StudentView;
import com.fixent.sm.server.model.Address;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.Congregation;
import com.fixent.sm.server.model.Diocese;
import com.fixent.sm.server.model.DocumentStatus;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.impl.ConfigurationServiceImpl;
import com.fixent.sm.server.service.impl.StudentServiceImpl;
import com.fixent.sm.server.service.util.ServiceUtil;

public class StudentController extends BaseController {

	StudentView view;

	SaveAction saveAction;
	CancelAction cancelAction;
	Student student;
	List<Diocese> dioceses;
	List<Congregation> congregations;
	List<Batch> batchs;
	String screenMode;

	public StudentController() {

		getPrepopulates();
		screenMode = (String) pop(ClientConstants.SCREEN_MODE);
		view = new StudentView();
		setDateFieldDisabled();
		if (ClientConstants.ADD.equalsIgnoreCase(screenMode)) {

		} else if (ClientConstants.MODIFY.equalsIgnoreCase(screenMode)) {

			student = (Student) OBJECT_MAP.get("student");
			setView();

		} else if (ClientConstants.VIEW.equalsIgnoreCase(screenMode)) {

			student = (Student) OBJECT_MAP.get("student");
			setView();
			setViewMode();
		}

		saveAction = new SaveAction();
		cancelAction = new CancelAction();
		view.getSaveButton().addActionListener(saveAction);
		view.getCancelButton().addActionListener(cancelAction);
		view.getDioConLayComboBox().addItemListener(new DioCongChnageAction());
	}

	private void getPrepopulates() {

		ConfigurationServiceImpl configurationServiceImpl = new ConfigurationServiceImpl();
		batchs = configurationServiceImpl.getAllBatchs();
		dioceses = configurationServiceImpl.getDioceses();
		congregations = configurationServiceImpl.getCongregations();
	}

	class SaveAction implements ActionListener {

		public SaveAction() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (student == null) {

				student = new Student();
			}
			student = getModel();

			StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
			boolean status = false;
			if (screenMode.equals(ClientConstants.MODIFY)) {
				student.setUpdatedBy("admin");
				student.setUpdatedDate(Calendar.getInstance().getTime());
				status = studentServiceImpl.modifyStudent(student);
			} else {
				student.setCreatedBy("admin");
				student.setCreatedDate(Calendar.getInstance().getTime());
				status = studentServiceImpl.createStudent(student);
			}
			if (status) {
				RightSidePanel rightSidePanel = (RightSidePanel) view
						.getParent();
				rightSidePanel.removeAll();
				rightSidePanel.add(new StudentDashboardController().view,
						BorderLayout.CENTER);
				rightSidePanel.repaint();
				rightSidePanel.revalidate();
				rightSidePanel.setVisible(true);
			}

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
			student.setGender(view.getGenderComboBox().getSelectedItem()
					.toString());
			student.setDateOfBirth(new Date(view.getDateOfBirthDatePicker()
					.getjTextField1()));
			student.setPlaceOfBirth(view.getPlaceOfBirthTextField().getText());
			student.setDateOfJoining(new Date(view.getDateOfJoiningDatePicker()
					.getjTextField1()));
			student.setRemarks(view.getRemarksTextArea().getText());

			Date date = new Date(view.getDateOfJoiningDatePicker()
					.getjTextField1());

			for (Batch batch : batchs) {

				if (batch.getYear() == ServiceUtil.getYear(date)
						&& batch.getType().equals("First Year")) {

					student.setBatch(batch);
					break;
				}
			}
		}

		@SuppressWarnings("deprecation")
		private void getParishInfo() {

			student.setDioCongLay(view.getDioConLayComboBox().getSelectedItem()
					.toString());
			student.setNameOfDioCong(view.getDioConNameComboBox()
					.getSelectedItem().toString());
			student.setParish(view.getParishTextField().getText());
			student.setVillage(view.getVillageTextField().getText());
			student.setDateOfBaptism(new Date(view.getDateOfBaptismDatePicker()
					.getjTextField1()));
			student.setPlaceOfBaptism(view.getPlaceOfBaptismTextField()
					.getText());
			student.setDateOfConfirmation(new Date(view
					.getDateOfConfirmationDatePicker().getjTextField1()));
			student.setPlaceOfConfirmation(view
					.getPlaceOfConfirmationTextField().getText());
		}

		private void getFamilyInfo() {

			student.setFatherName(view.getFatherNameTextField().getText());
			student.setMotherName(view.getMotherNameTextField().getText());
			student.setFatherLiving(view.getFatherLivingCheckBox().isSelected());
			student.setMotherLiving(view.getMotherLivingCheckBox().isSelected());
			student.setFatherOccupation(view.getFatherOccupationTextField()
					.getText());
			student.setMotherOccupation(view.getMotherOccupationTextField()
					.getText());
			student.setNoOfElderBrother(Integer.parseInt(view
					.getNoOfElderBrotherSpinner().getValue().toString()));
			student.setNoOfYoungerBrother(Integer.parseInt(view
					.getNoOfYoungerBrotherSpinner().getValue().toString()));
			student.setNoOfElderSister(Integer.parseInt(view
					.getNoOfElderSisterSpinner().getValue().toString()));
			student.setNoOfYoungerSister(Integer.parseInt(view
					.getNoOfYoungerSisterSpinner().getValue().toString()));
			student.setContactNumber(view.getContactNumberTextField().getText());
			student.setContactPerson(view.getContactPersonTextField().getText());
			Set<Address> addresses = new HashSet<Address>();

			Address address = new Address();
			address.setStreet(view.getStreetTextField().getText());
			address.setCity(view.getCityTextField().getText());
			address.setState(view.getStateComboBox().getSelectedItem()
					.toString());
			address.setCountry(view.getCountryComboBox().getSelectedItem()
					.toString());
			address.setPincode(Integer.parseInt(view.getPincodeTextField()
					.getText()));
			addresses.add(address);
			student.setAddress(addresses);
		}

		@SuppressWarnings("deprecation")
		private void getEducationInfo() {

			student.setMinorSeminaryName(view.getMinorSeminaryNameTextField()
					.getText());
			student.setMinorSeminaryFromDate(new Date(view
					.getMinorSeminaryFromDatePicker().getjTextField1()));
			student.setMinorSeminaryToDate(new Date(view
					.getMinorSeminaryToDatePicker().getjTextField1()));
			student.setDegreeCourse(view.getDegreeTextField().getText());
			student.setDegreeCollege(view.getCollegeNameTextField().getText());
			student.setDegreeFromDate(new Date(view.getDegreeFromDatePicker()
					.getjTextField1()));
			student.setDegreeToDate(new Date(view.getDegreeToDatePicker()
					.getjTextField1()));
			student.setPhilosophySeminary(view
					.getPhilosophySeminaryNameTextField1().getText());
			student.setPhilosophyFromDate(new Date(view
					.getPhilosophyFromDatePicker().getjTextField1()));
			student.setPhilosophyToDate(new Date(view
					.getPhilosophyToDatePicker().getjTextField1()));
			student.setRegencyParish(view.getRegencyParishNameTextField()
					.getText());
			student.setRegencyFromDate(new Date(view.getRegencyFromDatePicker()
					.getjTextField1()));
			student.setRegencyToDate(new Date(view.getRegencyToDatePicker()
					.getjTextField1()));
			student.setSpiritualitySeminary(view
					.getSpiritualitySeminaryNameTextField().getText());
			student.setSpiritualityFromDate(new Date(view
					.getSpiritualityFromDatePicker().getjTextField1()));
			student.setSpiritualityToDate(new Date(view
					.getSpiritualityToDatePicker().getjTextField1()));

		}

		private void getDocumentStatus() {

			Set<DocumentStatus> documentStatus = new HashSet<DocumentStatus>();

			DocumentStatus documentStatus2 = new DocumentStatus();
			documentStatus2
					.setDocumentName(ClientConstants.CERTIFICATE_OF_BAPTISM);
			documentStatus2.setDocumentStatus(view
					.getCertificateofBaptismCheckBox().isSelected());
			documentStatus.add(documentStatus2);

			DocumentStatus documentStatus3 = new DocumentStatus();
			documentStatus3
					.setDocumentName(ClientConstants.CERTIFICATE_OF_CONFIRMATION);
			documentStatus3.setDocumentStatus(view
					.getCertificateOfConfirmationCheckBox().isSelected());
			documentStatus.add(documentStatus3);

			DocumentStatus documentStatus4 = new DocumentStatus();
			documentStatus4
					.setDocumentName(ClientConstants.MARRIAGE_CERTIFICATE_OF_PARENTS);
			documentStatus4.setDocumentStatus(view
					.getMarriageCertificateOfParentsCheckBox().isSelected());
			documentStatus.add(documentStatus4);

			DocumentStatus documentStatus5 = new DocumentStatus();
			documentStatus5
					.setDocumentName(ClientConstants.CERTIFICATE_OF_PHILOSOPHY_WITH_MARKSHEET);
			documentStatus5.setDocumentStatus(view
					.getCertificateOfPhilosophyCheckBox().isSelected());
			documentStatus.add(documentStatus5);

			DocumentStatus documentStatus6 = new DocumentStatus();
			documentStatus6
					.setDocumentName(ClientConstants.FINAL_REPORT_FROM_THE_PHILOSOPHATE);
			documentStatus6.setDocumentStatus(view
					.getFinalReportOfPhilosophateCheckBox().isSelected());
			documentStatus.add(documentStatus6);

			DocumentStatus documentStatus7 = new DocumentStatus();
			documentStatus7.setDocumentName(ClientConstants.REGENCY_REPORT);
			documentStatus7.setDocumentStatus(view.getRegencyReportCheckBox()
					.isSelected());
			documentStatus.add(documentStatus7);

			DocumentStatus documentStatus8 = new DocumentStatus();
			documentStatus8
					.setDocumentName(ClientConstants.SPIRITUAL_YEAR_FINAL_ASSESSMENT);
			documentStatus8.setDocumentStatus(view
					.getSpiritualYearFinalCheckBox().isSelected());
			documentStatus.add(documentStatus8);

			DocumentStatus documentStatus9 = new DocumentStatus();
			documentStatus9.setDocumentName(ClientConstants.DEGREE_CERTIFICATE);
			documentStatus9.setDocumentStatus(view
					.getDegreeCertificateCheckBox().isSelected());
			documentStatus.add(documentStatus9);

			DocumentStatus documentStatus10 = new DocumentStatus();
			documentStatus10
					.setDocumentName(ClientConstants.PASSPORT_SIZE_PHOTO);
			documentStatus10.setDocumentStatus(view
					.getPassportSizePhotoCheckBox().isSelected());
			documentStatus.add(documentStatus10);

			student.setDocumentStatus(documentStatus);
		}

	}

	class CancelAction implements ActionListener {

		public CancelAction() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			RightSidePanel rightSidePanel = (RightSidePanel) view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentDashboardController().view,
					BorderLayout.CENTER);
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
		view.getDateOfBirthDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student.getDateOfBirth()));
		view.getPlaceOfBirthTextField().setText(student.getPlaceOfBirth());
		view.getDateOfJoiningDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student.getDateOfJoining()));
		view.getRemarksTextArea().setText(student.getRemarks());
	}

	private void setParishInfo() {

		loadDioceseCombo(student.getDioCongLay());
		view.getDioConLayComboBox().setSelectedItem(student.getDioCongLay());
		view.getDioConNameComboBox()
				.setSelectedItem(student.getNameOfDioCong());
		view.getParishTextField().setText(student.getParish());
		view.getVillageTextField().setText(student.getVillage());
		view.getDateOfBaptismDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student.getDateOfBaptism()));
		view.getPlaceOfBaptismTextField().setText(student.getPlaceOfBaptism());
		view.getDateOfConfirmationDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getDateOfConfirmation()));
		view.getPlaceOfConfirmationTextField().setText(
				student.getPlaceOfConfirmation());
	}

	private void setFamilyInfo() {

		view.getFatherNameTextField().setText(student.getFatherName());
		view.getMotherNameTextField().setText(student.getMotherName());
		view.getFatherLivingCheckBox().setSelected(student.isFatherLiving());
		view.getMotherLivingCheckBox().setSelected(student.isMotherLiving());
		view.getFatherOccupationTextField().setText(
				student.getFatherOccupation());
		view.getMotherOccupationTextField().setText(
				student.getMotherOccupation());
		view.getNoOfElderBrotherSpinner().setValue(
				student.getNoOfElderBrother());
		view.getNoOfYoungerBrotherSpinner().setValue(
				student.getNoOfYoungerBrother());
		view.getNoOfElderSisterSpinner().setValue(student.getNoOfElderSister());
		view.getNoOfYoungerSisterSpinner().setValue(
				student.getNoOfYoungerSister());
		view.getContactNumberTextField().setText(
				String.valueOf(student.getContactNumber()));
		view.getContactPersonTextField().setText(student.getContactPerson());
		for (Address address : student.getAddress()) {

			view.getStreetTextField().setText(address.getStreet());
			view.getCityTextField().setText(address.getCity());
			view.getStateComboBox().setSelectedItem(address.getState());
			view.getCountryComboBox().setSelectedItem(address.getCountry());
			view.getPincodeTextField().setText(
					String.valueOf(address.getPincode()));
		}

	}

	private void setEducationInfo() {

		view.getMinorSeminaryNameTextField().setText(
				student.getMinorSeminaryName());
		view.getMinorSeminaryFromDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getMinorSeminaryFromDate()));
		view.getMinorSeminaryToDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getMinorSeminaryToDate()));

		view.getDegreeTextField().setText(student.getDegreeCourse());
		view.getCollegeNameTextField().setText(student.getDegreeCollege());
		view.getDegreeFromDatePicker()
				.setDateTextField(
						ClientConstants.DATE_FORMAT.format(student
								.getDegreeFromDate()));
		view.getDegreeToDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student.getDegreeToDate()));

		view.getPhilosophySeminaryNameTextField1().setText(
				student.getPhilosophySeminary());
		view.getPhilosophyFromDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getPhilosophyFromDate()));
		view.getPhilosophyToDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getPhilosophyToDate()));

		view.getRegencyParishNameTextField()
				.setText(student.getRegencyParish());
		view.getRegencyFromDatePicker()
				.setDateTextField(
						ClientConstants.DATE_FORMAT.format(student
								.getRegencyFromDate()));
		view.getRegencyToDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student.getRegencyToDate()));

		view.getSpiritualitySeminaryNameTextField().setText(
				student.getSpiritualitySeminary());
		view.getSpiritualityFromDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getSpiritualityFromDate()));
		view.getSpiritualityToDatePicker().setDateTextField(
				ClientConstants.DATE_FORMAT.format(student
						.getSpiritualityToDate()));
	}

	private void setDocumentStatus() {

		for (DocumentStatus documentStatus : student.getDocumentStatus()) {

			if (ClientConstants.CERTIFICATE_OF_BAPTISM.equals(documentStatus
					.getDocumentName())) {

				view.getCertificateofBaptismCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.CERTIFICATE_OF_CONFIRMATION
					.equals(documentStatus.getDocumentName())) {

				view.getCertificateOfConfirmationCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.MARRIAGE_CERTIFICATE_OF_PARENTS
					.equals(documentStatus.getDocumentName())) {

				view.getMarriageCertificateOfParentsCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.CERTIFICATE_OF_PHILOSOPHY_WITH_MARKSHEET
					.equals(documentStatus.getDocumentName())) {

				view.getCertificateOfPhilosophyCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.FINAL_REPORT_FROM_THE_PHILOSOPHATE
					.equals(documentStatus.getDocumentName())) {

				view.getFinalReportOfPhilosophateCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.REGENCY_REPORT.equals(documentStatus
					.getDocumentName())) {

				view.getRegencyReportCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.SPIRITUAL_YEAR_FINAL_ASSESSMENT
					.equals(documentStatus.getDocumentName())) {

				view.getSpiritualYearFinalCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.DEGREE_CERTIFICATE.equals(documentStatus
					.getDocumentName())) {

				view.getDegreeCertificateCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}
			if (ClientConstants.PASSPORT_SIZE_PHOTO.equals(documentStatus
					.getDocumentName())) {

				view.getPassportSizePhotoCheckBox().setSelected(
						documentStatus.isDocumentStatus());
			}

		}

	}

	private void setViewMode() {

		setPrimaryInfoViewMode();
		setParishInfoViewMode();
		setFamilyInfoViewMode();
		setEducationInfoViewMode();
		setDocumentStatusViewMode();
		view.getSaveButton().setVisible(false);

	}

	private void setPrimaryInfoViewMode() {

		view.getRegNoTextField().setEditable(false);
		view.getNameTextField().setEditable(false);
		view.getGenderComboBox().setEnabled(false);
		view.getDateOfBirthDatePicker().setEditable(false);
		view.getPlaceOfBirthTextField().setEditable(false);
		view.getDateOfJoiningDatePicker().setEditable(false);
		view.getRemarksTextArea().setEditable(false);

	}
	
	private void setDateFieldDisabled()
	{
		view.getDateOfBirthDatePicker().setTextEditable(false);
		view.getDateOfJoiningDatePicker().setTextEditable(false);
		view.getDateOfBaptismDatePicker().setTextEditable(false);
		view.getDateOfConfirmationDatePicker().setTextEditable(false);
		view.getMinorSeminaryFromDatePicker().setTextEditable(false);
		view.getMinorSeminaryToDatePicker().setTextEditable(false);
		view.getDegreeFromDatePicker().setTextEditable(false);
		view.getDegreeToDatePicker().setTextEditable(false);
		view.getPhilosophyFromDatePicker().setTextEditable(false);
		view.getPhilosophyToDatePicker().setTextEditable(false);
		view.getRegencyFromDatePicker().setTextEditable(false);
		view.getRegencyToDatePicker().setTextEditable(false);
		view.getSpiritualityFromDatePicker().setTextEditable(false);
		view.getSpiritualityToDatePicker().setTextEditable(false);
	}

	private void setParishInfoViewMode() {

		view.getDioConLayComboBox().setEnabled(false);
		view.getDioConNameComboBox().setEnabled(false);
		view.getParishTextField().setEditable(false);
		view.getVillageTextField().setEditable(false);
		view.getDateOfBaptismDatePicker().setEditable(false);
		view.getPlaceOfBaptismTextField().setEditable(false);
		view.getDateOfConfirmationDatePicker().setEditable(false);
		view.getPlaceOfConfirmationTextField().setEditable(false);
	}

	private void setFamilyInfoViewMode() {

		view.getFatherNameTextField().setEditable(false);
		view.getMotherNameTextField().setEditable(false);
		view.getFatherLivingCheckBox().setEnabled(false);
		view.getMotherLivingCheckBox().setEnabled(false);
		view.getFatherOccupationTextField().setEditable(false);
		view.getMotherOccupationTextField().setEditable(false);
		view.getNoOfElderBrotherSpinner().setEnabled(false);
		view.getNoOfYoungerBrotherSpinner().setEnabled(false);
		view.getNoOfElderSisterSpinner().setEnabled(false);
		view.getNoOfYoungerSisterSpinner().setEnabled(false);
		view.getContactNumberTextField().setEditable(false);
		view.getContactPersonTextField().setEditable(false);
		view.getStreetTextField().setEditable(false);
		view.getCityTextField().setEditable(false);
		view.getStateComboBox().setEnabled(false);
		view.getCountryComboBox().setEnabled(false);
		view.getPincodeTextField().setEditable(false);
	}

	private void setEducationInfoViewMode() {

		view.getMinorSeminaryNameTextField().setEditable(false);
		view.getMinorSeminaryFromDatePicker().setEditable(false);
		view.getMinorSeminaryToDatePicker().setEditable(false);

		view.getDegreeTextField().setEditable(false);
		view.getCollegeNameTextField().setEditable(false);
		view.getDegreeFromDatePicker().setEditable(false);
		view.getDegreeToDatePicker().setEditable(false);

		view.getPhilosophySeminaryNameTextField1().setEditable(false);
		view.getPhilosophyFromDatePicker().setEditable(false);
		view.getPhilosophyToDatePicker().setEditable(false);

		view.getRegencyParishNameTextField().setEditable(false);
		view.getRegencyFromDatePicker().setEditable(false);
		view.getRegencyToDatePicker().setEditable(false);

		view.getSpiritualitySeminaryNameTextField().setEditable(false);
		view.getSpiritualityFromDatePicker().setEditable(false);
		view.getSpiritualityToDatePicker().setEditable(false);
	}

	private void setDocumentStatusViewMode() {

		view.getCertificateofBaptismCheckBox().setEnabled(false);
		view.getCertificateOfConfirmationCheckBox().setEnabled(false);
		view.getMarriageCertificateOfParentsCheckBox().setEnabled(false);
		view.getCertificateOfPhilosophyCheckBox().setEnabled(false);
		view.getFinalReportOfPhilosophateCheckBox().setEnabled(false);
		view.getRegencyReportCheckBox().setEnabled(false);
		view.getSpiritualYearFinalCheckBox().setEnabled(false);
		view.getDegreeCertificateCheckBox().setEnabled(false);
		view.getPassportSizePhotoCheckBox().setEnabled(false);

	}

	class DioCongChnageAction implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {

			String value = view.getDioConLayComboBox().getSelectedItem()
					.toString();

			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			if ("Diocese".equals(value)) {

				for (Diocese diocese : dioceses) {
					boxModel.addElement(diocese.getName());
				}
			} else if ("Congregation".equals(value)) {

				for (Congregation congregation : congregations) {
					boxModel.addElement(congregation.getName());
				}

			}
			view.getDioConNameComboBox().setModel(boxModel);

		}

	}
	
	private void loadDioceseCombo(String value)
	{
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		boxModel.addElement("Select One");
		if ("Diocese".equals(value)) {

			for (Diocese diocese : dioceses) {
				boxModel.addElement(diocese.getName());
			}
		} else if ("Congregation".equals(value)) {

			for (Congregation congregation : congregations) {
				boxModel.addElement(congregation.getName());
			}
		}
		view.getDioConNameComboBox().setModel(boxModel);
	}

}
