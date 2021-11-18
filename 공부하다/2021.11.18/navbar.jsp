<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String menu = (String)pageContext.getAttribute("menu");
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<div class="container">
		<a class="navbar-brand" href="/board-app/index.jsp">커뮤니티 게시판</a>
		<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbar-1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar-1">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a href="/board-app/index.jsp" class="nav-link <%="home".equals(menu) ? "active" : "" %>">홈</a></li>
				<li class="nav-item"><a href="/board-app/board/list.jsp" class="nav-link <%="board".equals(menu) ? "active" : "" %>">게시판</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="/board-app/loginform.jsp" class="nav-link <%="login".equals(menu) ? "active" : "" %>" >로그인</a></li>
				<li class="nav-item"><a href="/board-app/logout.jsp" class="nav-link">로그아웃</a></li>
				<li class="nav-item"><a href="/board-app/registerform.jsp" class="nav-link <%="register".equals(menu) ? "active" : "" %>">회원가입</a></li>
			</ul>
		</div>
	</div>
</nav>