<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<div class="container-fluid">
		<ul class="navbar-nav me-auto">
			<li class="nav-item"><a class="nav-link ${menu eq 'home' ? 'active' : '' }" href="/">홈</a></li>
			
			<!-- 
				ADMIN 권한을 가진 사용자만 아래 메뉴가 표시된다.
			 -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item"><a class="nav-link ${menu eq 'admin' ? 'active' : '' }" href="/admin/main">관리자</a></li>
			</sec:authorize>
			
			<!-- 
				ADMIN 혹은 USER 권한을 가진 사용자만 아래 메뉴가 표시된다.
			 -->
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
				<li class="nav-item"><a class="nav-link ${menu eq 'book' ? 'active' : '' }" href="/book/list">책</a></li>
			</sec:authorize>
		</ul>
		
		<!-- 
			인증된 사용자는 isAuthenticated()가 true를 반환한다.
		 -->
		<sec:authorize access="isAuthenticated()">
			<%--
				<sec:authentication />태그는 인증된 사용자 정보를 제공한다
			 --%>
			<sec:authentication property="principal" var="user"/>
			<span class="navbar-text" ><strong class="fw-bold text-white">${user.nickname }</strong>님 환영합니다.</span>
		</sec:authorize>
		
		<ul class="navbar-nav">
			<!-- 
				인증받지 않은 사용자는 isAuthenticated()가 false를 반환한다.
			 -->
			<sec:authorize access="!isAuthenticated()">
				<li class="nav-item"><a class="nav-link ${menu eq 'login' ? 'active' : '' }" href="/login">로그인</a></li>
				<li class="nav-item"><a class="nav-link ${menu eq 'register' ? 'active' : '' }" href="/register">회원가입</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>							
			</sec:authorize>
		</ul>
	</div>
</nav>