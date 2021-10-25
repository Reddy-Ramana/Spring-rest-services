package com.ramana.pojo;

import java.util.Date;

public class Posts {

	private int id;

	private Date createdDate;
	private String Name;

	public Posts(int id, Date createdDate, String name) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.Name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getName() {
		return Name;
	}

}
