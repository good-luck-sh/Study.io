<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 상세 정보</title>
<style type="text/css">
	table {
	width:100%;
	border-collapse: collapse;
	
	}
	td, th {
	border: 1px solid black;
	text-align: left;
	padding: 8px;
	}
	th {
		background-color:#dddddd;
	}
</style>
</head>
<body>
	<h1>직원 상세 보기 </h1>
	<table>
		<tbody>
			<tr>
				<th style="width: 15%;">아이디</th><td style="width: 35%;">${employee.id}</td>
				<th style="width: 15%;">이름</th><td style="width: 35%;">${employee.firstName } ${employee.lastName }</td>
			</tr>
			<tr>
				<th>전화번호</th><td>${employee.phoneNumber}</td>
				<th>이메일</th><td>${employee.email }</td>
			</tr>
			<tr>
				<th>직종 아이디</th><td>${employee.jobId }</td>
				<th>소속부서 아이디</th><td>${employee.departmentId }</td>
			</tr>
			<tr>
				<th>급여</th><td><fmt:formatNumber value="${employee.salary }" pattern="##,###" /> 달러</td>
				<th>커미션</th><td>${employee.commissionPct*100 }%</td>
			</tr>
			<tr>
				<th>관리자 아이디</th><td>${employee.managerId }</td>
				<th>입사일</th><td><fmt:formatDate value="${employee.hireDate }" pattern="yyyy년 M월 d일"/></td>
			</tr>
		</tbody>
	</table>
	<div style="margin-top:10px; text-align: right;">
		<a href="list.do">목록</a>
	</div>
</body>
</html>