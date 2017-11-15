package com.kk.service;

import java.sql.SQLException;

import com.kk.dao.UserDao;
import com.kk.domain.User;

public class UserService {

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}

}
