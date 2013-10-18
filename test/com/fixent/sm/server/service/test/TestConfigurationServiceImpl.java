package com.fixent.sm.server.service.test;

import com.fixent.sm.server.model.Configuration;
import com.fixent.sm.server.service.impl.ConfigurationServiceImpl;

public class TestConfigurationServiceImpl {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.setType("gender");
		configuration.setSubType("Female");
		configuration.setStatus(true);
		
		
		
		ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
		impl.createConfiguration(configuration);
		
	}

}
