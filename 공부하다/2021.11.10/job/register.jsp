<%@page import="com.sample.dao.JobDao"%>
<%@page import="com.sample.vo.Job"%>
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
	JobDao jobDao = new JobDao();
	String jobId = request.getParameter("id");
	String jobTile  = request.getParameter("title");
	int minJobSalary = Integer.parseInt(request.getParameter("min"));
	int maxJobSalary = Integer.parseInt(request.getParameter("max"));
	Job job = new Job();
	job.setId(jobId);
	job.setTitle(jobTile);
	job.setMinSalary(minJobSalary);
	job.setMaxSalaty(maxJobSalary);
	
	jobDao.insertJob(job);
	
	response.sendRedirect("list.jsp");
	
%>
	
</body>
</html>