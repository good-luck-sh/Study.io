package com.sample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //언제 , 무엇을 , 어디에
public class LoggingAdvice {

	/*
	 * Aspect 
	 * 		- 공통기능 적용 패키지다.
	 * 		- 공통기능 적용 패키지에는 What(공통기능) + When(언제) + Where(대상) 정보를 포함한다.
	 * 		- What 
	 * 			+ logging() 메소드의 수행문 
	 * 		- When 
	 * 			+ @Before : 핵심기능이 구현된 메소드가 실행되기 전에 
	 * 		- Where 
	 * 			+ "within(com.sample.service.*Service)" : com.sample.service 패키지의 모든서비스 클래스의 모든 메소드
	 * 
	 * 	주요 어노테이션 
	 * 		@Aspect
	 * 			- AutoProxyCreator 스프링 컨테이너는 등록된 빈 중에서 @Aspect 어노테이션이 부착된 빈을 스캔해서 
	 * 			  대상객체를 검색하고, 대상객체의 조인포인트와 결합시킨 프록시 객체를 만들어서 스프링 컨테이너의 빈으로 등록한다.
	 * 
	 * 		@Before
	 * 			- 공통기능이 대상 메소드 실행전에 실행된다.
	 * 		@After
	 * 			- 공통기능이 대상 메소드가 실행이 종료된 후에 실행된다.
	 * 		@AfterReturning
	 * 			- 공통기능이 대상 메소드가 오류 없이 종료된 후에 실행된다.
	 * 		@AfterThrowing
	 * 			- 공통기능이 대상 메소드 실행중 예외가 발생하며 실행된다. 
	 * 		@Around
	 * 			- 공통기능이 대상 메소드 실행 전후에 실행된다.
	 * 			- 선언적 트랜잭션 처리를 지원하는 TransactionManager의 구현객체들이 @Around Advice와 유사하다.
	 * 
	 * 		@Pointcut
	 * 			- 공통기능이 적용될 규칙을 지정할 때 사용한다.
	 */
	/*
	 * 	공통기능 구현하기 
	 * 		+ 공통기능이 실행될 싯점을 지정한다(@Before, @After, @AfterReturning, @AfterThrowing, @Around 중 하나를 사용한다. )
	 * 		+ 거의 @Around를 사용한다. 
	 */
	@Before("within(com.sample.service.*Service)")//언제 (대상이 출력되기 전에) /괄호안에 어디에서(com.sample.service패키지안에서 Service로 끝나는 애들)AspectJ 표현식
	public void logging() {
		System.out.println("################ AOP로 로그를 출력합니다."); //What 로그를 출력하게 할꺼야
	}
}
