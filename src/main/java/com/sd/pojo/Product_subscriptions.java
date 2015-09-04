package com.sd.pojo;


public class Product_subscriptions {

	private int id;
	private int uid;
	private int pid;
	private int duration;
	private String last_delivery_date;
	private String next_delivery_date;
	private String subscription_date;
	private int quantity;
	
	public String getNext_delivery_date() {
		return next_delivery_date;
	}

	public void setNext_delivery_date(String next_delivery_date) {
		this.next_delivery_date = next_delivery_date;
	}

	public String getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(String subscription_date) {
		this.subscription_date = subscription_date;
	}

	
	public String getLast_delivery_date() {
		return last_delivery_date;
	}

	public void setLast_delivery_date(String last_delivery_date) {
		this.last_delivery_date = last_delivery_date;
	}



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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int interval) {
		this.duration = interval;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}