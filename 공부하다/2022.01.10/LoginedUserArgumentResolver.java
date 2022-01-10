package com.sample.argumentResolver;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.sample.annotation.LoginedUser;
import com.sample.controller.BookController;
import com.sample.util.SessionUtils;

public class LoginedUserArgumentResolver implements HandlerMethodArgumentResolver{

	static final Logger logger = LogManager.getLogger(LoginedUserArgumentResolver.class);//로고를 가져온다.
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		logger.info("@LoginedUser 어노테이션을 가지고 있는가? " + parameter.hasParameterAnnotation(LoginedUser.class));
		//해당 파라미터가 해당어노테이션클래스를 가지고 있는지 체크한다.
		logger.info("매개변수의 클래스 이름 : " + parameter.getParameterName());
		//파라미터의 타입을 구분한다.
		logger.info("매개변수의 이름 : " + parameter.getParameterType().getClass().getName());
		//변수명을 구분한다. 

		return parameter.hasParameterAnnotation(LoginedUser.class);
		//파라미터가 hasParameter 해당 어노테이션 클래스가 있는지 true false를 반환한다. 
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		logger.info("@LoginUser 이 부착된 매개변수다. HttpSession객체에 저장된 인증된 사용자 정보를 매개변수로 전달한다.");
		//HttpSession객체에 "LOGIN_USER"라는 속성명으로 저장된 사용자 정보를 반환한다.
		return SessionUtils.getAttribute("LOGIN_USER");
	}

}
