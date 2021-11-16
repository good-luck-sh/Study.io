<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>부트스트랩</title>
</head>
<body>
<div class ="container">
	<h1>경고창</h1>
	
	<div class="row">
		<div class="col">
			<h4>일반 경고창</h4>
			<div class="alert alert-primary">
				<strong>일반</strong> 알림 메세지
			</div>
			<div class="alert alert-success">
				<strong>성공</strong> 알림 메세지
			</div>
			<div class="alert alert-info">
				<strong>정보</strong> 알림 메세지
			</div>
			<div class="alert alert-warning">
				<strong>경고</strong> 알림 메세지
			</div>
			<div class="alert alert-danger">
				<strong>오류</strong> 알림 메세지
				<!-- 로그인 비밀번호틀릴경우 알림메세지를 이용함 -->
			</div>
		</div>
		<div class="col">
			<h4>닫기가 가능한 경고창</h4>
			<div class="alert alert-success alert-dismissible">
				<button class="btn-close" data-bs-dismiss="alert"></button>
				<!-- java script 내부적으로 사용하는 data-bs-dismiss이다. -->
				<strong>로그인 성공!</strong> 로그인이 완료되었습니다. 
			</div>
			<div class="alert alert-danger alert-dismissible">
				<button class="btn-close" data-bs-dismiss="alert"></button>
				<!-- java script 내부적으로 사용하는 data-bs-dismiss이다. -->
				<strong>로그인 실패!</strong> 아이디 혹은 비밀번호가 올바르지 않습니다.
			</div>
			<div class="alert alert-primary alert-dismissible fade show">
				<button class="btn-close" data-bs-dismiss="alert"></button>
				<!-- java script 내부적으로 사용하는 data-bs-dismiss이다. -->
				<strong>등록완료</strong>회원등록이 완료되었습니다.
				<!-- fade show는 사라질때 천천히 사라진다 애니메이션의 효과를 주는것이다.-->
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>