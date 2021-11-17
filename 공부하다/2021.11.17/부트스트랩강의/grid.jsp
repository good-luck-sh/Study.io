<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>부트스트랩</title>
	<style type="text/css">
		.container{
			background-color: lightgray;
		}
		.row div{
			border: 1px solid green;
		}
	</style>    
</head>
<body>
<div class ="container">
	<div class="row">
		<div class="col">
		<!-- 아무것도 적지 않으면 전체를 차지하게 된다. -->
			<h1>그리스 시스템</h1>
		</div>
	</div>
	<h3>같은 간격의 열을 가진 행 정의하기</h3>
	<div class="row">
		<div class="col">1</div>
		<div class="col">2</div>
		<div class="col">3</div>
		<div class="col">4</div>
		<div class="col">5</div>
		<div class="col">6</div>
		<div class="col">7</div>
		<div class="col">8</div>
		<div class="col">9</div>
		<div class="col">10</div>
		<div class="col">11</div>
		<div class="col">12</div>
		<div class="col">13</div>
	</div>
	<div class="row">
		<div class="col">1</div>
		<div class="col">2</div>
		<div class="col">3</div>
		<div class="col">4</div>
		<div class="col">5</div>
		<div class="col">6</div>
	</div>
	<div class="row">
		<div class="col">1</div>
		<div class="col">2</div>
		<div class="col">3</div>
	</div>
	<div class="row">
		<div class="col">1</div>
		<div class="col">2</div>
	</div>
	<div class="row">
		<div class="col">1</div>
		<!-- 등간격으로 나눠보았다. -->
	</div>
	
	<hr>
	
	<h3>서로 다른 크기의 너비를 가지는 열을 2개 포함하는 행 정의하기 </h3>
	<div class="row">
		<div class="col-3">3</div>
		<div class="col-">9</div>
	</div>
	<div class="row">
		<div class="col-4">4</div>
		<div class="col-8">8</div>
	</div>
	<div class="row">
		<div class="col-5">5</div>
		<div class="col-7">7</div>
	</div>
	<div class="row">
		<div class="col-8">8</div>
		<div class="col-4">4</div>
	</div>
	<div class="row">
		<div class="col-10">10</div>
		<div class="col-2">2</div>
	</div>
	
	<hr>
	
	<h3>서로 다른 크기의 너비를 가지는 열을 3개 포함하는 행 정의하기 </h3>
	<div class="row">
		<div class="col-3">3</div>
		<div class="col-6">6</div>
		<div class="col-3">3</div>
	</div>
	<div class="row">
		<div class="col-2">2</div>
		<div class="col-8">8</div>
		<div class="col-2">2</div>
	</div>
	<div class="row">
		<div class="col-3">3</div>
		<div class="col-7">7</div>
		<div class="col-2">2</div>
	</div>
	<hr>
	<h3>지정된 offset만큼 건너띄는 열을 포함하는 행 정의하기</h3>
	<div class="row">
		<div class="col-6 offset-3">6</div>
		<!-- offset은 건너뛰다라는 의미를 가진다. 잘사용하지는 않는다.
		col안에 컨텐츠를 작성한다.  -->
	</div>
	
	<h3>내포된 그리드를 포함하는 행과 열을 정의하기 </h3>
	<div class="row">
		<!-- 이 열을 더 작은 열 3개로 나누기 -->
		<div class="col-4">
		<h4>.col-4열로 나누기</h4>
			<div class="row">
				<div class="col-3">3</div>
				<div class="col-6">6</div>
				<div class="col-3">3</div>
			</div>
		</div>
		<!-- 이 열을 더 작은 열로 나누기 -->
		<div class="col-8">
				<h4>.col-8열로 나누기</h4>
				<div class="row">
				<div class="col-3">3</div>
				<div class="col-3">3</div>
				<div class="col-3">3</div>
				<div class="col-3">3</div>
			</div>
		</div>
		
		<h3>열의 크기가 12를 초과하는 행을 정의하기 </h3>
		<!-- 알아서 줄에 맞춰서 내려오게 된다. -->
		<div class="row">
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
			<div class="col-3">3</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>