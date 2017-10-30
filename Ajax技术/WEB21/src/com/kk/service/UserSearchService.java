package com.kk.service;

import java.sql.SQLException;

import com.kk.dao.UserSerachDao;

public class UserSearchService {

	public boolean serachName(String name) throws SQLException {
		UserSerachDao dao = new UserSerachDao();
		boolean status = dao.SerachforName(name);
		return status;
	}
	
}
