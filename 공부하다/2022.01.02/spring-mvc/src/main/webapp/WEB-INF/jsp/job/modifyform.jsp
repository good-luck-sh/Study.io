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
			<h1 class="fs-4">직종 정보 수정 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">직종정보를 수정하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="modify.do">
  				<div class="col-md-6">
    				<label class="form-label">직종 아이디</label>
    				<input type="text" class="form-control" name="id" value="AD_PRES">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">직종 제목</label>
    				<input type="text" class="form-control" name="title" value="President">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">최저 급여</label>
    				<select class="form-select" name="minSalary">
    					<!-- 
    						jobs 테이블의 최저급여를 오름차순으로 중복없이 조회해서 <option />태그를 생성하도록 한다
    						수정할 직종의 최저급여가 선택되어 있어야 한다.
    					 -->
    					<option value="2008"> 2,008 달러</option>
    					<option value="2500"> 2,500 달러</option>
    					<option value="3000"> 3,000 달러</option>
    					<option value="4000"> 4,000 달러</option>
    					<option value="4200"> 4,200 달러</option>
    					<option value="4500"> 4,500 달러</option>
    					<option value="5500"> 5,500 달러</option>
    					<option value="6000"> 6,000 달러</option>
    					<option value="8000"> 8,000 달러</option>
    					<option value="8200"> 8,200 달러</option>
    					<option value="9000"> 9,000 달러</option>
    					<option value="10000"> 10,000 달러</option>
    					<option value="15000"> 14,000 달러</option>
    					<option value="20080" selected> 20,080 달러</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">최고 급여</label>
    				<select class="form-select" name="maxSalary">
    					<!-- 
    						jobs 테이블의 최고급여를 오름차순으로 중복없이 조회해서 <option />태그를 생성하도록 한다.
    						수정할 직종의 최고급여가 선택되어 있어야 한다.
    					 -->
    					<option value="5000"> 5,000 달러</option>
    					<option value="5500"> 5,500 달러</option>
    					<option value="6000"> 6,000 달러</option>
    					<option value="8500"> 8,500 달러</option>
    					<option value="9000"> 9,000 달러</option>
    					<option value="10000"> 10,000 달러</option>
    					<option value="10500"> 10,500 달러</option>
    					<option value="12008"> 12,008 달러</option>
    					<option value="15000"> 15,000 달러</option>
    					<option value="16000"> 16,000 달러</option>
    					<option value="20080"> 20,080 달러</option>
    					<option value="30000"> 30,000 달러</option>
    					<option value="40000" selected> 40,000 달러</option>
    				</select>
  				</div>
  				<div class="col-12 text-end">
  					<button type="submit" class="btn btn-primary">수정</button>
  				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>