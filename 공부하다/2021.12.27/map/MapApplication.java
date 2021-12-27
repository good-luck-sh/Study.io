package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.controller.SampleMapController;

public class MapApplication {

	public static void main(String[] args) {
		
		String resource = "classpath:/spring/context-map-injection.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		SampleMapController controller = ctx.getBean(SampleMapController.class);
		controller.execute("email", "admin@gamil.com", "kim@naver.com", "제목테스트", "테스트");
		controller.execute("sms", "010-1111-1111", "kim@naver.com", "제목테스트", "테스트");
	}
}
