<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<title>애플리케이션</title>
</head>
<body>
<div class="container mt-3">
	<c:set var="menu" value="home"></c:set>
	<%@ include file="common/nav.jsp" %>
	<div class="row mb-3">
		<div class="col">
			<div class="border p-3 bg-light">
				<h1 class="mb-4">샘플 애플리케이션 입니다.</h1>
				<p class="">spring-boot, spring-security를 샘플애플리케이션입니다.</p>
				<p class="mb-4">회원가입, 로그인을 지원합니다.</p>
				
				<sec:authorize access="!isAuthenticated()">
					<div>
						<a href="/register" class="btn btn-primary btn-lg">회원가입</a>
						<a href="/login" class="btn btn-primary btn-lg">로그인</a>
					</div>
				</sec:authorize>
				
				
			</div>
		</div>
	</div>
</div>
</body>
</html>