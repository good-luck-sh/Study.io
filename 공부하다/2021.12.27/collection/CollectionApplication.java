package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.controller.SampleCollectionController;
import com.sample.controller.SampleConstructorController;

public class CollectionApplication {

	public static void main(String[] args) {
		 
			String resource = "classpath:/spring/context-collection-injection.xml";
			ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
			
			SampleCollectionController controller = ctx.getBean(SampleCollectionController.class);
			controller.execute();
	}
}
