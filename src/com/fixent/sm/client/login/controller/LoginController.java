package com.fixent.sm.client.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fixent.sm.client.common.BaseFrame;
import com.fixent.sm.client.login.view.LoginView;
import com.fixent.sm.client.login.view.LoginWindow;
import com.fixent.sm.server.model.User;
import com.fixent.sm.server.service.impl.UserServiceImpl;

public class LoginController {

	LoginView loginView;

	LoginAction loginAction;

	public LoginController() {

		loginView = new LoginView();
		loginAction = new LoginAction();
		subscribe();
	}

	private void subscribe() {

		loginView.getLoginButton().addActionListener(loginAction);

	}

	public LoginView getView() {

		if (loginView == null) {
			loginView = new LoginView();
		}
		//loginView.getUserNameTextField().setText("admin");
		//loginView.getPasswordField().setText("admin");
		return loginView;
	}

	class LoginAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			User user = new User();
			user.setUserName(loginView.getUserNameTextField().getText());
			user.setPassword(loginView.getPasswordField().getText());
			UserServiceImpl userServiceImpl = new UserServiceImpl();
			Boolean status = userServiceImpl.login(user);

			if (status) {

				LoginWindow loginWindow = ((LoginWindow) loginView
						.getRootPane().getParent());
				loginWindow.dispose();
				new BaseFrame(user);
			} else {
				loginView.getErrorLable().setText(
						"Invalid UserName or Password");
				loginView.getUserNameTextField().setText("");
				loginView.getPasswordField().setText("");
			}
		}

	}

}
