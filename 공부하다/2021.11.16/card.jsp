<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>부트스트랩</title>
</head>
<body>
<div class="container">    
	<h1>카드</h1>
	<!-- 다양한 차트에 담도록 작성한다. 네모박스안에 뭔가를 담고싶을 때 사용한다.  -->
	<div class="row mt-3">
		<div class="col">
			<h4>심플 카드</h4>
			<div class="card">
				<div class="card-body">
					카드의 바디부분입니다.
				</div>
			</div>
		</div>
		<div class="col">
			<h4>다양한 컨텐츠를 포함하는 카드</h4>
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">카드의 제목</h5>
					<h6 class="card-subtitle mb-3">카드의 부제목</h6>
					<p class="card-text">카드의 내용입니다. 카드의 내용입니다. 카드의 내용입니다.</p>
				</div>
			</div>
		</div>
		<div class="col">
			<h4>이미지를 포함하는 카드</h4>
			<div class="card">
				<img src="resources/images/img.jfif" class="card-img-top"/>
				<div class="card-body">
					<h5 class="card-title">가열식 스팀 가습기</h5>
					<p class="card-text text-danger text-end"><strong class="fw-bold">200,000</strong> 원</p>
					<p class="card-text">곰팡이 걱정이 없는 가열식 스팀 가습기 입니다.</p>
					<div class="d-flex justify-content-between">
						<a href="" class="btn btn-outline-primary">장바구니</a>
						<a href="" class="btn btn-primary">바로구매</a>
					</div>
					<div class="mt-3">
						<span class="badge bg-success p-2">무료배송</span>
						<span class="badge bg-warning p-2">당일배송</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col">
			<h4>이미지를 포함하는 카드</h4>
			<div class="card">
				<img src="resources/images/img.jfif" class="card-img-top"/>
				<div class="card-body">
					<h5 class="card-title">가열식 스팀 가습기</h5>
					<p class="card-text text-danger text-end"><strong class="fw-bold">200,000</strong> 원</p>
					<p class="card-text">곰팡이 걱정이 없는 가열식 스팀 가습기 입니다.</p>
					<div class="d-flex justify-content-between">
						<a href="" class="btn btn-outline-primary">장바구니</a>
						<a href="" class="btn btn-primary">바로구매</a>
					</div>
					<div class="mt-3">
						<span class="badge bg-success p-2">무료배송</span>
						<span class="badge bg-warning p-2">당일배송</span>
						<span class="badge bg-danger p-2">5% 할인</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row mt-3">
		<div class="col">
			<h4>테이블을 포함하는 카드</h4>
			<div class="card">
				<div class="card-header">연락처 목록</div>
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th>순번</th>
								<th>이름</th>
								<th>연락처</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>홍길동</td>
								<td>010-1111-1234</td>
							</tr>
							<tr>
								<td>1</td>
								<td>홍길동</td>
								<td>010-1111-1234</td>
							</tr>
							<tr>
								<td>1</td>
								<td>홍길동</td>
								<td>010-1111-1234</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col">
			<h4>리스트그룹을 포함하는 카드</h4>
			<div class="card">
				<div class="card-header">부서목록</div>
				<ul class="list-group">
					<li class="list-group-item">Administration</li>
					<li class="list-group-item">Marketing</li>
					<li class="list-group-item">Purchasing</li>
					<li class="list-group-item">Human Resources</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="row mt-3">
		<div class="col">
			<div class='card'>
				<div class="card-header">팀별 영업실적 (단위:억원)</div>
				<div class="card-body">
					<div id="chart-pie"></div>
					<!-- 엘리먼트의 아이디를 작성해서 차트를 호출하도록 작성했다.  -->
				</div>
			</div>
		</div>
		<div class="col">
			<div class='card'>
				<div class="card-header">팀별 영업실적 (단위:억원)</div>
				<div class="card-body">
					<div id="chart-bar"></div>
				</div>
			</div>
		</div>
	</div>
	
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 
			다양한 차트작성을 지원하는 자바스크립트 라이브러리
			링크 : https://www.w3schools.com/ai/ai_plotly.asp
			D3가 나만의 차트를 만들 수 있으며, 차트가 제일 많다. 
 -->
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
<script>
	var xArray = ["영업1팀", "영업2팀", "영업3팀", "영업4팀", "영업5팀"];
	var yArray = [55, 49, 44, 24, 15];

	Plotly.newPlot("chart-pie",  [{labels:xArray, values:yArray, type:"pie"}]);
	Plotly.newPlot("chart-bar",  [{x:xArray, y:yArray, type:"bar"}]);
	//원형 차트를 이용하여 작성한다. 
</script>
</body>
</html>