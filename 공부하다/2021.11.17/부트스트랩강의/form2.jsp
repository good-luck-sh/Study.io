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
	<div class="row mb-3">
		<div class="col">
			<h1>레이아웃 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<form class="row g-3 border bg-light p-3">
				<div class="col-6">
					<label class="form-label">이름</label>
					<input type="text" class="form-control" name="username">
				</div>
				<div class="col-6">
					<label class="form-label">아이디</label>
					<input type="text" class="form-control" name="userid">
				</div>
				<!-- 2칸씩 짝지어서 레이아웃 폼이 만들어짐 g를 3을 주면 사이가 떨어지게 된다 -->
				<div class="col-6">
					<label class="form-label">비밀번호</label>
					<input type="text" class="form-control" name="userpassword">
				</div>
					<div class="col-6">
					<label class="form-label">비밀번호 확인</label>
					<input type="password" class="form-control" name="confirmPassword" />
				</div>
				<div class="col-6">
					<label class="form-label">우편번호</label>
					<input type="text" class="form-control" name="postalCode" />
				</div>
				<div class="col-6">
					<label class="form-label">&nbsp;</label>
					<!-- 공백을 나타내는 특수 문자열 -->
					<div class="align-middle pt-1">
						<button class="btn btn-outline-primary btn-sm">주소검색</button>
					</div>
				</div>
				<div class="col-12">
					<label class="form-label">주소</label>
					<input type="text" class="form-control" name="address">
				</div>
				<div class="col-6">
					<label class="form-label">이벤트 수신 방법</label>
					<div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="event" value="sms" checked/>
							<label class="form-check-label" > 문자메세지</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="event" value="email"/>
							<label class="form-check-label"> 이메일</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="event" value="none"/>
							<label class="form-check-label"> 거부</label>
						</div>
					</div>
				</div>
				<div class="col-6">
					<label class="form-label">제 3자 정보제공 동의</label>
					<div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" name="agree" value="sms" checked/>
							<label class="form-check-label" > 동의함</label>
						</div>
					</div>
				</div>
				
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>