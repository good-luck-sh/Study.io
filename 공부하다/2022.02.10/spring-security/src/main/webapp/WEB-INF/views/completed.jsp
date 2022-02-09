<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>애플리케이션</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col">
			<div class="border p-3 bg-light">
				<h1 class="mb-4">회원가입이 완료되었습니다.</h1>
				<p class="mb-3">애플리케이션의 다양한 서비스를 사용하기 위해서 로그인 페이지에서 로그인를 해주십시요</p>
				<a href="/loginform" class="btn btn-primary btn-lg">로그인</a>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>