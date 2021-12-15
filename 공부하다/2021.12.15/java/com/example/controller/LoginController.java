package com.example.controller;

import com.example.dao.UserDao;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1.요청객체에서 요청파라미터(id,password)를 조회한다. 
		 * 2.UserDao의 getUserById(id)를 실행해서 사용자 정보를 조회한다. 
		 * 3.사용자 정보가 null이면 "redirect:/model2-todo/loginform.hta?error=notfound"을 반환한다. 
		 * 4.비말번호가 일치하지 않으면 "redirect:/model2-todo/loginform.hta?error=mismatch"를 반환한다. 
		 * 5.사용자가 존재하고, 비밀번호가 일치하면 HttpSession객체를 획득해서 HttpSession객체를 획득(request.getSession()) 사용자 정보를 
		 * 	 "loginUser"라는 속성명으로 저장한다. 
		 * 6. 홈페이지를 재요청하는 URL("redirect:/model2-todo/home.hta")을 반환한다. 
		 *
		 */
		
		String userid = request.getParameter("id");
		String userpassword = request.getParameter("password");
		
		UserDao userDao = UserDao.getInstance();
		User user = userDao.getUserById(userid);
		//User user = UserDao.getInstance().getUserById(id);로 사용가능
		
		if(user == null) {
			return "redirect:/model2-todo/loginform.hta?error=notfound";
		}
		if(!user.getPassword().equals(userpassword)) {
			return "redirect:/model2-todo/loginform.hta?error=mismatch";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user);
		
		return "redirect:/model2-todo/home.hta";
	}
}
