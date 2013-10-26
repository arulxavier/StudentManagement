package com.fixent.sm.server.service.impl;

import java.util.List;

import com.fixent.sm.server.dao.ConfigurationDAO;
import com.fixent.sm.server.model.Configuration;
import com.fixent.sm.server.model.Congregation;
import com.fixent.sm.server.model.Diocese;
import com.fixent.sm.server.service.ConfigurationService;

public class ConfigurationServiceImpl 
implements ConfigurationService {

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
			diocese.setId(maxId+1);
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
			congregation.setId(maxId+1);
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

	
}
