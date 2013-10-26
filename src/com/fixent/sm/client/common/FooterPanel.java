package com.fixent.sm.client.common;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class FooterPanel 
extends JPanel {
	
	FooterView footerView;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FooterPanel() {
		
		footerView = new FooterView();
		
		setLayout(new BorderLayout());
		add(footerView);
	}

}
