<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
</head>
<body>
<c:set var="menu" value="샘플2" />
<%@include file="navbar.jsp" %>
<div class ="container">
	<div class="row mb-3">
		<div class="col">
			<h1>c:if와 c:choose, c:when, c:otherwise 태그</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>c:if 태그</h3>
			<table class="table">
				<thead>
					<tr>
						<th>이름</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>총점</th>
						<th>평균</th>
						<th>합격/불합격</th>
						<th>장학금 지급여부</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${student1.name }</td>
						<td>${student1.kor }</td>
						<td>${student1.eng }</td>
						<td>${student1.math }</td>
						<td>${student1.kor + student1.eng + student1.math}</td>
						<td>${(student1.kor + student1.eng + student1.math)/3}</td>
						<td>
							<c:if test="${(student1.kor + student1.eng + student1.math)/3 ge 60 }"><strong>합격</strong></c:if>
							<c:if test="${(student1.kor + student1.eng + student1.math)/3 lt 60 }"><strong>불합격</strong></c:if>
						</td>
						<td>
						 	<c:choose>
						 		<c:when test="${student1.average gt 95 }">
									<strong>전액 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:when test="${student1.average gt 90 }">
									<strong>수업료 50%를 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:when test="${student1.average gt 85 }">
									<strong>수업료 10%를 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:otherwise><!-- else의 형태 -->
						 			<strong>장학금 지급대상이 아님</strong>
						 		</c:otherwise>
						 	</c:choose>
						</td>
					</tr>
					<tr>
						<td>${student2.name }</td>
						<td>${student2.kor }</td>
						<td>${student2.eng }</td>
						<td>${student2.math }</td>
						<td>${student2.total }</td>
						<td>${student2.average }</td>
						<td>
							<c:if test="${student2.passed }"><strong>힙격</strong></c:if>
							<c:if test="${not student2.passed }"><strong>불합격</strong></c:if>
						</td>
						<td>
							<c:choose>
						 		<c:when test="${student2.average gt 95 }">
									<strong>전액 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:when test="${student2.average gt 90 }">
									<strong>수업료 50%를 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:when test="${student2.average gt 85 }">
									<strong>수업료 10%를 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:otherwise><!-- else의 형태 -->
						 			<strong>장학금 지급대상이 아님</strong>
						 		</c:otherwise>
						 	</c:choose>
						</td>
					</tr>
					<tr>
						<td>${student3.name }</td>
						<td>${student3.kor }</td>
						<td>${student3.eng }</td>
						<td>${student3.math }</td>
						<td>${student3.total }</td>
						<td>${student3.average }</td>
						<td>
							<c:if test="${student3.passed }"><strong>힙격</strong></c:if>
							<c:if test="${not student3.passed }"><strong>불합격</strong></c:if>
						</td>
						<td>
							<c:choose>
						 		<c:when test="${student3.average gt 95 }">
									<strong>전액 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:when test="${student3.average gt 90 }">
									<strong>수업료 50%를 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:when test="${student3.average gt 85 }">
									<strong>수업료 10%를 장학금 지급</strong>						 			
						 		</c:when>
						 		<c:otherwise><!-- else의 형태 -->
						 			<strong>장학금 지급대상이 아님</strong>
						 		</c:otherwise>
						 	</c:choose>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>