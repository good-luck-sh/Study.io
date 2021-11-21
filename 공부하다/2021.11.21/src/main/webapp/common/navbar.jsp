<%@page import="com.sample.board.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// navbar.jsp를 include하는 페이지에서 pageContext에 "menu"로 저장한 속성값을 읽어온다.
	// navbar.jsp를 include하는 페이지에서는 navbar의 nav-item 중에서 페이지에 해당하는 nav-item를 active 시키기위해서 pageContext에 pageContext.setAttribute("menu", "페이지명")을 속성으로 저장한다.
	String menu = (String)pageContext.getAttribute("menu");
	
	// HttpSession에 "LOGIN_USER_INFO"로 저장한 속성값을 읽어온다.
	// HttpSession에 "LOGIN_USER_INFO"로 인증된 사용자정보(User객체)를 저장하는 곳은 login.jsp다. (login.jsp의 54번째 라인 참조)
	// navbar.jsp에서는 로그인 여부에 따라서 로그인/회원가입 혹은 마이페이지/로그아웃을 표시해야 하기 때문에 HttpSesssion에 "LOGIN_USER_INFO"로 저장한 로그인된 사용자 정보가 필요하다.
	User loginUserInfo = (User)session.getAttribute("LOGIN_USER_INFO");
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
<%
	if (loginUserInfo == null) {	// HttpSession에 인증된 사용자 정보가 없는 경우, 로그인 하기 전 상태
%>
				<li class="nav-item"><a href="/board-app/loginform.jsp" class="nav-link <%="login".equals(menu) ? "active" : "" %>" >로그인</a></li>
				<li class="nav-item"><a href="/board-app/registerform.jsp" class="nav-link <%="register".equals(menu) ? "active" : "" %>">회원가입</a></li>
<%
	} else {						// HttpSession에 인증된 사용자 정보가 존재하는 경우, 로그인 완료한 상태
%>
				<li class="nav-item"><a href="/board-app/user/detail.jsp" class="nav-link text-white <%="user".equals(menu) ? "active" : "" %>""><%=loginUserInfo.getName() %> 마이페이지</a></li>
				<li class="nav-item"><a href="/board-app/logout.jsp" class="nav-link">로그아웃</a></li>
<%
	}
%>
			</ul>
		</div>
	</div>
</nav>