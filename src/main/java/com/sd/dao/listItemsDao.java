package com.sd.dao;

import com.sd.pojo.Listitems;

public interface listItemsDao {

	public Listitems getList(int id);
	public boolean insertList(Listitems list);
}
