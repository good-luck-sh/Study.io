package com.example.controller;

import com.example.dao.UserDao;
import com.example.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
/*
 * 1."model2-todo/login.hta" 요청을 처리하는 컨트롤러다.
 * 2. 로그인폼에서 서버에 제출한 아이디와 비밀번호를 요청객체에서 요청파라미터값으로 조회한다.
 * 3.사용자 정보를 조회하고, 비밀번호 체크를 수행하며, 사용자 인증이 실패하면 로그인폼 화면을 재요청하는 URL을 응답으로 보낸다.
 * 4. 사용자 인증이 완료되면 HttpSession객체에 (클라이언트의 개인정보 보관소)에 인증된 사용자정보를 저장한다.
 * 5. 인증작업이 완료되면 홈화면을 재요청하는 url("/model2-todo/home.hta")을 FrontControllerServlet에게 반환한다.
 */
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
