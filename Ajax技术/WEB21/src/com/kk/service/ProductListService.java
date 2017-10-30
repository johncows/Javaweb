package com.kk.service;

import java.sql.SQLException;
import java.util.List;

import com.kk.dao.AdminProductListDao;
import com.kk.domain.Product;
import com.kk.vo.PageBean;

public class ProductListService {

	public PageBean findPageBean(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
		AdminProductListDao adl = new AdminProductListDao();
		PageBean pageBean = new PageBean();
		int totalCount = adl.totalCount();
		int currentCount  = 12;
		int totalPage;
	
		
		if(totalCount%currentCount==0) {
			totalPage = totalCount/currentCount;
		}else
		{
			totalPage = totalCount/currentCount;
			totalPage +=1;
		}
		
		
		
		 
		pageBean.setCurrentCount(currentCount);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		
		int index = (currentPage-1)*currentCount;
		List<Product> findProductListForPageBean = adl.findProductListForPageBean(index, currentCount);
		pageBean.setProductList(findProductListForPageBean);
		
		return pageBean;
		
	}

}
