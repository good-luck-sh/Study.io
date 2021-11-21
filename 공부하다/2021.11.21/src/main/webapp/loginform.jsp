<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>커뮤니티 게시판::로그인폼</title>
</head>
<body>
<%
	// include 시킨 navbar의 nav-item 중에서 페이지에 해당하는 nav-item를 active 시키기위해서 "menu"라는 이름으로 페이지이름을 속성으로 저장한다.
	// pageContext에 menu라는 이름으로 설정한 속성값은 navbar.jsp의 6번째 라인에서 조회해서 navbar의 메뉴들 중 하나를 active 시키기 위해서 읽어간다.
	pageContext.setAttribute("menu", "login");
%>
<%@ include file="common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-3">로그인 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-5">
<%
	// login.jsp에서는 사용자 인증에 실패한 경우 브라우져에게 재요청 URL(loginform.jsp?login=실패원인)을 응답으로 보낸다.
	// 로그인이 후 사용가능한 JSP페이지를 로그인하지 않고 요청했을 때도 브라우져에게 재요청 URL(loginform.jsp?login=login-required)을 응답으로 보낸다.
	
	// loginform.jsp에서는 요청객체에서 요청파라미터값 error을 조회한다.
	// 로그인 링크를 눌러서 loginform.jsp를 요청하는 경우에는 요청파라미터 error값이 존재하지 않는다.
	// 로그인에 실패한 경우, 로그인이 필요한 JSP를 로그인없이 이용한 경우에만 loginform.jsp를 요청할 때 생성한 요청객체에 요청파라미터로 error값이 존재한다.
	String error = request.getParameter("error");
	
	if ("empty".equals(error)) {								// login.jsp에서 사용자 인증처리를 할 때 id와 password값이 비어 있었다.
%>
			<div class="alert alert-danger">
				<strong>로그인 실패!!</strong> 아이디와 비밀번호는 필수입력값입니다.
			</div>
<%
	} else if ("notfound-user".equals(error)) {					// login.jsp에서 사용자 인증처리를 할 때 id에 해당하는 회원정보가 검색되지 않았다.
%>
			<div class="alert alert-danger">
				<strong>로그인 실패!!</strong> 회원정보가 존재하지 않습니다.
			</div>
<%	
	} else if ("mismatch-password".equals(error)) {			// login.jsp에서 사용자 인증처리를 회원가입시 입력한 비밀번호와 로그인시 입력한 비밀번호가 일치하지 않았다.
%>
			<div class="alert alert-danger">
				<strong>로그인 실패!!</strong> 비밀번호가 일치하지 않습니다.
			</div>
<%		
	} else if("login-required".equals(error)) {				// 로그인 후 사용가능한 JSP 페이지를 로그인없이 요청했다.
%>
			<div class="alert alert-danger">
				<strong>로그인 필수!!</strong> 로그인이 필요한 페이지를 요청하였습니다.
			</div>
<%
	}
%>
			<!-- 
				로그인 정보 입력폼이다.
				id와 password를 입력받아서 login.jsp로 제출한다.
				login.jsp에서 사용자인증을 처리하고, 사용자 인증 중 오류가 발생하면 이 페이지를 재요청하는 URL을 응답으로 보낸다.
				login.jsp에서 사용자인증이 완료되면 사용자 인증을 요청한 클라이언트 전용의 HttpSession객체에 사용자 인증이 완료된 사용자정보(User객체)를 "LOGIN_USER_INFO" 로 저장한다. 
			 -->
			<form class="border p-3 bg-light" method="post" action="login.jsp">
				<div class="mb-3">
					<label class="form-label" for="user-id">아이디</label>
					<input type="text" class="form-control" name="id" id="user-id">
				</div>
				<div class="mb-3">
					<label class="form-label" for="user-password">비밀번호</label>
					<input type="password" class="form-control" name="password" id="user-password">
				</div>
				<div class="mb-3 text-end">
					<button type="submit" class="btn btn-primary">로그인</button>
				</div>
			</form>
		</div>
		<div class="col-7">
			<img class="img-fluid m-2" src="resources/images/banners/banner1.png">
			<img class="img-fluid m-2" src="resources/images/banners/banner2.jpg">
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>