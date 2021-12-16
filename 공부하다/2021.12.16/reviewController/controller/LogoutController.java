package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*
 * 1."model2-todo/logout" 요청을 처리하는 컨트롤러다.
 * 2. HttpSession객체를 폐기한다. 
 * 3. 로그아웃 처리가 완료되면 홈화면을 재요청하는 URL("/model2-todo/home.hta")을 응답으로 보낸다.
 */
public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. HttpSession객체를 획득(request.getSession())해서 session객체를 폐기(session.invalidate())시킨다. 
		 * 2. 홈 화면을 요청하는 재요청 URL을 응답으로 보낸다.
		 */
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/model2-todo/home.hta";
	}
}
