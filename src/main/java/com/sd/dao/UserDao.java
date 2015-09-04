package com.sd.dao;

import com.sd.pojo.User;

public interface UserDao {

	public User getUser(int id);
	public boolean insertUser(User user);
}
