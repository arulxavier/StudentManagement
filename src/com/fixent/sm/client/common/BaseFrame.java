package com.fixent.sm.client.common;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.fixent.sm.server.model.User;

public class BaseFrame 
extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseFrame(User user) {
		
		User user2 = user;
		
		setName("BaseFrame");
		setBounds(250, 50, 960, 650);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		add(new BasePane(), BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}

}
