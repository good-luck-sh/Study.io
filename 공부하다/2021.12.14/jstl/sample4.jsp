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
<div class ="container">
	<div class="row mb-3">
		<div class="col">
			<h1>날짜/시간, 숫자 포맷팅</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
		 	<h3>날짜/시간을 형식화해서 출력하기</h3>
		 	<p>${today }</p>
		 	<p><fmt:formatDate value="${today }" /></p>
		 	<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm:ss"/> </p>
		 	<!-- M을 1개 적으면 5월 2개적으면 05월로 출력된다. a는 오전, 오후라고 출력된다. EEEE는 요일을 나타낸다. EEE는 요일 앞자리만 나온다. -->
		 	<p><fmt:formatDate value="${today }" pattern=" M월 d일 a h시 m분 s초"/> </p>
		 	<p><fmt:formatDate value="${today }" pattern="yyyy년 M월 d일 EEEE"/> </p>
		 	<!-- DB에서 표현하기 직전에 바꿀 수 있다.  -->
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
		 	<h3>숫자를 형식화해서 출력하기</h3>
		 	<p>잔액 : ${balance }</p>
		 	<p>잔액 : <fmt:formatNumber value="${balance }"/> </p>
		 	<p>잔액 : <fmt:formatNumber value="${balance }" pattern="##,###.##"/> </p>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>