package com.fixent.sm.server.model;

import java.util.Date;
import java.util.Set;


public class Student {
	
	int id;
	int regNo;
	String name;
	String createdBy;
	Date createdDate;
	String updatedBy;
	Date updatedDate;
	String gender;
	Date dateOfBirth;
	String placeOfBirth;
	String remarks;
	Date dateOfJoining;
	String fatherName;
	String motherName;
	String fatherOccupation;
	String motherOccupation;
	int contactNumber;
	String contactPerson;
	Date dateOfBaptism;
	String placeOfBaptism;
	Date dateOfConfirmation;
	String placeOfConfirmation;
	boolean fatherLiving;
	boolean motherLiving;
	int noOfElderBrother;
	int noOfYoungerBrother;
	int noOfElderSister;
	int noOfYoungerSister;
	String parish;
	String village;
	String dioCongLay;
	String nameOfDioCong;
	String minorSeminaryName;
	Date minorSeminaryFromDate;
	Date minorSeminaryToDate;
	String degreeCourse;
	String degreeCollege;
	Date degreeFromDate;
	Date degreeToDate;
	String philosophySeminary;
	Date philosophyFromDate;
	Date philosophyToDate;
	String regencyParish;
	Date regencyFromDate;
	Date regencyToDate;
	String spiritualitySeminary;
	Date spiritualityFromDate;
	Date spiritualityToDate;
	boolean certificateOfBaptism;
	boolean certificateOfConfirmation;
	boolean marriageCertificateOfParents;
	boolean certificateOfPhilosophy;
	boolean finalReportFromThePhilosophate;
	boolean regencyReport;
	boolean spiritualYearFinalAssessment;
	boolean degreeCertificate;
	boolean passportSizePhoto;
	Double mark;
	
	
	Batch batch;	
	Set<Mark> marks;
	Diocese diocese;
	Congregation congregation;
	Address address;
	Set<Ministry> ministries;
	Set<DocumentStatus> documentStatus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getDateOfBaptism() {
		return dateOfBaptism;
	}
	public void setDateOfBaptism(Date dateOfBaptism) {
		this.dateOfBaptism = dateOfBaptism;
	}
	public String getPlaceOfBaptism() {
		return placeOfBaptism;
	}
	public void setPlaceOfBaptism(String placeOfBaptism) {
		this.placeOfBaptism = placeOfBaptism;
	}
	public Date getDateOfConfirmation() {
		return dateOfConfirmation;
	}
	public void setDateOfConfirmation(Date dateOfConfirmation) {
		this.dateOfConfirmation = dateOfConfirmation;
	}
	public String getPlaceOfConfirmation() {
		return placeOfConfirmation;
	}
	public void setPlaceOfConfirmation(String placeOfConfirmation) {
		this.placeOfConfirmation = placeOfConfirmation;
	}
	public boolean isFatherLiving() {
		return fatherLiving;
	}
	public void setFatherLiving(boolean fatherLiving) {
		this.fatherLiving = fatherLiving;
	}
	public boolean isMotherLiving() {
		return motherLiving;
	}
	public void setMotherLiving(boolean motherLiving) {
		this.motherLiving = motherLiving;
	}
	public int getNoOfElderBrother() {
		return noOfElderBrother;
	}
	public void setNoOfElderBrother(int noOfElderBrother) {
		this.noOfElderBrother = noOfElderBrother;
	}
	public int getNoOfYoungerBrother() {
		return noOfYoungerBrother;
	}
	public void setNoOfYoungerBrother(int noOfYoungerBrother) {
		this.noOfYoungerBrother = noOfYoungerBrother;
	}
	public int getNoOfElderSister() {
		return noOfElderSister;
	}
	public void setNoOfElderSister(int noOfElderSister) {
		this.noOfElderSister = noOfElderSister;
	}
	public int getNoOfYoungerSister() {
		return noOfYoungerSister;
	}
	public void setNoOfYoungerSister(int noOfYoungerSister) {
		this.noOfYoungerSister = noOfYoungerSister;
	}
	public String getParish() {
		return parish;
	}
	public void setParish(String parish) {
		this.parish = parish;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDioCongLay() {
		return dioCongLay;
	}
	public void setDioCongLay(String dioCongLay) {
		this.dioCongLay = dioCongLay;
	}
	public String getNameOfDioCong() {
		return nameOfDioCong;
	}
	public void setNameOfDioCong(String nameOfDioCong) {
		this.nameOfDioCong = nameOfDioCong;
	}
	public String getMinorSeminaryName() {
		return minorSeminaryName;
	}
	public void setMinorSeminaryName(String minorSeminaryName) {
		this.minorSeminaryName = minorSeminaryName;
	}
	public Date getMinorSeminaryFromDate() {
		return minorSeminaryFromDate;
	}
	public void setMinorSeminaryFromDate(Date minorSeminaryFromDate) {
		this.minorSeminaryFromDate = minorSeminaryFromDate;
	}
	public Date getMinorSeminaryToDate() {
		return minorSeminaryToDate;
	}
	public void setMinorSeminaryToDate(Date minorSeminaryToDate) {
		this.minorSeminaryToDate = minorSeminaryToDate;
	}
	public String getDegreeCourse() {
		return degreeCourse;
	}
	public void setDegreeCourse(String degreeCourse) {
		this.degreeCourse = degreeCourse;
	}
	public String getDegreeCollege() {
		return degreeCollege;
	}
	public void setDegreeCollege(String degreeCollege) {
		this.degreeCollege = degreeCollege;
	}
	public Date getDegreeFromDate() {
		return degreeFromDate;
	}
	public void setDegreeFromDate(Date degreeFromDate) {
		this.degreeFromDate = degreeFromDate;
	}
	public Date getDegreeToDate() {
		return degreeToDate;
	}
	public void setDegreeToDate(Date degreeToDate) {
		this.degreeToDate = degreeToDate;
	}
	public String getPhilosophySeminary() {
		return philosophySeminary;
	}
	public void setPhilosophySeminary(String philosophySeminary) {
		this.philosophySeminary = philosophySeminary;
	}
	public Date getPhilosophyFromDate() {
		return philosophyFromDate;
	}
	public void setPhilosophyFromDate(Date philosophyFromDate) {
		this.philosophyFromDate = philosophyFromDate;
	}
	public Date getPhilosophyToDate() {
		return philosophyToDate;
	}
	public void setPhilosophyToDate(Date philosophyToDate) {
		this.philosophyToDate = philosophyToDate;
	}
	public String getRegencyParish() {
		return regencyParish;
	}
	public void setRegencyParish(String regencyParish) {
		this.regencyParish = regencyParish;
	}
	public Date getRegencyFromDate() {
		return regencyFromDate;
	}
	public void setRegencyFromDate(Date regencyFromDate) {
		this.regencyFromDate = regencyFromDate;
	}
	public Date getRegencyToDate() {
		return regencyToDate;
	}
	public void setRegencyToDate(Date regencyToDate) {
		this.regencyToDate = regencyToDate;
	}
	public String getSpiritualitySeminary() {
		return spiritualitySeminary;
	}
	public void setSpiritualitySeminary(String spiritualitySeminary) {
		this.spiritualitySeminary = spiritualitySeminary;
	}
	public Date getSpiritualityFromDate() {
		return spiritualityFromDate;
	}
	public void setSpiritualityFromDate(Date spiritualityFromDate) {
		this.spiritualityFromDate = spiritualityFromDate;
	}
	public Date getSpiritualityToDate() {
		return spiritualityToDate;
	}
	public void setSpiritualityToDate(Date spiritualityToDate) {
		this.spiritualityToDate = spiritualityToDate;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public Set<Mark> getMarks() {
		return marks;
	}
	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}
	public Diocese getDiocese() {
		return diocese;
	}
	public void setDiocese(Diocese diocese) {
		this.diocese = diocese;
	}
	public Congregation getCongregation() {
		return congregation;
	}
	public void setCongregation(Congregation congregation) {
		this.congregation = congregation;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Ministry> getMinistries() {
		return ministries;
	}
	public void setMinistries(Set<Ministry> ministries) {
		this.ministries = ministries;
	}
	public Set<DocumentStatus> getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(Set<DocumentStatus> documentStatus) {
		this.documentStatus = documentStatus;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public boolean isCertificateOfBaptism() {
		return certificateOfBaptism;
	}
	public void setCertificateOfBaptism(boolean certificateOfBaptism) {
		this.certificateOfBaptism = certificateOfBaptism;
	}
	public boolean isCertificateOfConfirmation() {
		return certificateOfConfirmation;
	}
	public void setCertificateOfConfirmation(boolean certificateOfConfirmation) {
		this.certificateOfConfirmation = certificateOfConfirmation;
	}
	public boolean isMarriageCertificateOfParents() {
		return marriageCertificateOfParents;
	}
	public void setMarriageCertificateOfParents(boolean marriageCertificateOfParents) {
		this.marriageCertificateOfParents = marriageCertificateOfParents;
	}
	public boolean isCertificateOfPhilosophy() {
		return certificateOfPhilosophy;
	}
	public void setCertificateOfPhilosophy(boolean certificateOfPhilosophy) {
		this.certificateOfPhilosophy = certificateOfPhilosophy;
	}
	public boolean isFinalReportFromThePhilosophate() {
		return finalReportFromThePhilosophate;
	}
	public void setFinalReportFromThePhilosophate(
			boolean finalReportFromThePhilosophate) {
		this.finalReportFromThePhilosophate = finalReportFromThePhilosophate;
	}
	public boolean isRegencyReport() {
		return regencyReport;
	}
	public void setRegencyReport(boolean regencyReport) {
		this.regencyReport = regencyReport;
	}
	public boolean isSpiritualYearFinalAssessment() {
		return spiritualYearFinalAssessment;
	}
	public void setSpiritualYearFinalAssessment(boolean spiritualYearFinalAssessment) {
		this.spiritualYearFinalAssessment = spiritualYearFinalAssessment;
	}
	public boolean isDegreeCertificate() {
		return degreeCertificate;
	}
	public void setDegreeCertificate(boolean degreeCertificate) {
		this.degreeCertificate = degreeCertificate;
	}
	public boolean isPassportSizePhoto() {
		return passportSizePhoto;
	}
	public void setPassportSizePhoto(boolean passportSizePhoto) {
		this.passportSizePhoto = passportSizePhoto;
	}
	public Double getMark() {
		return mark;
	}
	public void setMark(Double mark) {
		this.mark = mark;
	}
	
}
