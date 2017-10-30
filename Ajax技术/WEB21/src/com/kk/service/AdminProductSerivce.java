package com.kk.service;

import java.sql.SQLException;
import java.util.List;

import com.kk.dao.AdminProductListDao;
import com.kk.domain.Product;
import com.kk.vo.Condition;

public class AdminProductSerivce {

	public  List<Product> findAllProduct() throws SQLException {
		AdminProductListDao apo = new AdminProductListDao();
		List<Product> li = apo.findAllProduct();
		return li;
	}
	
	
	public int addProduct(Product pro) throws SQLException {
		AdminProductListDao apo = new AdminProductListDao();
		return apo.addProduct(pro);
	}


	public int delProduct(String pid) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductListDao apl = new AdminProductListDao();
		return apl.delProduct(pid);
		
	}


	public Product findProduct(String pid) throws SQLException {
		
		return new AdminProductListDao().findProduct(pid);
	}


	public List<Product> findProductListByCondition(Condition con) throws SQLException {
		AdminProductListDao apl = new AdminProductListDao();
		return apl.findProductListByCondition(con);
		
	}

}
