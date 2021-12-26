package com.sample.controller;

import com.sample.service.UserService;
import com.sample.vo.User;

public class UserController {

	//사용자 관련 업무로직이 구현된 UserService 구현객체가 필요하다.
	//context-1에서 조립한 userService가 들어가 있다.
	private UserService userService;
	
	//UserController 객체(빈)은 UserService타입의 객체를 전달받기 위해서 setter메소드를 정의한다. 
	//일반적으로 우리가 객체를 사용하기 위해서 객체를 만들고 setter메소드를 만든거를 생각하면 된다. 
	//setter메소드가 있으면 조립할 준비는 완료 되었다. 
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//사용자번호를 전달받아서 사용자 상세정보를 출력하는 요청 핸들러 메소드
	public String execute(int userNo) {
		User user= userService.getUserByNo(userNo);
		System.out.println("사용자번호 : " +user.getNo());
		System.out.println("사용자명 : " +user.getName());
		System.out.println("사용자이메일 : " +user.getEmail());
		System.out.println("사용자비밍번호 : " +user.getPassword());
	
		return "detail.jsp";//detail.jsp는 없지만 흉내내기위해서 작성함 
	}
}
