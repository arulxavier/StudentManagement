package com.fixent.sm.server.service.impl;

import java.util.List;

import com.fixent.sm.server.dao.ConfigurationDAO;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.model.Configuration;
import com.fixent.sm.server.model.Congregation;
import com.fixent.sm.server.model.Diocese;
import com.fixent.sm.server.model.Student;
import com.fixent.sm.server.model.info.StudentInfo;
import com.fixent.sm.server.service.ConfigurationService;

public class ConfigurationServiceImpl implements ConfigurationService {

	@Override
	public boolean createConfiguration(Configuration configuration) {

		boolean status = false;

		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			status = dao.createConfiguration(configuration);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Congregation> getCongregations() {

		List<Congregation> congregations = null;

		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			congregations = dao.getCongregations();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return congregations;
	}

	public List<Diocese> getDioceses() {

		List<Diocese> dioceses = null;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			dioceses = dao.getDioceses();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dioceses;
	}

	public boolean createDioceses(Diocese diocese) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			int maxId = dao.getDiocesesMaxId();
			diocese.setId(maxId + 1);
			status = dao.createDiocese(diocese);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean createCongregation(Congregation congregation) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			int maxId = dao.getCongregationMaxId();
			congregation.setId(maxId + 1);
			status = dao.createCongregation(congregation);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteDiocese(int id) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			status = dao.deleteDiocese(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteCongregation(int id) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			status = dao.deleteCongregation(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean modifyDiocese(Diocese diocese) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			status = dao.modifyDiocese(diocese);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean modifyCongregation(Congregation congregation) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			status = dao.modifyCongregation(congregation);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Batch> getAllBatchs() {

		List<Batch> batchs = null;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			batchs = dao.getBatchs();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return batchs;
	}

	public Batch getBatch(int year, String type) {

		Batch batch = null;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			batch = dao.getBatch(year, type);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return batch;
	}

	public boolean deleteBatch(int id) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			Batch batch = dao.getBatch(id);
			StudentServiceImpl serviceImpl = new StudentServiceImpl();
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setYear(batch.getYear());
			studentInfo.setYearType(batch.getType());
			List<Student> students = serviceImpl.searchStudent(studentInfo);
			if (students != null && !students.isEmpty()) {
				status = false;
			} else {
				status = dao.deletebatch(batch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean modifyBatch(Batch batch) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			status = dao.modifybatch(batch);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean createBatch(Batch batch) {

		boolean status = false;
		try {

			ConfigurationDAO dao = new ConfigurationDAO();
			int maxId = dao.getBatchMaxId();
			batch.setId(maxId + 1);
			status = dao.createbatch(batch);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
