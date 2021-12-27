package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.controller.SampleConstructorController;

public class ConstructorApplication2 {
	public static void main(String[] args) {
		 
		String resource = "classpath:/spring/context-constructor-injection-2.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		SampleConstructorController controller = ctx.getBean(SampleConstructorController.class);
		controller.execute();
	}
}
