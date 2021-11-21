<%@page import="com.sample.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>커뮤니티 게시판</title>
</head>
<body>
<%
	// include 시킨 navbar의 nav-item 중에서 페이지에 해당하는 nav-item를 active 시키기위해서 "menu"라는 이름으로 페이지이름을 속성으로 저장한다.
	// pageContext에 menu라는 이름으로 설정한 속성값은 navbar.jsp의 6번째 라인에서 조회해서 navbar의 메뉴들 중 하나를 active 시키기 위해서 읽어간다.
	pageContext.setAttribute("menu", "home");
%>
<%@ include file="common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<div class="p-5 mb-4 bg-light rounded-3">
				<div class="container-fluid py-5">
					<h1 class="disply-5 fw-bold">커뮤니티 게시판</h1>
					<p class="fs-4">커뮤니티에서 글을 게시하고, 공유해보세요</p>
					
<%
	// 위에서 포함시킨 navbar.jsp에서 loginUserInfo 변수에 인증된 사용자 정보가 포함되어 있는지 여부에 따라서 아래의 내용을 다르게 표시한다.
	if (loginUserInfo == null) {
%>
					<div class="mt-3">
						<a href="loginform.jsp" class="btn btn-primary btn-lg">로그인</a>
						<a href="registerform.jsp" class="btn btn-primary btn-lg">회원가입</a>
					</div>
<%
	} else {
%>
					<div class="mt-3">
						<p class="fs-4"><strong class="text-primary"><%=loginUserInfo.getName() %></strong>님 환영합니다.</p>
						<p class="fs-4">다양한 게시글을 확인해보세요</p>						
					</div>
<%
	}
%>
				</div>
			</div>
		</div>
    </div>

<%
	// 회원가입이 완료 되었을 때 표시되는 컨텐츠다.
	// reguster.jsp에서 회원가입이 완료되면 브라우저에 재요청 URL(index.jsp?register=completed)을 응답으로 보낸다.(register.jsp의 53번째 라인 참조)
	// 브라우저는 응답으로 받은 재요청 URL로 홈페이지를 다시 요청할 때 요청파라미터값으로 register=completed를 index.jsp로 전달한다.
	// index.jsp에서는 register라는 이름으로 요청파라미터값을 조회해서, 그 값이 "completed"인 경우 아래 컨텐츠를 응답으로 보낸다.
	String register = request.getParameter("register");

	if ("completed".equals(register)) {
%>
	<div class="row mb-3">
		<div class="col">
			<div class="alert alert-success">
				<strong>회원가입 완료</strong> 회원가입이 완료되었습니다.
				<p>로그인 후 커뮤니티의 다양한 서비스를 사용해보세요!!</p>
			</div>
		</div>
	</div>
<%
	}
%>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>