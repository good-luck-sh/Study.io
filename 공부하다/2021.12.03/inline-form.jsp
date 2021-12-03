<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>폼 샘플::인라인 폼</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">부트스트랩 인라인 폼</h1>
		</div>
	</div> 
	<div class="row mb-3">
		<div class="col">
			<div class=" d-flex justify-content-center border p-3 bg-light">
				<form class="row row-cols-lg-auto gx-3 align-items-center">
	  				<div class="col-12">
	    				<select class="form-select" id="search-option" name="option">
	    					<option value="" selected disabled> 선택하세요</option>
	    					<option value="title"> 제목</option>
	    					<option value="writer"> 작성자</option>
	    					<option value="content"> 내용</option>
	    				</select>
	  				</div>
	  				<div class="col-12">
	  					<input type="text" class="form-control" id="search-keyword" name="keyword"  pattern="검색어를 입력하세요"/>
	  				</div>
	  				<div class="col-12">
	    				<button type="submit" class="btn btn-primary">검색</button>
	  				</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>