package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sample.controller.ProductController;
import com.sample.service.ProductService;

public class Application2 {

	public static void main(String[] args) {
		
		//스프링 빈 설정 파일의 경로
		String resource = "classpath:/spring/context-2.xml";
		
		//스프링 컨테이너(ClassPathXmlApplicaionContext) 객체 생성 -> 스피링 빈 설정파일 로딩, 클래스 스캔해서 객체생성하고, 스프링 컨테이너에 보관, 객체 조립 수행
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		//System.out.println(ctx);
		//internalConfigurationAnnotationProcessor
		//internalEventListenerProcessor
		//internalEventListenerFactory
		//internalAutowiredAnnotationProcessor
		//internalCommonAnnotationProcessor
		//internalPersistenceAnnotationProcessor
		///6가지의 bean이 생성된다. 
		//@Component을 설정하고 productController,productServiceImpl 2개가 더 추가된다. 
		//springController가 실행되서 객체를 생성해서 추가된 것을 알 수 있다.
		
		ProductService service = ctx.getBean(ProductService.class);
		ProductController controller = ctx.getBean(ProductController.class);
		
		System.out.println(service);
		System.out.println(controller);
		
		controller.execute(100);
	}
	
}
