<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//session을 폐기하는 로그아웃
	//세션객체를 무효화시킨다. 
	session.invalidate();

	response.sendRedirect("index.jsp");
%>