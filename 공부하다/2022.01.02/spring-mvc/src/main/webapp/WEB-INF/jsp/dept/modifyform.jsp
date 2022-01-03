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
<c:set var="menu" value="부서"/>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-4">부서 정보 수정 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p class="mb-3">부서정보를 수정하세요</p>
			<form class="border px-3 pb-3 bg-light row g-3" method="post" action="modify.do">
				<input type="hidden" name="id" value="90" />
  				<div class="col-md-12">
    				<label class="form-label">부서명</label>
    				<input type="text" class="form-control" name="name" value="Executive">
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">부서 관리자</label>
    				<select class="form-select" name="managerId">
    					<!-- 
    						Employees 테이블의 데이터 중에서 수정할 부서에 소속된 사원들을 조회해서 <option />태그를 생성하도록 한다.
    						수정할 부서의 기존 부서관리자가 미리 선택되어 있어야 한다.
    					 -->
   						<option value="100" selected> Steven King</option>
   						<option value="101"> Neena Kochhar</option>
   						<option value="102"> Lex De Haan</option>
    				</select>
  				</div>
  				<div class="col-md-6">
    				<label class="form-label">부서 소재지</label>
    				<select class="form-select" name="locationId">
    					<!-- 
    						Locations 테이블의 데이터를 조회해서 <option />태그를 생성하도록 한다.
    						수정할 부서의 기존 부서 소재지가 미리 선택되어 있어야 한다.
    					 -->
    					<option value="1000"> Roma</option>
    					<option value="1100"> venice</option>
    					<option value="1200"> Tokyo</option>
    					<option value="1300"> Hiroshima</option>
    					<option value="1400" selected> Southlake</option>
    					<option value="1500"> South San Francisco</option>
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