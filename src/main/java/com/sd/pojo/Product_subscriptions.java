package com.sd.pojo;

import java.util.Date;

public class Product_subscriptions {

	private int id;
	private int uid;
	private int pid;
	private int interval;
	private Date last_delivery_date;
	private Date subscription_date;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public Date getLast_delivery_date() {
		return last_delivery_date;
	}

	public void setLast_delivery_date(Date last_delivery_date) {
		this.last_delivery_date = last_delivery_date;
	}

	public Date getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(Date subscription_date) {
		this.subscription_date = subscription_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
