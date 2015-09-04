package com.sd.dao;

import java.util.List;

import com.sd.pojo.Listitems;
import com.sd.pojo.Product;
import com.sd.pojo.Shoppinglist;

public interface listItemsDao {

	public List<Product> getListItems(Shoppinglist list);
	public void addItem(Shoppinglist list, Product product);
	public void deleteItem(Shoppinglist list, Product product);

}
