package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.User;

public class UserDAO {

	private Connection connect = null;
//	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public Boolean login(User user) {

		boolean status = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT?user=smuser&password=smpw");

//			statement = connect.createStatement();
//			resultSet = statement.executeQuery("select * from user");
			preparedStatement = connect
					.prepareStatement("select * from user where user_name = ? and password = ?;");
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			status = preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean createStudent(Student student) {
		
		boolean status = false;
		int value = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT?user=smuser&password=smpw");

//			statement = connect.createStatement();
//			resultSet = statement.executeQuery("select * from user");
			preparedStatement = connect
					.prepareStatement("INSERT INTO STUDENT_INFO ("
							+ "ID,"
							+ "NAME,"
							+ "TYPE,"
							+ "DATE_OF_BIRTH,"
							+ "PLACE_OF_BIRTH,"
							+ "DATE_OF_BAPTISM,"
							+ "PLACE_OF_BAPTISM,"
							+ "DATE_OF_CONFIRMATION,"
							+ "PLACE_OF_REGENCY,"
							+ "FATHER_NAME,"
							+ "MOTHER_NAME,"
							+ "PARENTS_LIVING,"
							+ "BROTHERS,"
							+ "SISTERS,"
							+ "OCCUPATION_OF_PARENTS,"
							+ "PARENTS_ADDRESS,"
							+ "SECULAR_STUDIES,"
							+ "MINOR_SEMINARY,"
							+ "MAJOR_SEMINARY,"
							+ "CERTIFICATE_OF_PHILOSOPY,"
							+ "SPIRITUAL_YEAR_FINAL_ASSESSMENT,"
							+ "BAPTISM_AND_CONFIRMATION,"
							+ "DEGREE_CERTIFICATE,"
							+ "FINAL_REPORT_FROM_MAJOR_SEMINARY,"
							+ "REGENCY_RFEPORT,"
							+ "PASSPORT_SIZE_PHOTO,"
							+ "MARRIAGE_CERTIFICATE_OF_PARENTS)"
							+ "VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getType());
			preparedStatement.setDate(3, getSqlDate(student.getDateOfBirth()));
			preparedStatement.setString(4, student.getPlaceOfBirth());
			preparedStatement.setDate(5, getSqlDate(student.getDateOfBaptism()));
			preparedStatement.setString(6, student.getPlaceOfBaptism());
			preparedStatement.setDate(7, getSqlDate(student.getDateOfConfirmation()));
			preparedStatement.setString(8, student.getPlaceOfRegency());
			preparedStatement.setString(9, student.getFatherName());
			preparedStatement.setString(10, student.getMotherName());
			preparedStatement.setString(11, student.getParentsLiving());
			preparedStatement.setInt(12, student.getBrothers());
			preparedStatement.setInt(13, student.getSisters());
			preparedStatement.setString(14, student.getOccupationOfParents());
			preparedStatement.setString(15, student.getParentsAddress());		
			preparedStatement.setString(16, student.getSecularStudies());
			preparedStatement.setString(17, student.getMinorSeminary());
			preparedStatement.setString(18, student.getMajorSeminary());
			preparedStatement.setBoolean(19, student.getCertificateOfPhilosopy());
			preparedStatement.setBoolean(20, student.getSpiritualYearFinalAssessment());
			preparedStatement.setBoolean(21, student.getBaptismAndConfirmation());
			preparedStatement.setBoolean(22, student.getDegreeCertificate());
			preparedStatement.setBoolean(23, student.getFinalReportFromMajorSeminary());
			preparedStatement.setBoolean(24, student.getRegencyRfeport());
			preparedStatement.setBoolean(25, student.getPassportSizePhoto());
			preparedStatement.setBoolean(26, student.getMarriageCertificateOfParents());
			
			value = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (value == 1) {
			
			return true;
		} else {
			return false;
		}
	
	}
	
	Date getSqlDate(java.util.Date date) {
		
		return new java.sql.Date(date.getTime());
	} 
	
	public List<Student> getStudents() {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			


			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ssm?user=ssmuser&password=ssmpw");

//			statement = connect.createStatement();
//			resultSet = statement.executeQuery("select * from user");
			/*preparedStatement = connect
					.prepareStatement("select "
							+ "ID,"
							+ "NAME,"
							+ "TYPE,"
							+ "DATE_OF_BIRTH,"
							+ "PLACE_OF_BIRTH,"
							+ "DATE_OF_BAPTISM,"
							+ "PLACE_OF_BAPTISM,"
							+ "DATE_OF_CONFIRMATION,"
							+ "PLACE_OF_REGENCY,"
							+ "FATHER_NAME,"
							+ "MOTHER_NAME,"
							+ "PARENTS_LIVING,"
							+ "BROTHERS,"
							+ "SISTERS,"
							+ "OCCUPATION_OF_PARENTS,"
							+ "PARENTS_ADDRESS,"
							+ "SECULAR_STUDIES,"
							+ "MINOR_SEMINARY,"
							+ "MAJOR_SEMINARY,"
							+ "CERTIFICATE_OF_PHILOSOPY,"
							+ "SPIRITUAL_YEAR_FINAL_ASSESSMENT,"
							+ "BAPTISM_AND_CONFIRMATION,"
							+ "DEGREE_CERTIFICATE,"
							+ "FINAL_REPORT_FROM_MAJOR_SEMINARY,"
							+ "REGENCY_RFEPORT,"
							+ "PASSPORT_SIZE_PHOTO,"
							+ "MARRIAGE_CERTIFICATE_OF_PARENTS"
							+ " FROM STUDENT_INFO");*/
			
			preparedStatement = connect
					.prepareStatement("select * from student_info");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setType(resultSet.getString(3));
				student.setDateOfBirth(resultSet.getDate(4));
				student.setPlaceOfBirth(resultSet.getString(5));
				student.setDateOfBaptism(resultSet.getDate(6));
				student.setPlaceOfBaptism(resultSet.getString(7));
				student.setDateOfConfirmation(resultSet.getDate(8));
				student.setPlaceOfRegency(resultSet.getString(9));
				student.setParentsNmae(resultSet.getString(10));
				student.setParentsLiving(resultSet.getString(12));
				student.setBrothers(resultSet.getInt(13));
				student.setSisters(resultSet.getInt(14));
				student.setOccupationOfParents(resultSet.getString(15));
				student.setParentsAddress(resultSet.getString(16));
				student.setSecularStudies(resultSet.getString(17));
				student.setMinorSeminary(resultSet.getString(18));
				student.setMajorSeminary(resultSet.getString(19));
				student.setCertificateOfPhilosopy(resultSet.getBoolean(20));
				student.setSpiritualYearFinalAssessment(resultSet.getBoolean(21));
				student.setBaptismAndConfirmation(resultSet.getBoolean(22));
				student.setDegreeCertificate(resultSet.getBoolean(23));
				student.setFinalReportFromMajorSeminary(resultSet.getBoolean(24));
				student.setRegencyRfeport(resultSet.getBoolean(25));
				student.setPassportSizePhoto(resultSet.getBoolean(26));
				student.setMarriageCertificateOfParents(resultSet.getBoolean(27));
				students.add(student);
			    }
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}

}
