<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<title>애플리케이션</title>
</head>
<body>
<body>
<div class="container mt-3">
	<c:set var="menu" value="home"></c:set>
	<%@ include file="../common/nav.jsp" %>
	<div class="row mb-3">
		<div class="col">
			<div class="border p-3 bg-light">
				<h1 class="mb-4">서비스 접근 거부</h1>
				<p class="">해당 서비스 접근이 거부되었습니다.</p>
				<p class="mb-4"><a href="/" class="btn btn-outline-primary">홈</a> 으로 이동하기</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>