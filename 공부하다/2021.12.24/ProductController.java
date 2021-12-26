package com.sample.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sample.service.ProductService;
import com.sample.vo.Product;


@Component
public class ProductController {
	
	/*
	 * @Autowired
	 * 		+ 자동으로 객체조립(의존성 주입:Dependency Injection)을 수행하게 한다. 
	 * 		+ 객체조립(의존성 주입)절차
	 * 		  1. 스프링 컨테이너가 빈 설정 정보를 이용해서 해당 객체를 모두 생성하고, 스프링 컨테이너에 보관한다.
	 * 		  2. AnnotaionProcessor가 스프링 컨테이너에 등록된 모든 객체의 어노테이션 정보를 분석한다. 
	 * 		  3. @Autowired 어노테이션을 감지하면 해당 어노테이션이 부착된 멤버변수의 타입을 알아낸다.
	 * 		  4. 스프링 컨테이너에 보관된 객체들 중에서 해당 타입의 객체가 있는지 확인한다. 
	 * 		  5. 해당 타입의 객체가 발견되면 그 객체의 참조값을 멤버변수에 대입해서 객체가 조립되게 한다.
	 * 			단, 해당타입의 객체가 존재하지 않거나, 해당 타입의 객체가 2개 이상 발견되는 경우 예외가 발생한다. 
	 * 			객체가 2개이상 존재하는 경우에는 특별한 경우이다. 2개이상 존재할 수는 있다. 
	 * 
	 * 동일한 타입의 객체가 2개 이상 존재하는 경우, 특정 객체 하나만 조립되게 하기 
	 * 		+ @Primary 어노테이션을 2개 중에 한 클래스에 부착한다.
	 * 		+ @Resource 어노테이션으로 조립될 객체의 빈아이디를 지정한다.
	 * 			@Component("p1")
	 * 			public class ProductImpl1 implements ProductService {}
	 * 			@Component("p2")
	 * 			public class ProductImpl2 implements ProductService {}
	 * 			
	 * 			@Component
	 * 			public class ProductController {
	 * 				@Resource(name = "p1")
	 * 				private ProductService productService;
	 * 			}
	 *       
	 */
	@Autowired
	private ProductService productService;
	//controller에 productService위에 autowired를 붙인다.
	//internalAutowiredAnnotationProcessor
	
	public String execute(int productNo) {
		Product product = productService.getProductByNo(productNo);
		System.out.println("상품 번호 :" + product.getNo());
		System.out.println("상품 이름 :" + product.getName());
		System.out.println("제조 회사 :" + product.getMaker());
		System.out.println("상품 가격 :" + product.getPrice());
		System.out.println("할인 가격 :" + product.getDiscountPrice());
		
		return "product.jsp";
	}
	
}
