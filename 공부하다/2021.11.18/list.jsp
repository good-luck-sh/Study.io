<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>커뮤니티 게시판::리스트</title>
</head>
<body>
<%
	pageContext.setAttribute("menu", "board");
%>
<%@ include file="../common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-3">게시글 목록</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<thead>
					<tr class="d-flex">
						<th class="col-1">번호</th>
						<th class="col-5">제목</th>
						<th class="col-2">작성자</th>
						<th class="col-1">추천수</th>
						<th class="col-1">조회수</th>
						<th class="col-2">등록일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="text-center" colspan="6">게시글이 존재하지 않습니다.</td>
					</tr>
					<tr class="d-flex">
						<td class="col-1">100</td>
						<td class="col-5">게시글 작성 연습</td>
						<td class="col-2">홍길동</td>
						<td class="col-1">100</td>
						<td class="col-1">2000</td>
						<td class="col-2">2021-11-18</td>
					</tr>
					<tr class="d-flex">
						<td class="col-1">100</td>
						<td class="col-5">게시글 작성 연습</td>
						<td class="col-2">홍길동</td>
						<td class="col-1">100</td>
						<td class="col-1">2000</td>
						<td class="col-2">2021-11-18</td>
					</tr>
				</tbody>				
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-6 offset-3">
			<nav>
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link">이전</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">다음</a></li>
				</ul>
			</nav>
		</div>
		<div class="col-3 text-end">
			<a href="form.jsp" class="btn btn-outline-primary">새 글</a>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>