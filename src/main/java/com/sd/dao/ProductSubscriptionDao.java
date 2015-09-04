package com.sd.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.sd.pojo.Product_subscriptions;

public interface ProductSubscriptionDao {

	public boolean addSubscription(Product_subscriptions prodSub) throws ParseException;
	public ArrayList<Product_subscriptions> getSubscription(int id);
	public boolean editSubscription(Product_subscriptions prodSub);
	//public boolean updateDateSubscription(Product_subscriptions prodSub);
	public boolean deleteSubscription(int id);
	
	
}