package com.fixent.sm.client.student.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import com.fixent.sm.client.common.RightSidePanel;
import com.fixent.sm.client.student.view.StudentView;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.impl.StudentServiceImpl;

public class StudentController {
	
	StudentView view;
	
	SaveAction saveAction;
	CancelAction cancelAction;
	Student student;
	
	public StudentController() {
		
		saveAction = new SaveAction();
		cancelAction= new CancelAction();
		view = new StudentView();
		view.getSaveButton().addActionListener(saveAction);
		view.getCancelBtn().addActionListener(cancelAction);
	}
	
	class SaveAction 
	implements ActionListener {
		
		public SaveAction() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Student student = new Student();
			student.setName(view.getNameTextField().getText());
			student.setType(view.getTypeComboBox().getModel().getSelectedItem().toString());
			student.setDateOfBirth(new Date(view.getDateOfBirth().getjTextField1()));
			student.setPlaceOfBirth(view.getPlaceOfBirthComboBox().getModel().getSelectedItem().toString());
			student.setDateOfBaptism(new Date(view.getDateOfBaptism().getjTextField1()));
			student.setPlaceOfBaptism(view.getPlaceOfBaptismComboBox().getModel().getSelectedItem().toString());
			student.setDateOfConfirmation(new Date(view.getDateOfConfirmation().getjTextField1()));
			student.setPlaceOfRegency(view.getPlaceOfRegencyTextField().getText());
			student.setParentsNmae(view.getParentsNameTextField().getText());
			student.setParentsLiving(view.getParentsLivingComboBox().getSelectedItem().toString());
			student.setBrothers(Integer.parseInt(view.getBrothersTextField().getText()));
			student.setSisters(Integer.parseInt(view.getSistersTextField().getText()));
			student.setOccupationOfParents(view.getOccupationOfParentsTextField().getText());
			student.setParentsAddress(view.getParentsAddressTextField().getText());
			student.setSecularStudies(view.getSecularStudiesTextField().getText());
			student.setMinorSeminary(view.getMinorSeminaryTextField().getText());
			student.setMajorSeminary(view.getMajorSeminaryTextField().getText());
			student.setCertificateOfPhilosopy(view.getCertificateOfPhilosophyCourseCheckBox().isSelected());
			student.setSpiritualYearFinalAssessment(view.getSpirtiualYearFinalAssessmentCheckBox().isSelected());
			student.setBaptismAndConfirmation(view.getBaptismAndConfirmationCheckBox().isSelected());
			student.setDegreeCertificate(view.getDegreeCertificateCheckBox().isSelected());
			student.setFinalReportFromMajorSeminary(view.getFinalReportfromTheMajorSeminaryCheckBox().isSelected());
			student.setRegencyRfeport(view.getRegencyReportCheckBox().isSelected());
			student.setPassportSizePhoto(view.getPassportSizePhotoCheckBox().isSelected());
			student.setMarriageCertificateOfParents(view.getMarriageCertificateOftheParentsCheckBox().isSelected());
			
			
			/*student.setName("jashdhkjsa");
			student.setType("djfdjfk");
			student.setDateOfBirth(new Date("17-Aug-2013"));
			student.setPlaceOfBirth("sadhsadk");
			student.setDateOfBaptism(new Date("17-Aug-2013"));
			student.setPlaceOfBaptism("sadsad");
			student.setDateOfConfirmation(new Date("17-Aug-2013"));
			student.setPlaceOfRegency("zsdfdfhdkjh");
			student.setParentsNmae("sdjsadlksjdl");
			student.setParentsLiving("asdjbksahd");
			student.setBrothers(2);
			student.setSisters(3);
			student.setOccupationOfParents("sadkjsadk");
			student.setParentsAddress("sadsadhshkj");
			student.setSecularStudies("asdfash");
			student.setMinorSeminary("safjhjsadhsado");
			student.setMajorSeminary("lihkjliyl");
			student.setCertificateOfPhilosopy(true);
			student.setSpiritualYearFinalAssessment(true);
			student.setBaptismAndConfirmation(true);
			student.setDegreeCertificate(true);
			student.setFinalReportFromMajorSeminary(true);
			student.setRegencyRfeport(true);
			student.setPassportSizePhoto(true);
			student.setMarriageCertificateOfParents(true);*/
			
			StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
			studentServiceImpl.createStudent(student);
					
			RightSidePanel rightSidePanel = (RightSidePanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new StudentDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
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
	
	public void setView()
	{
//		view.setName(student.getName());
//		view.getTypeComboBox().setSelectedItem(student.getType());
//		view.getDateOfBirth().getjTextField1().get  student.getDateOfBirth().toString());
//		view.get
	}

}
