<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="com.sample.board.vo.User"%>
<%@page import="com.sample.board.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	UserDao userDao = UserDao.getInstance();
	User user = userDao.getUserById(id);
	
	if(user == null) {//id에 해당하는 회원정보가 존재하지 않음
		response.sendRedirect("loginform.jsp?fail=id");
		return;
	}
	
	String secretPassword = DigestUtils.sha256Hex(password);
	//입력된 암호화와 저장된 암호화가 동일한지 비교를 해야한다. DigestUtils.로 비교한다.
	
	if(!user.getPassword().equals(secretPassword)) { //비밀번호가 일치하지 않음
		response.sendRedirect("loginform.jsp?fail=pwd");
		return;
	}
	
	//회원정보가 존재하고, 비밀번호도 일치한다. 
	session.setAttribute("LOGIN_USER_INFO", user);
	
	response.sendRedirect("index.jsp");
%>