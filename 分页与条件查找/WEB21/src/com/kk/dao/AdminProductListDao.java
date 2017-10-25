package com.kk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kk.domain.Product;
import com.kk.utils.DatasourceUtil;
import com.kk.utils.MyDateSourceUtil;
import com.kk.vo.Condition;

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

	public List<Product> findProductListByCondition(Condition con) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		StringBuilder sb = new StringBuilder("select * from product where 1=1 ");
		List<String> ls = new ArrayList<String>();
 		
		
		if(con.getPname()!=null && !con.getPname().trim().equals("")) {
			sb.append(" and pname like ?");
			ls.add("%"+con.getPname()+"%");
		}
		
		if(con.getCid()!=null && !con.getCid().trim().equals("")) {
			sb.append(" and cid =  ?");
			ls.add(con.getCid());
		}
		
		if(con.getIsHot()!=null && !con.getIsHot().trim().equals("")) {
			sb.append(" and is_hot = ?");
			ls.add(con.getIsHot());
		}
		
		
		List<Product> query = qr.query(sb.toString(), new BeanListHandler<Product>(Product.class),ls.toArray());
		return query;
	}

	
	
	
	public int totalCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "Select count(*) from product";
		Long totalCount = (Long)qr.query(sql, new ScalarHandler());
		return totalCount.intValue();
	}
	
	public List<Product> findProductListForPageBean(int index,int currentCount) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasourceUtil.getDataSource());
		String sql = "Select * from product limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class),index,currentCount);
		
	}
}
