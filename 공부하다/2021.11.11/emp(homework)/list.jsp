<%@page import="com.sample.vo.Department"%>
<%@page import="com.sample.dao.DepartmentDao"%>
<%@page import="com.sample.vo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
<title>전체 사원 리스트 화면</title>
</head>
<body>
<% 
	DepartmentDao departmentDao = new DepartmentDao();
	EmployeeDao employeeDao = new EmployeeDao();
	List<Employee> employees = employeeDao.getAllEmployee();
	
	
	
%>
	<div>
		<table>
			<thead>
				<tr>
					<th>사원아이디</th>
					<th>사원 이름</th>
					<th>사원 연락처</th>
					<th>사원 이메일</th>
					<th>소속부서명</th>
				</tr>
			</thead>
			<tbody>
			
<%
 for(Employee employee : employees) {
	 Integer departmentId = employeeDao.getDepartmentIdByEmployee(employee.getId());
	 Department department = departmentDao.getDepartmentById(departmentId);
			
%>			
					<tr>
					<td><%=employee.getId() %></td>
					<td><a href="detail.jsp?empId=<%=employee.getId()%>"><%=employee.getFirstName() %><%=employee.getLastName() %></a></td>
					<td><%=employee.getPhoneNumber() %></td>
					<td><%=employee.getEmail() %></td>
<%
			if (departmentId != 0) {
%>
					<td><%=department.getName() %></td>

<% 	
			} else {
%>
					<td>존재하지 않습니다.</td>					
<%
}
%>					
					</tr>
<%
}
%>
				
			</tbody>
		</table>
	</div>
</body>
</html>