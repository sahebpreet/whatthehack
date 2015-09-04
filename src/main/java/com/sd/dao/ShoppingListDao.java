package com.sd.dao;

import java.util.ArrayList;

import com.sd.pojo.Shoppinglist;

public interface ShoppingListDao {

	public int addList(Shoppinglist list);
	public ArrayList<Shoppinglist> getLists();
	public Shoppinglist getList(int id);
	public int deleteList(int id);
	
}
