package com.sample.service;

public class SmsMessageServiceImpl implements MessageService {

	@Override
	public void send(String from, String to, String title, String message) {
		System.out.println("SMS 메세지 전송...");
		System.out.println("발신자 전화번호 : " + from);
		System.out.println("수신자 전화번호 : " + to);
		System.out.println("메세지 제   목 : " + title);
		System.out.println("메세지 내   용 : " + message);
		
	}

}
