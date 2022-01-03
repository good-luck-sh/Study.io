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
			<h1 class="fs-4">신규 직원 정보 등록 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">새로 입사한 직원 정보를 입력하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="insert.do">
  				<div class="col-md-6">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="firstName" placeholder="홍">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">이름</label>
    				<input type="text" class="form-control" name="lastName" placeholder="길동">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">전화번호</label>
    				<input type="text" class="form-control" name="phoneNumber" placeholder="010-1234-5678">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">이메일</label>
    				<input type="text" class="form-control" name="email" placeholder="hong@gmail.com">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">직종</label>
    				<select class="form-select" name="jobId">
    					<!-- 
    						jobs 테이블의 모든 직종정보를 조회해서 <option />태그를 생성한다.
    					 -->
    					<option value=""> 직종을 선택하세요</option>
    					<option value="AD_PRES"> President (20,080 ~ 40,000 달러)</option>
    					<option value="AD_VP"> Administration Vice President (15,080 ~ 30,000 달러)</option>
    					<option value="AD_ASST"> Administration Assistant (3,000 ~ 6,000 달러)</option>
    					<option value="FI_MGR"> Finance Manager (8,200 ~ 16,000 달러)</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">급여</label>
    				<input type="number" class="form-control" name="salary" placeholder="선택한 직종의 최저/최고 급여범위내의 급여를 입력하세요">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">소속 부서</label>
    				<select class="form-select" name="departmentId">
    					<!-- 
    						departments 테이블의 모든 부서정보를 조회해서 <option />태그를 생성한다.
    					 -->
    					<option value=""> 소속부서를 선택하세요</option>
    					<option value="10"> Administration</option>
    					<option value="20"> Marketing</option>
    					<option value="30"> Purchasing</option>
    					<option value="40"> Human Resources</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">담당 관리자</label>
    				<select class="form-select" name="managerId">
    					<!-- 
    						employees 테이블에서 모든 관리자들을 이름에 대한 오름차순으로 중복없이 조회해서 <option />태그를 생성한다. 
    					 -->
    					<option value=""> 담당 관리자를 선택하세요</option>
    					<option value="100"> Steven King (Executive)</option>
    					<option value="101"> Neena Kochhar (Executive)</option>
    					<option value="102"> Lex De Haan (Executive)</option>
    					<option value="103"> Alexander Hunold (IT)</option>
    					<option value="108"> Nancy Greenberg (Finance)</option>
    					<option value="114"> Den Raphaely (Purchasing)</option>
    					<option value="120"> Matthew Weiss (Shipping)</option>
    					<option value="121"> Adam Fripp (Shipping)</option>
    					<option value="122"> Payam kaufling (Shipping)</option>
    					<option value="123"> Shanta Vollman (Shipping)</option>
    					<option value="124"> Kevin Mourgos (Shipping)</option>
    					<option value="145"> John Russell (Sales)</option>
    					<option value="146"> Karen Partenrs (Sales)</option>
    					<option value="147"> Alberto Errazuriz (Sales)</option>
    					<option value="148"> Gerald Cambrault (Sales)</option>
    					<option value="149"> Eleni Zlotkey (Sales)</option>
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