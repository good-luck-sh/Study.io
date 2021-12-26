package com.sample.vo;

public class User {

	private int no;
	private String name;
	private String email;
	private String password;
	
	public User() {}
	
	public User(int no, String name, String email, String password) {
		this.no = no;
		this.name = name;
		this.email= email;
		this.password = password;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
