package com.sample.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.dto.ResponseDto;
import com.sample.exception.CartErrorException;
import com.sample.exception.LoginErrorException;
import com.sample.exception.RestLoginErrorException;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/login/form.do")
	public String loginform() {
		throw new LoginErrorException("로그인 후 사용가능한 서비스 입니다.");
	}
	/*
	 * @ExceptionHandler(LoginErrorException.class)
		public String handleException(LoginErrorException e ,Model model) { //모델을 입력받는다.
		
		model.addAttribute("error", e.getMessage());	//모델객체와 담아둔 것을 보낸다.
		return "loginform/jsp";		//homeController에 model에 error값을 담아서 exception을 보냈었다. 
		//homeController에서 try catch를 적었던 것을 삭제한다. 예외처리를 신경쓰지 않고, Service에서 error를 throw new로 발생시키기만 하면된다.
	}
	 */
	
	@RequestMapping("/login/rest.do")
	public ResponseDto<?> rest() {
		throw new RestLoginErrorException("로그인 후 사용가능한 서비스입니다.");
		//아래의 예외처리 핸들러 메소드가 실행되도록 예외를 강제로 발생시킨다.
	}
	/*
	 * @ExceptionHandler(RestLoginErrorException.class)
		public @ResponseBody ResponseDto<?> handlerCartErrorException(RestLoginErrorException e) {
		
		ResponseDto<?> response = new ResponseDto<>();
		response.setStatus("FAIL");
		response.setError(e.getMessage());
		return response;
	}
	 * /
	 */
}
