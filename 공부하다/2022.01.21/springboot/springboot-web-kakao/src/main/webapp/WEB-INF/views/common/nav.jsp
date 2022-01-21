<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<div class="container-fluid">
		<ul class="navbar-nav me-auto">
			<li class="nav-item"><a class="nav-link ${menu eq 'home' ? 'active' : '' }" href="/">홈</a></li>
		</ul>
		<c:if test="${not empty LOGIN_USER }">
			<span class="navbar-text"><strong class="fw-bold text-white">${LOGIN_USER.name }</strong>님 환영합니다.</span>
		</c:if>
		<ul class="navbar-nav">
			<c:if test="${empty LOGIN_USER }">
				<li class="nav-item"><a class="nav-link ${menu eq 'login' ? 'active' : '' }" href="/login">로그인</a></li>
			<li class="nav-item"><a class="nav-link ${menu eq 'register' ? 'active' : '' }" href="/register">회원가입</a></li>
			</c:if>
			<c:if test="${not empty LOGIN_USER }">
				<c:choose>
					<c:when test="${LOGIN_USER.loginType eq 'normal' }">
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>							
					</c:when>
					<c:when test="${LOGIN_USER.loginType eq 'kakao' }">
						<li class="nav-item"><a class="nav-link" href="/logout" id="nav-item-kakao-logout">로그아웃</a></li>	
					</c:when>
				</c:choose>	
			</c:if>
		</ul>
	</div>
</nav>
<script>
$(function() {
	// 카카오 로그아웃 처리
	$("#nav-item-kakao-logout").click(function(event) {
		event.preventDefault();
		Kakao.init('9f3a5b1dadaeae93a5ebb2ab206b6506');
		
		if (!Kakao.Auth.getAccessToken()) {
			location.href = "/";
			return;
		}
		Kakao.Auth.logout(function() {
			location.href = '/logout';
		});
	});
})
</script>
