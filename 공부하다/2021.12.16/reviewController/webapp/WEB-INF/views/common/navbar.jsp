<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3">
	<div class="container">
		<a class="navbar-brand" href="/model2-todo/home.hta">Todo 애플리케이션</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="/model2-todo/home.hta">홈</a></li>
				<%--
					HttpSession객체에 loginUser 라는 속성명으로 조회되는 객체가 존재하는지를 체크해서 
					로그인 전/ 로그인 후 메뉴가 다르게 노출되도록 한다.
					
					${not empty loginUser}는 loginUser속성명으로 조회했을 때 객체가 존재할 때 true를 반환한다.	-로그인이 완료된 경우
					${empty loginUser}는 loginUser속성명으로 조회했을 때 객체가 존재하지 않으면 true를 반환한다. - 로그인하지 않은 경우
				 --%>
				<c:if test="${not empty loginUser }">
					<li class="nav-item"><a class="nav-link" href="/model2-todo/todo/list.hta">일정 목록</a></li>
					<li class="nav-item"><a class="nav-link" href="/model2-todo/todo/form.hta">일정 등록</a></li>
				</c:if>
			</ul>
			<ul class="navbar-nav">
				<c:if test="${empty loginUser }">
					<li class="nav-item"><a class="nav-link" href="/model2-todo/loginform.hta">로그인</a></li>
				</c:if>
				<c:if test="${not empty loginUser }">
					<li class="nav-item"><a class="nav-link" href="/model2-todo/logout.hta"><strong>${loginUser.name }</strong>님 로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>