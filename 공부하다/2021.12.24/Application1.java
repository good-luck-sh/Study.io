package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.controller.UserController;
import com.sample.service.UserService;

public class Application1 {

	public static void main(String[] args) {
		
		//스프링 빈 설정파일의 경로 
		String resource = "classpath:/spring/context-1.xml";
		//2.객체파일
		//내가 포함시키는 라이브러리중에 이 파일을 찾겠다는 의미 classpath:/
		
		//스프링 컨테이너 객체 생성하기 
		/*
		 * ApplicationContext
		 * 		+ 인터페이스다.
		 * 		+ 스프링 컨테이너 객체가 반드시 구현할 기능을 정의하고 있다.
		 * ClasspathXmlApplicationContext
		 * 		+ 클래스다. 
		 * 		+ ApplicationContext 인터페이스를 구현한 클래스다.
		 * 		+ 지정된 리소스(스프린 빈 설정 파일)을 읽어서 객체 생성/조립/보관을 수행한다.
		 * 		+ 스프링 컨테이너는 특별한 설정이 없는 한 모든 객체를 싱글턴 상태로 유지한다.
		 * Loaded 2 bean definitions from class path resource [spring/context-1.xml]
		 * 이파일을 읽어서 
		 * Creating shared instance of singleton bean 'userServiceImpl','userController' 싱글턴형태의 객체를 만들었다. 
		 * 필요할 때 객체를 꺼내서 사용한다. 웹으로 가면 꺼내는 동작은 직접 구현하지 않아도 된다. 
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		//1. 스프링컨테이너가 
		//3. context-1.xml에서 지정된 id로 객체를 관리하고 있는 것이다.
		//스프링 컨테이너가 생성/조립/보관중인 객체 가져오기 
		/*
		 * object getBean(String id)
		 * 		+ 지정된 아이디로 생성해서 보관중인 객체를 반환한다.
		 * 		+ 반환타입이 Object이기 때문에 반드시 적절한 타입으로 형변환해야 한다.
		 * 
		 * T getBean(String id, Class<T> class)
		 * 		+ 지정된 아이디와 클래스 타입으로 객체를 가져온다.
		 * 		+ 클래스타입을 지정했기 때문에 형변환이 필요없다.
		 */
		 UserController controller = ctx.getBean("userController",UserController.class);
		 UserService service = ctx.getBean("userServiceImpl",UserService.class);	
		 //userService는 굳이 가져올 필요가 없다. userController에 service가 연결되어 있기 때문에 
		 
		 //부모타입은 자식타입을 담을 수 있고, 인터페이스로 갖고 노는 걸 좋아한다.
		 //System.out.println(controller);
		 //System.out.println(service);
		 
		 String viewPage = controller.execute(100);
		 
	}
}
