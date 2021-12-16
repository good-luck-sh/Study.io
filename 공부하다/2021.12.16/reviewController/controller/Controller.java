package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	//모든 객체의 구현 정석이 되는 컨트롤러 인터페이스

	/**
	 * 클라이언트의 요청을 처리한다.
	 * @param request 요청객체 
	 * @param response 응답객체
	 * @return 내부이동할 jsp 파일 혹은 재요청할 URL, 내부이동인 경우 "home.jsp", 재요청할 URL은 "redirect:/model2-todo/home.hta"
 	 * @throws Exception
	 */
	String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//요청 객체와 응답객체를 매개변수로 한 메소드의 결과값을 문자열로 출력한다. 
}
