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
<c:set var="menu" value="직원"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">직원 정보 수정 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">수정할 직원 정보를 입력하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="modify.do?id=100">
  				<div class="col-md-6">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="firstName" value="홍" readonly>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="lastName" value="길동" readonly>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">직종</label>
    				<select class="form-select" name="jobId">
    					<!-- 
    						jobs 테이블의 모든 직종정보를 조회해서 <option />태그를 생성한다.
    						수정할 직원의 기존 직종이 미리 선택되어 있어야 한다.
    					 -->
    					<option value=""> 직종을 선택하세요</option>
    					<option value="AD_PRES"> President (20,080 ~ 40,000 달러)</option>
    					<option value="AD_VP" selected> Administration Vice President (15,080 ~ 30,000 달러)</option>
    					<option value="AD_ASST"> Administration Assistant (3,000 ~ 6,000 달러)</option>
    					<option value="FI_MGR"> Finance Manager (8,200 ~ 16,000 달러)</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">소속 부서</label>
    				<select class="form-select" name="departmentId">
    					<!-- 
    						departments 테이블의 모든 부서정보를 조회해서 <option />태그를 생성한다.
    						수정할 직원의 기존 소속 부서가 미리 선택되어 있어야 한다.
    					 -->
    					<option value=""> 소속부서를 선택하세요</option>
    					<option value="10"> Administration</option>
    					<option value="20"> Marketing</option>
    					<option value="30" selected> Purchasing</option>
    					<option value="40"> Human Resources</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">급여</label>
    				<input type="number" class="form-control" name="salary" value="2500" >
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">커미션</label>
    				<select class="form-select" name="commissionPct">
    					<!-- 
    						수정할 직원의 커미션이미리 선택되어 있어야 한다.
    					 -->
    					<option value=""> 소속부서를 선택하세요</option>
    					<option value="0.1"> 0.1</option>
    					<option value="0.15"> 0.15</option>
    					<option value="0.2"> 0.2</option>
    					<option value="0.25"> 0.25</option>
    					<option value="0.3" selected> 0.3</option>
    					<option value="0.35"> 0.35</option>
    					<option value="0.4"> 0.4</option>
    					<option value="0.45"> 0.45</option>
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