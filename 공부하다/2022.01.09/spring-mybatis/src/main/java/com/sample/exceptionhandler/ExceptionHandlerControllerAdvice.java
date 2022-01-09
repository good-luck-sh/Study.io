package com.sample.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.dto.ResponseDto;
import com.sample.exception.CartErrorException;
import com.sample.exception.CustomException;
import com.sample.exception.LoginErrorException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	public String handlerCustomException(CustomException e) {
		return "error/customError.jsp";
	}
	@ExceptionHandler(DataAccessException.class)
	public String handleDataAccessException(DataAccessException e) {
		return "error/databaseError.jsp";
	}//요청페이지가 전송된다. 

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) { //해당하는 Exception이 발생하면 에러페이지로 보내고 싶다.
		return "error/serverError.jsp";
	}
	/*
	 * @ControllerAdvice와 @RestControllerAdvice
	 * 	+@ControllerAdvice는 @Controller클래스와 @RestController클래스 관련된 예외처리가 구현된 클래스를 나타내는 어노테이션이다.
	 * 	+@ControllerAdvice는 클래스의 예외처리 메소드는 예외가 발생하면 오류페이지 혹은 JSON응답을 제공할 수 있다. //범용적으로 사용가능하다.
	 *  +@RestControllerAdvice는 클래스의 예외처리 메소드는 예외가 발생하면 JSON응답만 제공할 수 있다. //JSON응답만 가능하다.
	 *  
	 *  +@RestControllerAdvice는 @RestController클래스 관련된 예외처리가 구현된 클래스를 나타내는 어노테이션이다. --responsebody를 붙이지 않아도 내려간다는 것이다. 
	 *  +웹 애플리케이션이 웹 페이지를 응답으로 제공하는 어플리케이션인 경우 @ControllerAdvice만 사용해서 오류페이지를 응답으로 제공하면 된다. 
	 *  +웹 애플리케이션이 웹 페이지와 Rest응답을 제공하는 애플리케이션인 경우 @ControllerAdvice만 사용하거나 @RestControllerAdvice를 같이 사용할 수 있다.
	 *  +웹 애플리케이션이 Rest 응답을 제공하는 애플리케이션인 경우 @RestControllerAdvice만 사용해서 응답을 제공할 수 있다. 
	 *  
	 *  +예외가 발생하면 여러 예외처리 메소드 중에서 발생한 예외와 가장 일치하는 예외가 정의된 예외처리 메소드가 실행된다. 
	 *  +일치하는 예외가 없으면 부모타입의 예외가 정의된 예외처리 메소드가 실행된다.(혹은 조상타입)
	 */
	
	//장바구니 아이템 예외처리 핸들러 메소드 --> JSON텍스트를 응답으로 제공{"status":"FAIL", "error":"에러메세지","items":null}
	@ExceptionHandler(CartErrorException.class)
	public @ResponseBody ResponseDto<?> handlerCartErrorException(CartErrorException e) {
		ResponseDto<?> response = new ResponseDto<>();
		response.setStatus("FAIL");
		response.setError(e.getMessage());
		return response;
	}
	
	@ExceptionHandler(LoginErrorException.class)
	public String handleException(LoginErrorException e ,Model model) { //모델을 입력받는다.
		model.addAttribute("error", e.getMessage());	//모델객체와 담아둔 것을 보낸다.
		return "loginform/jsp";		//homeController에 model에 error값을 담아서 exception을 보냈었다. 
		//homeController에서 try catch를 적었던 것을 삭제한다. 예외처리를 신경쓰지 않고, Service에서 error를 throw new로 발생시키기만 하면된다.
	}

}
