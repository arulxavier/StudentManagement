package com.fixent.sm.client.common;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class FooterPanel 
extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FooterPanel() {
		
		setLayout(new BorderLayout());
		add(new FooterView());
	}

}
