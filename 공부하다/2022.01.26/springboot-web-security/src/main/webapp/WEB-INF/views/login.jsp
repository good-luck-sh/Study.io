<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<title>애플리케이션</title>
</head>
<body>
<div class="container mt-3">  
	<c:set var="menu" value="login"></c:set>
	<%@ include file="common/nav.jsp" %>  
    <div class="row mb-3">
    	<div class="col-6">
    		<p>아이디 비밀번호를 입력해서 로그인하세요</p>
    		<%-- 
    			일반 로그인 처리중 중 오류가 발생하면 아래 경고창에 표시된다.
    			오류 메세지는 RequestAttributes의 addFlashAttribute(String name, Object value) 메소드를 사용해서 전달한다.
    		 --%>
    		<c:if test="${not empty param.error }">
    			<div class="alert alert-danger">
    				${error }
    			</div>
    		</c:if>
    		<form class="border p-3 bg-light" method="post" action="login">
    			<div class="mb-3">
    				<label class="form-label">아이디</label>
    				<input type="text" class="form-control" name="username"/>
    			</div>
    			<div class="mb-3">
    				<label class="form-label">비밀번호</label>
    				<input type="password" class="form-control" name="password"/>
    			</div>
    			<div class="mb-1 text-end">
    				<a href="/register" class="btn btn-secondary">회원가입</a>
    				<button class="btn btn-primary">로그인</button>
    			</div>
    		</form>
    	</div>
    </div>
</div>
</body>
</html>