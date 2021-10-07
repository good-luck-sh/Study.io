package example_10_07_01_Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapSample3 {
	//Map을 사용하지 않는 경우 
	public static void main(String[] args) {
		System.out.println("### EventService1에서 Map을 사용하지 않은 경우 ");
		EventService1 service1 = new EventService1();
		service1.sendEventMessage("가을 신상품 할인 행사 진행!!" ,"SMS");
		service1.sendEventMessage("카톨 채널 가입시 할인쿠폰 지급!!","KAKAOTALK");
		
		//Map을 사용한 경우 
		System.out.println("### EventService2에서 Map을 사용하지 않은 경우 ");
		EventService2 service2 = new EventService2();
		service2.sendEventMessage("가을 신상품 할인 행사 진행!!" ,"SMS");
		service2.sendEventMessage("카톨 채널 가입시 할인쿠폰 지급!!","KAKAOTALK");
		
	}
	
	static class EventService1 {
		
		SmsSender sms = new SmsSender();
		KaKaTalkSender kakao = new KaKaTalkSender();
		
		//senderType에 따라서 메세지를 전송하는 적절한 Sender를 고르는 if ~ else if 문이 필요하다.
		public void sendEventMessage(String message, String senderType) {
			if("SMS".equals(senderType)) {//"상수의 값을"먼저 적어주어야한다. 
				sms.sendMessage(message);
			} else if ("KAKAOTALK".equals(senderType)){
				kakao.sendMessage(message);
			}
		}
	}
	static class EventService2 {
		//각종 Sender구현객체를 각각, SMS와 KAKAOTALK을 키로 SmsSender와 kakaotalkSender를 Map에 저장한다.
		//key값으로 사용할 Sender메세지를 고를 수 있다. 
		Map<String, Sender> senderMap = new HashMap<>();
		
		//맵을 이용해서 담으려고 함
		public EventService2() {
			senderMap.put("SMS", new SmsSender());
			//"SMS"key로 smsSender메소드가 실행되고
			senderMap.put("KAKAOTALK",new KaKaTalkSender());
			//"KAKAOTALK"key로 Kakaotalk의 메소드가 실행된다. 
		}
		public void sendEventMessage(String message, String senderType) {
			Sender sender = senderMap.get(senderType); //꺼낼때 사용하는 메소드
			sender.sendMessage(message);
		}
	}
	static interface Sender{
		void sendMessage(String message);
	}
	static class SmsSender implements Sender{
		@Override
		public void sendMessage(String message) {
			System.out.println("[SMS 메세지 발송]" + message);
		}
	}
	static class KaKaTalkSender implements Sender{
		@Override
		public void sendMessage(String message) {
			System.out.println("[카카오톡 메세지 발송]" + message);
		}
	}

}
