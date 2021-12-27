package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.controller.SampleValueController;

public class ValueApplication {

	public static void main(String[] args) {
		String resource = "classpath:/spring/context-value-injection.xml";
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		SampleValueController controller = ctx.getBean(SampleValueController.class);
		controller.execute();
	}
}
