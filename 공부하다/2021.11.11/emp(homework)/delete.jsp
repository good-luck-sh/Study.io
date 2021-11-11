
<%@page import="com.sample.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int empId = Integer.parseInt(request.getParameter("empId"));
	EmployeeDao employeeDao = new EmployeeDao();
	employeeDao.deleteEmployee(empId);
	
	response.sendRedirect("list.jsp");
%>