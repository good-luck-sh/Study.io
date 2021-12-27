package com.sample.controller;

import com.sample.service.ProductServiceImpl;
import com.sample.service.UserServiceImpl;
import com.sample.vo.Product;
import com.sample.vo.User;

public class SampleConstructorController {

	/*
	 * 기본 생성자가 정의되어 있지 않다.
	 * 빈 설정파일에서 <bean id="식별자" class="클래스명"></bean>로 스프링 컨테이너에 보관할 빈을 생성할 수 없다.
	 * 
	 */
	private ProductServiceImpl productService;
	private UserServiceImpl userService;
	
	//스프링 컨테이너가 생성자 메소드를 이용해서 의존하는 객체를 주입할 수 있다. 
	//mix해서 사용하는 것이 안니 setter면 setter로 생성자면 생성자로 의존성을 주입해야한다. 헷깔릴 수 있다. 
	public SampleConstructorController(ProductServiceImpl productService, UserServiceImpl userService) {
		//생성자를 만든다.
		this.productService = productService;
		this.userService = userService;
	}
	
	public String execute() {
		Product product = productService.getProductByNo(100);
		User user = userService.getUserByNo(100);
		
		System.out.println(product);
		System.out.println(user);
		
		return null;
	}
	
}
