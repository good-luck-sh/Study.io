package com.sample.service;

public class EmailMessageServiceImpl implements MessageService {
	
	@Override
	public void send(String from, String to, String title, String message) {
		System.out.println("전자우편 메세지 전송...");
		System.out.println("발신자 메일주소 : " + from);
		System.out.println("수신자 메일주소 : " + to);
		System.out.println("메세지 제   목 : " + title);
		System.out.println("메세지 내   용 : " + message);
		
		
	}
}
