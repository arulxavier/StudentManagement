package com.fixent.sm.client.login.view;

import javax.swing.JDialog;

import com.fixent.sm.client.login.controller.LoginController;

public class LoginWindow 
extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public LoginWindow() {
		
		add(new LoginController().getView());
		setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}	
}
