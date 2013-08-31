package com.fixent.sm.client.common;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	
	Map<String, String> rootMenu = new HashMap<String, String>();
	Map<String, Map<String, String>> subMenuMap = new HashMap<String, Map<String,String>>();
	Map<String, String> masterSubMenu = new HashMap<String, String>();
	Map<String, String> studentSubMenu = new HashMap<String, String>();
	
	public Menu() {
		
		rootMenu.put("1", "Master");
		rootMenu.put("2", "Student");

		masterSubMenu.put("1", "College Details");

		studentSubMenu.put("1", "Master");
		studentSubMenu.put("2", "Student");
		
		subMenuMap.put("Master", masterSubMenu);
		subMenuMap.put("Student", studentSubMenu);
		
	}

	public Map<String, String> getRootMenu() {
		return rootMenu;
	}

	public void setRootMenu(Map<String, String> rootMenu) {
		this.rootMenu = rootMenu;
	}

	public Map<String, Map<String, String>> getSubMenuMap() {
		return subMenuMap;
	}

	public void setSubMenuMap(Map<String, Map<String, String>> subMenuMap) {
		this.subMenuMap = subMenuMap;
	}

	
	

}
