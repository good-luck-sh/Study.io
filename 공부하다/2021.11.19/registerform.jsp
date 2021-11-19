<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>커뮤니티 게시판::가입폼</title>
</head>
<body>
<%
	pageContext.setAttribute("menu", "register");
%>
<%@ include file="common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-3">회원가입 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-5">
<%
	String failReason = request.getParameter("fail");
%>
<%
	if("id".equals(failReason)) {
%>
	<div class="alert alert-danger">
		<strong>회원가입 실패</strong> 이미 사용중인 아이디 입니다.
	</div>
<% 
	}
%>
<%
	if("email".equals(failReason)){
%>		
	<div class="alert alert-danger">
		<strong>회원가입 실패</strong> 다른 사용자가 사용중인 이메일 입니다.
	</div>
<% 
	}
%>		<form class="border p-3 bg-light" method="post" action="register.jsp">
				<div class="mb-3">
					<label class="form-label" for="user-id">아이디</label>
					<input type="text" class="form-control" name="id" id="user-id">
				</div>
				<div class="mb-3">
					<label class="form-label" for="user-password">비밀번호</label>
					<input type="password" class="form-control" name="password" id="user-password">
				</div>
				<div class="mb-3">
					<label class="form-label" for="user-name">이름</label>
					<input type="text" class="form-control" name="name" id="user-name">
				</div>
				<div class="mb-3">
					<label class="form-label" for="user-tel">전화번호</label>
					<input type="text" class="form-control" name="tel" id="user-tel">
				</div>
				<div class="mb-3">
					<label class="form-label" for="user-email">이메일</label>
					<input type="text" class="form-control" name="email" id="user-email">
				</div>
				<div class="mb-3 text-end">
					<button type="submit" class="btn btn-primary">회원가입</button>
				</div>
			</form>
		</div>
		<div class="col-7">
			<img class="img-fluid m-2" src="../resources/images/banners/banner1.png">
			<img class="img-fluid m-2" src="../resources/images/banners/banner2.jpg">
			<img class="img-fluid m-2" src="../resources/images/banners/banner3.png">
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>