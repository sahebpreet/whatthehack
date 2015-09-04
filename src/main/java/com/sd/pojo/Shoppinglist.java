package com.sd.pojo;

import java.util.Date;

public class Shoppinglist {

	private int id;
	private String name;
	private String createddate;
	private int uid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Shoppinglist [id=" + id + ", name=" + name + ", createddate=" + createddate + ", uid=" + uid + "]";
	}

}
