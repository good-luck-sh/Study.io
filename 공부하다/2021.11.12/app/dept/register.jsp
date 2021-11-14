<%@page import="com.sample.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	/*
		form.jsp에서 입력한 폼 입력값은 register.jsp에 제출된다. 
		폼입력값은 각각 name, locationId라는 파라미터명으로 요청객체에 저장되어있다.
		요청객체가 제공하는 String getParameter(String 파라미터명) 메소드로 전달받은 값을 조회한다.
	*/

	String name = request.getParameter("name");
	int locationId = Integer.parseInt(request.getParameter("locationId"));
	
	DepartmentDao departmentDao = new DepartmentDao();
	//부서정보를 저장하는 메소드 실행하기 
	departmentDao.insertDepartment(name, locationId);
	
	//전체 부서 목록을 재요청하는 URL을 응답으로 보낸다.
	response.sendRedirect("list.jsp");
%>