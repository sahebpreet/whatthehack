package com.sd.dao;

import com.sd.pojo.Product;

public interface ProductDao {

	public Product getProduct(int id);
	public boolean insertProduct(Product product);
	
}
