<%@page import="com.sample.board.dao.UserDao"%>
<%@page import="com.sample.board.vo.User"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	
	String secretPassword = DigestUtils.sha256Hex(password);
	//암호화시키는 util = DigestUtils.sha256Hex
	//실제로는 이렇게 바로 암화하지 않고, 특정글자를 붙이거나 글자를 살짝변경하여 암호화한다.
	
	User user = new User();
	user.setId(id);
	user.setPassword(secretPassword);
	user.setName(name);
	user.setTel(tel);
	user.setEmail(email);
	
	UserDao userDao = new UserDao();
	//동일한 사용자 아이디로 가입된 사용자가 있으면 안됨
	User savedUser = userDao.getUserById(id);
	if(savedUser != null ) {
		response.sendRedirect("registerform.jsp?fail=id");
		//회원가입폼을 다시 요청하게 하는 URL을 응답으로 보낸다.
		return;
	}
	// 동일한 이메일로 가입된 사용자가 있으면 안됨
	 savedUser = userDao.getUserByEmail(email);
	if(savedUser != null) {
		//회원 가입폼을 다시 요청하게 하는 URL을 응답으로 보낸다ㅑ.
		response.sendRedirect("registerform.jsp?fail=email");
		return;
	}
	//사용자의 정보를 테이블에 저장시킨다. 
	userDao.insertUser(user);
	//회원가입이 성공적으로 완료되면 시작페이지를 재요청하게 하는 URL을 응답으로 보낸다.
	response.sendRedirect("index.jsp?register=completed");
%>