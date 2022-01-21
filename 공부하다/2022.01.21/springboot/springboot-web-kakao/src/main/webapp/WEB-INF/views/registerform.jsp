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
	<!-- 카카오 로그인지원 자바스크립트 라이브러리를 포함시킨다. -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<title>애플리케이션</title>
</head>
<body>
<div class="container mt-3">  
	<c:set var="menu" value="register"></c:set>
	<%@ include file="common/nav.jsp" %> 
	<div class="row">
		<div class="col">
    		<p>사용자 정보를 입력해서 가입하세요</p>
		</div>
	</div> 
    <div class="row mb-3">
    	<div class="col-7">
    		<%-- 
    			회원가입 중 오류가 발생하면 아래 경고창에 표시된다.
    			오류 메세지는 RequestAttributes의 addFlashAttribute(String name, Object value) 메소드를 사용해서 전달한다.
    		 --%>
    		<c:if test="${not empty error }">
    			<div class="alert alert-danger">
    				${error }
    			</div>
    		</c:if>
    		<form class="border p-3 bg-light" method="post" action="register">
    			<div class="mb-3">
    				<label class="form-label">아이디</label>
    				<input type="text" class="form-control" name="id"/>
    			</div>
    			<div class="mb-3">
    				<label class="form-label">비밀번호</label>
    				<input type="password" class="form-control" name="password"/>
    			</div>
    			<div class="mb-3">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="name"/>
    			</div>
    			<div class="mb-3">
    				<label class="form-label">이메일</label>
    				<input type="text" class="form-control" name="email"/>
    			</div>
    			<div class="mb-3">
    				<label class="form-label">연령</label>
    				<select class="form-select" name="age">
    					<option value="0"> 10대 미만( ~ 10)</option>
    					<option value="10"> 10대(10 ~ 19)</option>
    					<option value="20" selected> 20대(20 ~ 29)</option>
    					<option value="30"> 30대(30 ~ 39)</option>
    					<option value="40"> 40대(40 ~ 49)</option>
    					<option value="50"> 50대(50 ~ 59)</option>
    					<option value="60"> 60대(60 ~ 69)</option>
    					<option value="70"> 70대 이상(70 ~)</option>
    				</select>
    			</div>
    			<div class="mb-3">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender" value="female" checked>
						<label class="form-check-label">여자</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender" value="male">
						<label class="form-check-label" >남자</label>
					</div>
    			</div>
    			<div class="mb-1 text-end">
    				<a href="/register" class="btn btn-secondary">회원가입</a>
    				<button class="btn btn-primary">로그인</button>
    			</div>
    		</form>
    	</div>
    	<div class="col-5">
			<div class="mb-4">
				<img src="/resources/images/banner4.jpg" class="img-thumbnail"/>
			</div>
			<div class="mb-4">
				<img src="/resources/images/banner3.jpg" class="img-thumbnail"/>
			</div>
			<div class="mb-4">
				<img src="/resources/images/banner2.jpg" class="img-thumbnail"/>
			</div>
			<div class="mb-4">
				<img src="/resources/images/banner1.png" class="img-thumbnail"/>
			</div>
		</div>
    </div>
</div>
</body>
</html>