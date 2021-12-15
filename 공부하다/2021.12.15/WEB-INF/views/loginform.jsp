<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>로그인</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<div class="container mb-5">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-5 border p-3 shadow-sm">로그인</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-8">
			<c:if test="${param.error eq 'notfound' }">
				<div class="alert alert-danger mb-3">
					<strong>아이디 오류</strong> 아이디에 해당하는 사용자가 존재하지 않습니다.
				</div>
			</c:if>
			<c:if test="${param.error eq 'mismatch' }">
				<div class="alert alert-danger mb-3">
					<strong>비밀번호 오류</strong> 비밀번호가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${param.error eq 'required' }">
				<div class="alert alert-danger mb-3">
					<strong>로그인 오류</strong> 로그인 후 이용할 수 있는 서비스입니다.
				</div>
			</c:if>
			<div class="card">
				<div class="card-header">로그인 폼</div>
				<div class="card-body">
					<p class="card-text text-muted">아이디와 비밀번호를 입력하고 로그인버튼을 클릭하세요</p>
					<form method="post" action="login.hta"  novalidate>
						<div class="mb-3">
							<label class="form-label" for="id-field">아이디</label> 
							<input type="email" class="form-control" id="id-field" name="id" />
						</div>
						<div class="mb-3">
							<label class="form-label" for="password-field">비밀번호</label> 
							<input type="password" class="form-control" id="password-field" name="password" />
						</div>
						<div class="text-end">
							<a href="home.hta" class="btn btn-secondary">취소</a>
							<button type="submit" class="btn btn-primary">로그인</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-4"></div>
	</div>
</div>
<%@ include file="common/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>