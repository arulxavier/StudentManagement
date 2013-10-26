package com.fixent.sm.client.common;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.fixent.sm.server.model.User;

public class BaseFrame 
extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseFrame(User user) {

		UIManager
				.put("ComboBox.background",
						new ColorUIResource(UIManager
								.getColor("TextField.background")));
		UIManager
				.put("ComboBox.foreground",
						new ColorUIResource(UIManager
								.getColor("TextField.foreground")));
		UIManager.put("ComboBox.selectionBackground", new ColorUIResource(
				Color.LIGHT_GRAY));
		UIManager.put("ComboBox.selectionForeground", new ColorUIResource(
				Color.WHITE));
		setName("BaseFrame");
		// setBounds(250, 50, 960, 650);
		setSize(1000, 650);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		add(new BasePane(), BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
