package com.sample.controller;

import java.util.Set;

import org.apache.ibatis.javassist.expr.Instanceof;

import com.sample.service.EmailMessageServiceImpl;
import com.sample.service.MessageService;
import com.sample.service.SmsMessageServiceImpl;

public class SampleCollectionController {

	/*
	 * 이전까지는 객체를 1개를 입력받았다. 이제는 객체 한개가 아니라 여럿을 입력 받을 예정이다. 
	 * 스프링 컨테이너가 생성한 객체를 Collection(배열, Set, List)에 저장된 형태로 주입받도록 멤버변수를 정의함
	 */
	private Set<MessageService> messageServices;
	
	public void setMessageServices(Set<MessageService> messageServices) {
		this.messageServices = messageServices;
	}
	
	public void execute() {
		for(MessageService service : messageServices) {
			if(service instanceof EmailMessageServiceImpl) {
				service.send("admin@gamil.com", "hong@gmail", "이벤트 알림", "연말 할인 이벤트를 실시합니다.");
			} else if(service instanceof SmsMessageServiceImpl) {
				service.send("02-1234-1324", "010-1111-1111", "이벤트 알림", "연말 할인 이벤트를 실시합니다.");

			}
		}
	}
}
