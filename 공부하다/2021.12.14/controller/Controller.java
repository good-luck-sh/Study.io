package com.sample.model2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 클라이언트의 요청을 처리하는 모든 컨트롤러 구현클래스가 구현할 메소드를 정의하는 인터페이스다.
 * @author 김승희
 *
 */
public interface Controller {
	/**
	 * 클라이언트의 요청을 처리하는 메소드다.<br>
	 * 프론트 컨트롤러로부터 요청처리를 위임받아서 클라이언트의 요청을 직접 처리하는 메소드다.<br>
	 * 클라이언트의 요청처리에 필요한 요청객체와 응답객체를 프론트컨트롤러로부터 전달받는다.
	 * @param request 요청객체
	 * @param response 응답객체
	 * @throws Exception 요청처리 중 오류가 발생했을 때 
	 */
	void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
