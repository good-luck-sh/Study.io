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
<c:set var="menu" value="직원"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">직원 목록 <a class="btn btn-outline-primary btn-sm float-end" href="insert.do">새 직원등록</a></h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<colgroup>
					<col width="10%"/>
					<col width="25%"/>
					<col width="40%"/>
					<col width="15%"/>
					<col width="10%"/>
				</colgroup>
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>직종아이디</th>
						<th>소속부서명</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>100</td>
						<td>Steven King</td>
						<td>AD_PRES (Administration Vice President)</td>
						<td>Executive (90)</td>
						<td>
							<a href="modify.do?id=100" class="btn btn-outline-warning btn-sm">수정</a>
							<a href="detail.do?id=100" class="btn btn-outline-primary btn-sm">상제</a>
						</td>
					</tr>
					<tr>
						<td>100</td>
						<td>Steven King</td>
						<td>AD_PRES (Administration Vice President)</td>
						<td>Executive (90)</td>
						<td>
							<a href="modify.do?id=100" class="btn btn-outline-warning btn-sm">수정</a>
							<a href="detail.do?id=100" class="btn btn-outline-primary btn-sm">상제</a>
						</td>
					</tr>
					<tr>
						<td>100</td>
						<td>Steven King</td>
						<td>AD_PRES (Administration Vice President)</td>
						<td>Executive (90)</td>
						<td>
							<a href="modify.do?id=100" class="btn btn-outline-warning btn-sm">수정</a>
							<a href="detail.do?id=100" class="btn btn-outline-primary btn-sm">상제</a>
						</td>
					</tr>
					<tr>
						<td>100</td>
						<td>Steven King</td>
						<td>AD_PRES (Administration Vice President)</td>
						<td>Executive (90)</td>
						<td>
							<a href="modify.do?id=100" class="btn btn-outline-warning btn-sm">수정</a>
							<a href="detail.do?id=100" class="btn btn-outline-primary btn-sm">상제</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>