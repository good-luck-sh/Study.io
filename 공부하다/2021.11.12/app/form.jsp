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
<title>사원 정보 관리 :: 등록폼</title>
</head>
<%
	DepartmentDao departmentDao = new DepartmentDao();
	JobDao jobDao = new JobDao();
	EmployeeDao employeeDao = new EmployeeDao();
	
	 List<Department> departments = departmentDao.getAllDepartments();
	 List<Job> jobs = jobDao.getJobsList();
	 List<Employee> manager = employeeDao.getManager();
	 
%>
<body>
	<h1>새 사원정보 등록폼</h1>
	<form class="well" action="register.jsp" method="post">
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
		<option value="" selected="selected" disabled="disabled">직종을 선택하세요</option>
<%
	for(Job job : jobs) {
%>
			<option value="<%=job.getId() %>" ><%=job.getTitle() %>(<%=job.getMinSalary() %>~<%=job.getMaxSalaty() %>)</option>
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
			<label>커미션</label>
			<input type="radio" name="commission" value="0.1">0.1
			<input type="radio" name="commission" value="0.15">0.15
			<input type="radio" name="commission" value="0.2">0.2
			<input type="radio" name="commission" value="0.25" checked="checked"/>0.25
			<input type="radio" name="commission" value="0.3">0.3
			<input type="radio" name="commission" value="0.35">0.35
			<input type="radio" name="commission" value="0.4">0.4
			<input type="radio" name="commission" value="0.45">0.45
		
	</div>
	<div class="form-group">
	<!-- 관리자아이디 -->
	<label>관리자 아이디</label>
		<select name="managerId">
		<option value="" selected="selected" disabled="disabled">0</option>
<%
	for(Employee employee : manager ) {
%>
			<option value="<%=employee.getId() %>" ><%=employee.getFirstName() %><%=employee.getLastName() %>(<%=employee.getDepartment().getName() %>)</option>
<%
}
%>
		</select>
	</div>
	<div class="form-group">
	<!-- 부서아이디 -->
	<label>소속부서</label>
		<select name="departmentId">
		<option value="" selected="selected" disabled="disabled">부서를 선택하세요</option>
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