package com.kk.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kk.domain.Category;
import com.kk.domain.Product;
import com.kk.utils.DatasourceUtil;

public class AdminCategoryDao {
	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "select * from category";
		List<Category> ls =qr.query(sql,new BeanListHandler<Category>(Category.class));
		return ls;
	}
}
