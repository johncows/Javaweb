package com.kk.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kk.domain.Product;
import com.kk.utils.DatasourceUtil;

public class ProductDao {

	public List<Product> findAllProduct() {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "select * from product";
		List<Product> bl =null;
		
		try {
			bl = qr.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bl;
	}

}
