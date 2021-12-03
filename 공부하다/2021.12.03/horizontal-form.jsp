<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>폼 샘플::수평 폼</title>
</head>
<body>
<%@ include file="../common/header.jsp"%>
<div class="container mb-5">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">부트스트랩 수평 폼</h1>
		</div>
	</div> 
	<div class="row mb-3">
		<div class="col">
			<form class="border p-3 bg-light">
				<div class="row mb-3">
					<label class="col-2 col-form-label text-end">이름</label>
					<div class="col-4">
						<input type="text" class="form-control" name="username" />
					</div>
					<label class="col-2 col-form-label text-end">아이디</label>
					<div class="col-4">
						<input type="text" class="form-control" name="userid" />
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-2 col-form-label text-end">비밀번호</label>
					<div class="col-4">
						<input type="password" class="form-control" name="password" />
					</div>
					<label class="col-2 col-form-label text-end">비밀번호 확인</label>
					<div class="col-4">
						<input type="password" class="form-control" name="confirmPassword" />
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-2 col-form-label text-end">고용형태</label>
					<div class="col-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="jobType" value="정규직" checked/>
							<label class="form-check-label" > 정규직</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="jobType" value="비정규직" />
							<label class="form-check-label" > 비정규직</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="jobType" value="인턴" />
							<label class="form-check-label" > 인턴</label>
						</div>
					</div>
					<label class="col-2 col-form-label text-end">경력사항</label>
					<div class="col-4">
						<select class="form-select" name="career">
							<option value="" selected disabled> 경력사항을 선택하세요</option>
							<option value="0"> 신입</option>
							<option value="3"> 3년 이상</option>
							<option value="5"> 5년 이상</option>
							<option value="10"> 10년 이상</option>
						</select>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col text-end">
						<button type="button" class="btn btn-primary">등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>