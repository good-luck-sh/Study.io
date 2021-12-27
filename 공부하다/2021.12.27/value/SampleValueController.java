package com.sample.controller;

public class SampleValueController {

	private String host;
	private int port;
	private String username;
	private String password;
	//이 값들을 전달받고 싶다.
	public void setHost(String host) {
		this.host = host;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void execute() {
		System.out.println("서버 연결정보");
		System.out.println("호스트 명 :" + host);
		System.out.println("포트 번호 :" + port);
		System.out.println("사용자 명 :" + username);
		System.out.println("비밀 번호 :" + password);
	}
}
