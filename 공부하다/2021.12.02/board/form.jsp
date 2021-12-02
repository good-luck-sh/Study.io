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
	<%@ include file="../common/header.jsp"%>
	<div class="container mb-5">
		<div class="row">
			<div class="col-12">
				<h1 class="fs-3">게시글 등록폼</h1>
			</div>
		</div>
		<div class="row mb-5">
			<div class="col">
				<form action="register.jsp" method="post" class="border p-3 bg-light">
					<div class="mb-3">
						<label for="" class="form-label">제목</label> 
						<input type="text" class="form-control" name="title">
					</div>
					<div class="mb-3">
						<label for="" class="form-label">작성자</label> 
						<input type="text" class="form-control" name="writer">
					</div>
					<div class="mb-3">
						<label for="" class="form-label">내용</label>
						<textarea class="form-control" name="content" rows="5"></textarea>
					</div>
					<div class="mb-3 text-end">
						<button class="btn btn-primary">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>