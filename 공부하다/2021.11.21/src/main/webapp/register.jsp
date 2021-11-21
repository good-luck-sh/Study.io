<%@page import="com.sample.board.dao.UserDao"%>
<%@page import="com.sample.board.vo.User"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// registerform.jsp에서 제출한 폼입력값을 조호한다.
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	
	// 사용자 인증에 필요한 사용자정보를 조회하기 위해서 UserDao객체를 획득한다.
	UserDao userDao = UserDao.getInstance();
	
	// 아이디로 사용자 정보를 조회한다.
	User savedUser = userDao.getUserById(id);
	// 아이디에 해당하는 사용자 정보가 존재하면, 회원가입이 실패한다.
	// 클라이언트에게 회원가입 정보를 입력하는 registerform.jsp를 재요청하는 응답을 보낸다.
	// 재요청 URL에 회원가입 실패원인을 포함시킨다.
	if (savedUser != null) {
		response.sendRedirect("registerform.jsp?error=id-exists");
		return;
	}
	
	// 이메일로 사용자 정보를 조회한다.
	savedUser = userDao.getUserByEmail(email);
	// 이메일에 해당하는 사용자 정보가 존재하면, 회원가입이 실패한다.
	// 클라이언트에게 회원가입 정보를 입력하는 registerform.jsp를 재요청하는 응답을 보낸다.
	// 재요청 URL에 회원가입 실패원인을 포함시킨다.
	if (savedUser != null) {
		response.sendRedirect("registerform.jsp?error=email-exists");
		return;
	}
	
	// 동일한 아이디로 가입된 사용자가 없고, 동일한 이메일로 가입된 사용자 존재하지 않으면 회원가입을 진행한다.
	
	// 비밀번호를 암호화한다.
	String secretPassword = DigestUtils.sha256Hex(password);
	// User객체를 생성해서 사용자정보를저장한다.
	User user = new User();
	user.setId(id);
	user.setPassword(secretPassword);
	user.setName(name);
	user.setTel(tel);
	user.setEmail(email);
	
	// 회원정보를 테이블에 저장시킨다.
	userDao.insertUser(user);
	
	// 클라이언트에게 index.jsp를 재요청하는 URL을 응답으로 보낸다.
	// 재요청 URL에 회원가입이 완료되었다는 정보를 포함시킨다.
	response.sendRedirect("index.jsp?register=completed");
%>