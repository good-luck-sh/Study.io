package com.sample.controller;

import java.util.Map;

import com.sample.service.MessageService;

public class SampleMapController {
	
	/*
	 * MessageService인터페이스의 구현객체가 key, value쌍으로 저장되는 Map객체를 스프링 컨테이너로부터 주입받는다. 
	 * Map 객체에는 
	 * 	{"sms": SmsMessageServiceImpl, "email" : EmailMessageServiceImpl}과 유사한 형태로 MessageService인터페이스의 
	 * 	구현객체들이 저장되어 있다.
	 * 	Map객체에서 필요한 객체를 꺼내기 위해서는 "sms" 혹은 "email" 과 같은 key값이 필요하다.
	 *  아래의 execute(type,from,to,title,message)에서 type매개변수로 "sms" 혹은 "email"중에서 하나로 전달받는다.
	 *  
	 *  set이나 list로 담아오면 if else if로 instanceOf로 형변환 확인하고, 출력하기 때문에 Map으로 담아오는 편이 더 낫다.
	 */
	private Map<String, MessageService> messageService;
	
	public void setMessageService(Map<String, MessageService> messageService) {
		this.messageService = messageService;
	}
	public void execute(String type, String from, String to, String title, String message) {
		MessageService service = messageService.get(type);
		service.send(from, to, title, message);
	}
}
