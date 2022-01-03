<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title></title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<c:set var="menu" value="직종"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">직종 정보 등록 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">새로 등록할 직종정보를 입력하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="insert.do">
  				<div class="col-md-6">
    				<label class="form-label">직종 아이디</label>
    				<input type="text" class="form-control" name="id">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">직종 제목</label>
    				<input type="text" class="form-control" name="title">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">최저 급여</label>
    				<select class="form-select" name="minSalary">
    					<option value=""> 최저 급여를 선택하세요</option>
    					<option value="2000"> 2,000 달러</option>
    					<option value="3000"> 3,000 달러</option>
    					<option value="4000"> 4,000 달러</option>
    					<option value="5000"> 5,000 달러</option>
    					<option value="6000"> 6,000 달러</option>
    					<option value="7000"> 7,000 달러</option>
    					<option value="8000"> 8,000 달러</option>
    					<option value="9000"> 9,000 달러</option>
    					<option value="10000"> 10,000 달러</option>
    					<option value="11000"> 11,000 달러</option>
    					<option value="12000"> 12,000 달러</option>
    					<option value="13000"> 13,000 달러</option>
    					<option value="14000"> 14,000 달러</option>
    					<option value="15000"> 15,000 달러</option>
    					<option value="16000"> 16,000 달러</option>
    					<option value="17000"> 17,000 달러</option>
    					<option value="18000"> 18,000 달러</option>
    					<option value="19000"> 19,000 달러</option>
    					<option value="20000"> 20,000 달러</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">최고 급여</label>
    				<select class="form-select" name="maxSalary">
    					<option value=""> 최고 급여를 선택하세요</option>
    					<option value="4000"> 4,000 달러</option>
    					<option value="6000"> 6,000 달러</option>
    					<option value="8000"> 8,000 달러</option>
    					<option value="10000"> 10,000 달러</option>
    					<option value="12000"> 12,000 달러</option>
    					<option value="14000"> 14,000 달러</option>
    					<option value="16000"> 16,000 달러</option>
    					<option value="18000"> 18,000 달러</option>
    					<option value="10000"> 20,000 달러</option>
    					<option value="22000"> 22,000 달러</option>
    					<option value="24000"> 24,000 달러</option>
    					<option value="26000"> 26,000 달러</option>
    					<option value="28000"> 28,000 달러</option>
    					<option value="30000"> 30,000 달러</option>
    					<option value="32000"> 32,000 달러</option>
    					<option value="34000"> 34,000 달러</option>
    					<option value="36000"> 36,000 달러</option>
    					<option value="38000"> 38,000 달러</option>
    					<option value="40000"> 40,000 달러</option>
    				</select>
  				</div>
  				<div class="col-12 text-end">
  					<button type="submit" class="btn btn-primary">등록</button>
  				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>