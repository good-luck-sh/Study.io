<%@page import="com.sample.vo.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직종 정보 관리 :: 직종목록</title>
<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
</head>
<body>
<%
	JobDao jobDao = new JobDao();
	List<Job> jobs = jobDao.getJobsList();
%>

	<h1>전체 직종 목록</h1>
	<table>
		<thead>
			<tr>
				<th>직종아이디</th>
				<th>직종제목</th>
				<th>최소 급여</th>
				<th>최대 급여</th>
			</tr>
		</thead>
		
<%
	for(Job job : jobs) {
%>	
	<tbody>
			<tr>
				<td><%=job.getId() %></td>
				<td><a href="detail.jsp?jobId=<%=job.getId() %>"><%=job.getTitle() %></a></td>
				<td><%=job.getMinSalary() %></td>
				<td><%=job.getMaxSalaty() %></td>
			</tr>
		</tbody>


<%		
	}
%>
		
	</table>
	<div class="text-right">
		<a href="main.jsp">직종 정보 홈</a>
	</div>
</body>
</html>