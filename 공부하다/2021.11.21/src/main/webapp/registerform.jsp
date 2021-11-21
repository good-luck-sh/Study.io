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
	// include 시킨 navbar의 nav-item 중에서 페이지에 해당하는 nav-item를 active 시키기위해서 "menu"라는 이름으로 페이지이름을 속성으로 저장한다.
	// pageContext에 menu라는 이름으로 설정한 속성값은 navbar.jsp의 6번째 라인에서 조회해서 navbar의 메뉴들 중 하나를 active 시키기 위해서 읽어간다.
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
	// register.jsp에서는 회원가입에 실패한 경우 브라우져에게 재요청 URL(registerform.jsp?login=실패원인)을 응답으로 보낸다.
	
	// registerform.jsp에서는 요청객체에서 요청파라미터값 error을 조회한다.
	// 회원가입 링크를 눌러서 registerform.jsp를 요청하는 경우에는 요청파라미터 error값이 존재하지 않는다.
	// 회원가입에 실패한 경우에만 registerform.jsp를 요청할 때 생성한 요청객체에 요청파라미터로 error값이 존재한다.
	String error = request.getParameter("error");
%>
<%
	if ("id-exists".equals(error)) {					// register.jsp에서 회원가입을 처리할 때 이미 사용중이 아이디로 밝혀졌다.
%>
			<div class="alert alert-danger">
				<strong>회원가입 실패</strong> 다른 사용자가 사용중인 아이디입니다.
			</div>
<%
	} else if ("email-exists".equals(error)) {			// register.jsp에서 회원가입을 처리할 때 이미 사용중이 이메일로 밝혀졌다.
%>
			<div class="alert alert-danger">
				<strong>회원가입 실패</strong> 다른 사용자가 사용중인 이메일입니다.
			</div>
<%
	}
%>
			<!-- 
				회원가입 정보 입력폼이다.
				id, password, name, tel, email 정보를 입력받아서 register.jsp로 제출한다.
				register.jsp에서 회원가입을 처리하고, 오류가 발생하면 이 페이지를 재요청하는 URL을 응답으로 보낸다.
				register.jsp에서 회원가입이 완료되면, index.jsp를 재요청하는 URL을 클라이언트에 응답으로 보낸다. 
			 -->
			<form class="border p-3 bg-light" method="post" action="register.jsp">
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
			<img class="img-fluid m-2" src="resources/images/banners/banner1.png">
			<img class="img-fluid m-2" src="resources/images/banners/banner2.jpg">
			<img class="img-fluid m-2" src="resources/images/banners/banner3.png">
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>