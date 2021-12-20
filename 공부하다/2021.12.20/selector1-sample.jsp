<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title></title>
</head>
<body>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 id="page-title">jQuery 선택자</h1>
			<p>가</p>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>기본 선택자</h3>
			<p>나</p>
		</div>
		<div class="col" id="box-filter">
			<h3>기본 필터 선택자</h3>
			<p>다</p>
			<p>라</p>
			<p>마</p>
			<p>바</p>
			<p>사</p>
		</div>
		<div class="col" id="box-child">	
			<h3>자식, 자손, 형제 선택자</h3>
			<p>아</p>
			<div>
				<h4>자식, 자손, 형제 엘리먼트</h4>
				<p>자</p>
				<p>차</p>
				<p>카</p>
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col" id="box-filter-1">
			<h3>자식필터 선택자</h3>
			<p>타</p>
			
			<h4>음료 메뉴</h4>
			<ul>
				<li>파</li>
				<li>하</li>
				<li>갸</li>
			</ul>
			<h4>커피 메뉴</h4>
			<ul>
				<li>냐</li>
				<li>댜</li>
				<li>랴</li>
			</ul>
			<h4>과일 메뉴</h4>
			<ul>
				<li>먀</li>
				<li>뱌</li>
				<li>샤</li>
			</ul>
		</div>
		<div class="col" id="box-filter-2">
			<h3>순서필터 선택자</h3>
			<p>야</p>
			<div id="box-content">
				<p>쟈</p>
				<p>챠</p>
				<p>캬</p>
				<p>탸</p>
				<p>퍄</p>
				<p>햐</p>
				<p>거</p>
				<p>너</p>			
			</div>
		</div>
		<div class="col" id="box-filter-3">
			<h3>기타필터 선택자</h3>
			<p>더</p>
			<div>
				<p>러</p>
				<p>머</p>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	//$("선택자").css("color","red");
	//'가'를 선택하시오, 가를 선택하고 있는 p
	//$("h1 + p").css("color","red");
	//'가, 나'를 선택하시오 
	//$("p:lt(2)").css("color","red");
	//'다라마바사'를 선택하시오 
	//$('#box-filter p').css("color","red");
	//'사'를 선택하시오 
	//$('#box-filter p:last').css("color","red");
	//'아자'를 선택하시오 
	//$('#box-child p:nth-child(2)').css("color","red");
	//자차카를 선택하시오 
	//$('#box-child div p').css("color","red");
	//야챠타햐너를 선택하시오
	//$('#box-filter-2 p:even').css("color","red");
	//타야더를 선택하시오 
	//$('#box-filter-1 p:first, #box-filter-2 p:first, #box-filter-3 p:first').css("color","red");
	//$('.row:eq(2) h3 + p').css('color','red');
	//먀뱌샤를 선택하시오 
	//$('ul:last').css("color","red");
	//햐를 선택하시오
	//$('#box-content p:eq(5)').css("color","red");
	/*
	'가'를 선택하시오.      $('.row:eq(0) p')
	'가나'를 선택하시오.      $('p:lt(2)')
	'다라마바사'를 선택하시오.   $('#box-filter p')
	'사'를 선택하시오.      $('#box-filter p:last')   
	'아자'를 선택하시오      $('#box-child p:nth-child(2)')
	'자차카'를 선택하시오      $('#box-child div p')
	'야챠타햐너'를 선택하시오.   $('#box-filter-2 p:even')
	'타야더'를 선택하시오.      $('.row:eq(2) h3 + p')   
	'먀뱌샤'를 선택하시오.      $('#box-filter-1 ul:eq(2) li')
	'햐'를 선택하시오      $('#box-content p:eq(5)')
	*/
</script>
</body>
</html>