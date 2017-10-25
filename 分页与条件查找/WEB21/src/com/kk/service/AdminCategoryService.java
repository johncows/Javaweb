package com.kk.service;

import java.sql.SQLException;
import java.util.List;

import com.kk.dao.AdminCategoryDao;
import com.kk.domain.Category;

public class AdminCategoryService {
	public List<Category> findAllCategory() throws SQLException{
		AdminCategoryDao adc = new AdminCategoryDao();
		List<Category> findAllCategory=null;
		findAllCategory = adc.findAllCategory();
		return findAllCategory;
	}
}
