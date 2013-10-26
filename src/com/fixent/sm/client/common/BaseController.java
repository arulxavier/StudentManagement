package com.fixent.sm.client.common;

import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class BaseController {
	
	public static Map<String, Object> OBJECT_MAP = new HashMap<String, Object>();
	
	public static void push(String key, Object value)
	{
		OBJECT_MAP.put(key, value);
	}

	public static Object pop(String key)
	{
		return OBJECT_MAP.remove(key);
	}
	
	public void setErrorMessages(Container jPanel, String message) {
		
		RightSidePanel rightSidePanel = (RightSidePanel) jPanel;
		JViewport jViewport = (JViewport)rightSidePanel.getParent();
		JScrollPane jScrollPane = (JScrollPane) jViewport.getParent();
		BaseLayout baseLayout = (BaseLayout) jScrollPane.getParent();
		
		for (Component component : baseLayout.getComponents()) {
			
			if (component instanceof FooterPanel) {
				
				FooterPanel footerPanel = (FooterPanel)component;
				footerPanel.footerView.getErrorLabel().setText(message);
			}
		}
				
	}
}
