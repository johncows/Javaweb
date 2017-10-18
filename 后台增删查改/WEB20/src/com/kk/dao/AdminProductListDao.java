package com.kk.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kk.domain.Product;
import com.kk.utils.DatasourceUtil;
import com.kk.utils.MyDateSourceUtil;

public class AdminProductListDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "select * from product";
		List<Product> ls =qr.query(sql,new BeanListHandler<Product>(Product.class));
		return ls;
	}

	public int addProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "insert into product Values(?,?,?,?,?,?,?,?,?,?)";
		return qr.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
				product.getPdesc(),product.getPflag(),product.getCid());
	}

	public int delProduct(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "delete from product where pid = ? ";
		return qr.update(sql,pid);
		
	}
	
	
	public Product findProduct(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "select * from product where pid = ?";
		Product pro =qr.query(sql,new BeanHandler<Product>(Product.class),pid);
		return pro;
	}

}
