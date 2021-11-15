<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>식품 판매 프로그램</title>
</head>
<body>

<div class="container">
	<%@ include file="common/navigation.jsp" %> <!-- 지시어로 경로를 포함시킨다. 한군데만 작성하고 포함되게 만들 수 있다.-->
	<div class="p-5 mb-4 bg-light rounded-3">
		<div class="container-fluid py-2">
			<h1 class="display-5 fw-bold">식품 판매 프로그램</h1>
			<p class="col-md-8 fs-4">PC방, 독서실 등에서 사용가능한 식품 판매 프로그램입니다.</p>
			<p class="col-md-8 fs-4">조회기능, 등록기능, 주문관리 기능을 포함하고 있습니다.</p>
		</div>
	</div>
</div>
</body>
</html>
