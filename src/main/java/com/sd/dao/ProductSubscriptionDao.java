package com.sd.dao;

import java.util.ArrayList;

import com.sd.pojo.Product_subscriptions;

public interface ProductSubscriptionDao {

	public boolean addSubscription(Product_subscriptions prodSub);
	public ArrayList<Product_subscriptions> getSubscription(int id);
	public boolean edittSubscription(Product_subscriptions prodSub);
	public boolean updateDateSubscription(Product_subscriptions prodSub);
	public boolean deteleSubscription(int id);
	
	
}
