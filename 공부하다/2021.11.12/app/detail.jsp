<%@page import="java.util.List"%>
<%@page import="com.sample.vo.Employee"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
<title>직원 상세 정보 조회</title>
</head>
<body>
<%
	int employeeId = Integer.parseInt(request.getParameter("empId"));
	EmployeeDao employeeDao = new EmployeeDao();
	Employee employee = employeeDao.getEmployeeById(employeeId);
	List<Employee> managers = employeeDao.getAdministrateEmployee(employee.getId());
	int number = employeeDao.getCountManager(employee.getId());
%>
<h2>직원 상세 정보 조회하기</h2>
	
				
<%
	if(managers.isEmpty()) {
%>
	<table>
		<thead>
			<tr>
		<th>사원아이디</th>
		<th>사원 이름</th>
		<th>사원 연락처</th>
		<th>사원 이메일</th>
		<th>직종 아이디</th>
		<th>직종 제목</th>
		<th>직원 급여</th>
		<th>직원 커미션</th>
		<th>관리자 이름</th>
		<th>부서 아이디</th>
		<th>부서 이름</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=employee.getId() %></td>
				<td><%=employee.getFirstName() %><%=employee.getLastName() %></td>
				<td><%=employee.getPhoneNumber() %></td>
				<td><%=employee.getEmail() %></td>
				<td><%=employee.getJob().getId() %></td>
				<td><%=employee.getJob().getTitle() %></td>
				<td><%=employee.getSalary() %></td>
				<td><%=employee.getCommissionPct() %></td>
				<td><%=employee.getManager().getFirstName() %><%=employee.getManager().getLastName() %></td>
				<td><%=employee.getDepartment().getId() %></td>
				<td><%=employee.getDepartment().getName() %></td>	
			</tr> 
		</tbody>
	</table>

<%
	} else {
%>				
	<table>
		<thead>
			<tr>
				<th>사원아이디</th>
				<th>사원 이름</th>
				<th>사원 연락처</th>
				<th>사원 이메일</th>
				<th>직종 아이디</th>
				<th>직종 제목</th>
				<th>직원 급여</th>
				<th>직원 커미션</th>
				<th>관리자 이름</th>
				<th>부서 아이디</th>
				<th>부서 이름</th>
				<th>관리 사원 수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=employee.getId() %></td>
				<td><%=employee.getFirstName() %><%=employee.getLastName() %></td>
				<td><%=employee.getPhoneNumber() %></td>
				<td><%=employee.getEmail() %></td>
				<td><%=employee.getJob().getId() %></td>
				<td><%=employee.getJob().getTitle() %></td>
				<td><%=employee.getSalary() %></td>
				<td><%=employee.getCommissionPct() %></td>
				<td><%=employee.getManager().getFirstName() %><%=employee.getManager().getLastName() %></td>
				<td><%=employee.getDepartment().getId() %></td>
				<td><%=employee.getDepartment().getName() %></td>	
				<td><%=number %></td>			
			</tr> 
		</tbody>
	</table>
	<h3>관리하는 사원 리스트</h3>
	<table>
		<thead>
			<tr>
				<th>사원 아이디</th>
				<th>사원 이름</th>
				<th>사원 이메일</th>
			</tr>
		</thead>
		<tbody>
<%
	for(Employee manager : managers) {
%>
			<tr>
				<td><%=manager.getId() %></td>
				<td><%=manager.getFirstName() %><%=manager.getLastName() %></td>
				<td><%=manager.getEmail() %></td>
			</tr>
<%
	}
%>
		</tbody>
	
	</table>
<% 		
	}

%>


	<div class="text-left"><a href="modifyUpdate.jsp">수정하기</a></div>
	
<%
	if(number == 0) {
%>
	<div class="text-right"><a href="delete.jsp?empId=<%=employee.getId() %>">삭제하기</a></div>

<% 
	}
%>

</body>
</html>