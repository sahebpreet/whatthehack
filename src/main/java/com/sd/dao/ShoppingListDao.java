package com.sd.dao;

import java.util.ArrayList;

import com.sd.pojo.Shoppinglist;

public interface ShoppingListDao {

	public boolean addList(Shoppinglist list);
	public ArrayList<Shoppinglist> getList(int id);
	public boolean deleteList(int id);
	
}
