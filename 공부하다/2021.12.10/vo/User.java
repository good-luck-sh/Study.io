package kr.co.jhta.vo;

import java.util.Date;

public class User {

	private String id;
	private String password;
	private String name;
	private Date createdDate;
	
	public User() {}

	public User(String id, String password, String name, Date createdDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
