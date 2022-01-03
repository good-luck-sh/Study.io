<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title></title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<c:set var="menu" value="직종"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">직종 목록 <a class="btn btn-outline-primary btn-sm float-end" href="insert.do">새 직종등록</a></h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<colgroup>
					<col width="20%"/>
					<col width="30%"/>
					<col width="20%"/>
					<col width="20%"/>
					<col width="10%"/>
				</colgroup>
				<thead>
					<tr>
						<th>아이디</th>
						<th>제목</th>
						<th>최저 급여</th>
						<th>최고 급여</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>AD_PRES</td>
						<td>President</td>
						<td>20,080 달러</td>
						<td>40,000 달러</td>
						<td><a href="modify.do?id=AD_PRES" class="btn btn-outline-primary btn-sm">수정</a></td>
					</tr>
					<tr>
						<td>AD_PRES</td>
						<td>President</td>
						<td>20,080 달러</td>
						<td>40,000 달러</td>
						<td><a href="modify.do?id=AD_PRES" class="btn btn-outline-primary btn-sm">수정</a></td>
					</tr>
					<tr>
						<td>AD_PRES</td>
						<td>President</td>
						<td>20,080 달러</td>
						<td>40,000 달러</td>
						<td><a href="modify.do?id=AD_PRES" class="btn btn-outline-primary btn-sm">수정</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>