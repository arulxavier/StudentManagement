package com.fixent.sm.server.service.impl;

import com.fixent.sm.server.dao.UserDAO;
import com.fixent.sm.server.model.User;
import com.fixent.sm.server.service.UserService;

public class UserServiceImpl 
implements UserService{

	
	public Boolean login(User user) {
		
		UserDAO dao = new UserDAO();
		boolean status = dao.login(user);
		return status;
	}

}
