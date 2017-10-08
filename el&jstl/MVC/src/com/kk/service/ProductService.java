package com.kk.service;

import java.util.List;

import com.kk.dao.ProductDao;
import com.kk.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() {
		ProductDao dao = new ProductDao();
		List<Product> productList = dao.findAllProduct();
		return productList;
	}
	
}
