package com.fixent.sm.server.service.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fixent.sm.server.model.Address;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.DocumentStatus;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.service.impl.StudentServiceImpl;

public class TestStudentServiceImpl {
	
	public static void main(String[] args) {
		
		Student student = new Student();
		
		student.setContactNumber("123");
		student.setCreatedBy("admin");
		student.setCreatedDate(new Date());
		student.setDateOfBaptism(new Date());
		student.setDateOfBirth(new Date());
		student.setDateOfConfirmation(new Date());
		student.setDateOfJoining(new Date());
		student.setDegreeCollege("degree");
		student.setDegreeCourse("degreecourse");
		student.setDegreeFromDate(new Date());
		student.setDegreeToDate(new Date());
		student.setDioCongLay("diocese");
		student.setFatherLiving(true);
		student.setFatherName("father");
		student.setFatherOccupation("father occuption");
		student.setGender("male");
		student.setMinorSeminaryFromDate(new Date());
		student.setMinorSeminaryName("mino");
		student.setMinorSeminaryToDate(new Date());
		student.setMotherLiving(true);
		student.setMotherName("mother");
		student.setMotherOccupation("mother occup");
		student.setName("name1");
		student.setNameOfDioCong("dio name");
		student.setNoOfElderBrother(1);
		student.setNoOfElderSister(0);
		student.setNoOfYoungerBrother(0);
		student.setNoOfYoungerSister(0);
		student.setParish("parish");
		student.setPhilosophyFromDate(new Date());
		student.setPhilosophyToDate(new Date());
		student.setPhilosophySeminary("philosophySeminary");
		student.setPlaceOfBaptism("placeOfBaptism");
		student.setPlaceOfBirth("placeOfBirth");
		student.setPlaceOfConfirmation("placeOfConfirmation");
		student.setRegencyFromDate(new Date());
		student.setRegencyParish("regenecy parish");
		student.setRegencyToDate(new Date());
		student.setRegNo(2);
		student.setRemarks("remarks");
		student.setSpiritualityFromDate(new Date());
		student.setSpiritualityToDate(new Date());
		student.setSpiritualitySeminary("spiritualitySeminary");
		student.setUpdatedBy("updated by");
		student.setUpdatedDate(new Date());
		student.setVillage("village");
		Batch batch = new Batch();
		batch.setId(1);		
		student.setBatch(batch);
		
		Set<DocumentStatus> documentStatus = new HashSet<DocumentStatus>();
		DocumentStatus documentStatus2 = new DocumentStatus();
		documentStatus2.setDocumentName("Certificate of Baptism");
		documentStatus2.setDocumentStatus(true);
		documentStatus.add(documentStatus2);
		documentStatus2.setStudent(student);
		
		DocumentStatus documentStatus3 = new DocumentStatus();
		documentStatus3.setDocumentName("Certificate of Confirmation");
		documentStatus3.setDocumentStatus(true);
		documentStatus.add(documentStatus3);
		documentStatus3.setStudent(student);
		
		student.setDocumentStatus(documentStatus);
		
		Set<Address> addresses = new HashSet<Address>();
		Address address = new Address();
		address.setStreet("sadhsadhsa");
		address.setCity("dashfkadgf");
		address.setState("dasfdhfdsk");
		address.setCountry("adskaskdhks");
		address.setPincode(132321);
		addresses.add(address);
		
		student.setAddress(addresses);
		
		
		
		StudentServiceImpl impl = new StudentServiceImpl();
		impl.createStudent(student);
		
	}

}
