package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 *  1."model2-todo/home.hta" 요청을 처리하는 컨트롤러다.
 *  2. 홈 화면에 표시할 데이터가 있으면 테이블에서 데이터를 조회하고, 요청객체에 속성으로 저장한다. 
 *  3. 내부이동할 "home.jsp" 를 FrontControllerServlet에게 반환한다.
 */
public class HomeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "home.jsp";
	}
}
