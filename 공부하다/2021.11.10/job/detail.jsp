<%@page import="com.sample.vo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.vo.Job"%>
<%@page import="com.sample.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
</head>
<body>
<%
	String jobsId = request.getParameter("jobId");
	JobDao jobDao = new JobDao();
	Job job = jobDao.getJobListById(jobsId);
	int countEmployee = jobDao.getJobsCount(jobsId);
	List<Employee> employees = jobDao.getEmployeesListById(jobsId);
	
	
%>
	<h1>직종 상세정보</h1>
	<table>
		<thead>
			<tr>
				<th>직종 아이디</th>
				<th>직종 제목</th>
				<th>최소 급여</th>
				<th>최대 급여</th>
				<th>해당 직종에 종사하는 사원수</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td><%=job.getId() %></td>
				<td><%=job.getTitle() %></td>
				<td><%=job.getMinSalary() %></td>
				<td><%=job.getMaxSalaty() %></td>
				<td><%=countEmployee %>명</td>
			</tr>
		</tbody>

	</table>
	<h2>사원 리스트</h2>
	<table>
	<thead>
			<tr>
				<th>사원아이디</th>
				<th>사원 이름</th>
				<th>사원 이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
			</tr>
		</thead>
<%
	for (Employee employee : employees) {
%>
		
		<tbody>
			<tr>
				<td><%=employee.getId() %></td>
				<td><%=employee.getFirstName() %><%=employee.getLastName() %></td>
				<td><%=employee.getEmail() %></td>
				<td><%=employee.getPhoneNumber() %></td>
				<td><%=employee.getHireDate() %></td>
			</tr>
		</tbody>
<%
	}
%>
	</table>
	<div>
		<a href="list.jsp">직종목록</a>
	</div>
</body>
</html>