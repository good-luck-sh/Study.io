<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>부트스트랩</title>
</head>
<body>
<div class ="contatiner">
	<h1>페이지네이션</h1>
	<h3>기본 페이지 네이션</h3>
	<div>
		<ul class="pagination">
			<li class="page-item"><a href="" class="page-link">이전</a></li>
			<li class="page-item"><a href="" class="page-link">1</a></li>
			<li class="page-item"><a href="" class="page-link">2</a></li>
			<li class="page-item"><a href="" class="page-link">3</a></li>
			<li class="page-item"><a href="" class="page-link">4</a></li>
			<li class="page-item"><a href="" class="page-link">5</a></li>
			<li class="page-item"><a href="" class="page-link">다음</a></li>
		</ul>
	</div>
	<hr>
	
	<h3>비활성화/활성화된 상태로 지정하기</h3>
	<div>
		<ul class="pagination">
			<li class="page-item disabled"><a href="" class="page-link">이전</a></li>
			<li class="page-item active"><a href="" class="page-link">1</a></li>
			<li class="page-item"><a href="" class="page-link">2</a></li>
			<li class="page-item"><a href="" class="page-link">3</a></li>
			<li class="page-item"><a href="" class="page-link">4</a></li>
			<li class="page-item"><a href="" class="page-link">5</a></li>
			<li class="page-item"><a href="" class="page-link">다음</a></li>
		</ul>
	</div>
	<h3>수평정렬된 페이지네이션</h3>
	<div>
		<ul class="pagination justify-content-start">
			<li class="page-item disabled"><a href="" class="page-link">이전</a></li>
			<li class="page-item active"><a href="" class="page-link">1</a></li>
			<li class="page-item"><a href="" class="page-link">2</a></li>
			<li class="page-item"><a href="" class="page-link">3</a></li>
			<li class="page-item"><a href="" class="page-link">4</a></li>
			<li class="page-item"><a href="" class="page-link">5</a></li>
			<li class="page-item"><a href="" class="page-link">다음</a></li>
		</ul>
	</div>
	<div>
		<ul class="pagination justify-content-center">
			<li class="page-item disabled"><a href="" class="page-link">이전</a></li>
			<li class="page-item active"><a href="" class="page-link">1</a></li>
			<li class="page-item"><a href="" class="page-link">2</a></li>
			<li class="page-item"><a href="" class="page-link">3</a></li>
			<li class="page-item"><a href="" class="page-link">4</a></li>
			<li class="page-item"><a href="" class="page-link">5</a></li>
			<li class="page-item"><a href="" class="page-link">다음</a></li>
		</ul>
	</div>
	<div>
		<ul class="pagination justify-content-end">
			<li class="page-item disabled"><a href="" class="page-link">이전</a></li>
			<li class="page-item active"><a href="" class="page-link">1</a></li>
			<li class="page-item"><a href="" class="page-link">2</a></li>
			<li class="page-item"><a href="" class="page-link">3</a></li>
			<li class="page-item"><a href="" class="page-link">4</a></li>
			<li class="page-item"><a href="" class="page-link">5</a></li>
			<li class="page-item"><a href="" class="page-link">다음</a></li>
		</ul>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>