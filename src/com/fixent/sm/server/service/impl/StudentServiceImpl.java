package com.fixent.sm.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fixent.sm.server.dao.StudentDAO;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.Ministry;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.info.ChangeYearInfo;
import com.fixent.sm.server.model.info.StudentInfo;
import com.fixent.sm.server.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public boolean createStudent(Student student) {

		boolean status = false;

		try {

			StudentDAO dao = new StudentDAO();
			int id = dao.getMaxId();
			/*int regNo = dao.getRegNo();
			student.setRegNo(regNo + 1);*/
			student.setId(id + 1);
			status = dao.createStudent(student);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public boolean createMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Student> getStudents() {

		List<Student> students = null;

		try {

			StudentDAO dao = new StudentDAO();
			students = dao.getStudents();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public List<Student> searchStudent(StudentInfo studentInfo) {

		List<Student> students = new ArrayList<Student>();

		try {

			StudentDAO dao = new StudentDAO();
			students = dao.searchStudent(studentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}

	public boolean modifyStudent(Student student) {

		boolean status = false;
		try {

			StudentDAO dao = new StudentDAO();
			status = dao.modifyStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean changeYear(ChangeYearInfo info) {

		boolean status = false;
		try {

			StudentDAO dao = new StudentDAO();
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setYear(info.getFromYear());
			studentInfo.setYearType(info.getFromType());
			List<Student> students = searchStudent(studentInfo);

			ConfigurationServiceImpl configurationServiceImpl = new ConfigurationServiceImpl();
			Batch batch = configurationServiceImpl.getBatch(info.getToYear(),
					info.getToType());

			if (students != null && !students.isEmpty()) {
				List<Integer> studentIds = new ArrayList<Integer>();
				for (Student student : students) {
					studentIds.add(student.getId());
				}
				status = dao.changeYear(studentIds, batch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
