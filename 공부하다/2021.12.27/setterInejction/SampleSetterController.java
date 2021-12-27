package com.sample.setter;

import com.sample.service.ProductServiceImpl;
import com.sample.service.UserServiceImpl;
import com.sample.vo.Product;
import com.sample.vo.User;

public class SampleSetterController {
	
	/*
	 * setter Injection(setter메소드를 이용한 의존성 주입)
	 * 		1. 의존하는 객체를 담는 멤버변수를 정의한다. 
	 * 		2. 멤버변수 갯수만큼 setter메소드를 정의한다. 
	 * 		3. 스프링 빈 설정파일에서 <property />태그를 이용해서 의존하는 객체를 주입시킨다.
	 * 		+  스프링 컨테이너는 스프링 빈 설정파일의 <bean />태그 정보를 읽어서 객체를 생성하고,<property />태그 정보를 읽어서 의존성 주입을 수행한다.
	 */
	
	/*
	 * SampleSetterController가 클라이언트의 요청을 처리할 때 사용하는 서비스객체(의존하는 서비스 객체)를 담는 멤버변수(프로퍼티)를 정의한다. 
	 * 내가 필요한 객체를 입력한다. 
	 */
	private ProductServiceImpl productService;
	private UserServiceImpl userService;
	
	/*
	 * SampleSetterController가 클라이언트의 요청을 처리할 때 사용하는 서비스 객체를 전달받는 setter메소드를 정의한다.
	 * 의존하는 객체를 주입(전달)받기 위한 setter메소드를 정의하는 것이다. 
	 * spring container가 객체를 만들고 전달할 예정으로 전달한 걸 받기 위해 setter에서 정의한다.
	 */
	public void setProductService(ProductServiceImpl productService) {
		this.productService = productService;
	}
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	public String execute() {
		Product product = productService.getProductByNo(100);
		User user= userService.getUserByNo(100);
		
		System.out.println(product);
		System.out.println(user);
		return null;
	}
}
