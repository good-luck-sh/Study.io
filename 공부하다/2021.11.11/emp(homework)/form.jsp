<%@page import="com.sample.vo.Employee"%>
<%@page import="com.sample.vo.Job"%>
<%@page import="com.sample.vo.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@page import="com.sample.dao.JobDao"%>
<%@page import="com.sample.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
<title>새로운 직원 입력하기</title>
</head>
<%
	DepartmentDao departmentDao = new DepartmentDao();
	JobDao jobDao = new JobDao();
	EmployeeDao employeeDao = new EmployeeDao();
	
	 List<Department> departments = departmentDao.getAllDepartments();
	 List<Job> jobs = jobDao.getJobsList();
	 List<Employee> employees = employeeDao.getManager();
	 
%>
<body>
	<h1>직원 정보 입력하기</h1>
	<form class="well" action="insert.jsp" method="post">
	<div class="form-group">
		<label>직원 성</label>
		<input type="text" name="firstName"/>
	</div>
	<div class="form-group">
		<label>직원 이름</label>
		<input type="text" name="lastName"/>
	</div>
	<div class="form-group">
		<label>이메일(이메일 주소만 작성해주세요)</label>
		<input type="text" name="email"/>
	</div>
	<div class="form-group">
		<label>전화번호</label>
		<input type="text" name="phoneNumber"/>
	</div>
	<!-- 직종아이디 -->
	<div class="form-group">
		<select name="jobId">
<%
	for(Job job : jobs) {
%>
			<option value="<%=job.getId() %>" ><%=job.getTitle() %></option>
<%
	}
%>	
		</select>
	</div>
	<div class="form-group">
		<label>급여</label>
		<input type="number" name="salary" min="0" max="9999999.99"/>
	</div>
	<div class="form-group">
		<select name="commission">
			<option value="0.1">0.1</option>
			<option value="0.15">0.15</option>
			<option value="0.2">0.2</option>
			<option value="0.25">0.25</option>
			<option value="0.3">0.3</option>
			<option value="0.35">0.35</option>
			<option value="0.4">0.4</option>
		</select>
	</div>
	<div class="form-group">
	<!-- 관리자아이디 -->
		<select name="managerId">
<%
	for(Employee employee : employees ) {
%>
			<option value="<%=employee.getManager().getId() %>" ><%=employee.getManager().getId() %></option>
<%
}
%>
		</select>
	</div>
	<div class="form-group">
	<!-- 부서아이디 -->
		<select name="departmentId">
<%
	for(Department department : departments ) {
%>
			<option value="<%=department.getId() %>" ><%=department.getName() %></option>
<%
}
%>
		</select>
	</div>
	<div class="text-right">
		<button class="btn" type="submit" value="등록">등록</button>
	</div>
	</form>
</body>
</html>