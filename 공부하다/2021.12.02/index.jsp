<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="ko">
<head>
<title>샘플 게시판</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container">
		<div class="p-5 bg-light">
			<div class="container">
				<h1 class="display-3">CRUD 샘플 애플리케애션</h1>
				<p class="lead">게시글 등록/수정/삭제/조회 기능을 제공하는 샘플 애플리케이션입니다.</p>
				<p class="lead">
					<a class="btn btn-primary btn-lg" href="/search-app/board/list.jsp" role="button">게시글 목록 보기</a>
				</p>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>