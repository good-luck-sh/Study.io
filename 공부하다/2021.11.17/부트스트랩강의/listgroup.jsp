<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>부트스트랩</title>
</head>
<body>
<div class ="container">
	<h1>리스트 그룹</h1>
	<h2>리스트 그룹</h2>
	<div class="row">
	<!-- 헹으로 만들꺼야 그리고 4개의 행을 만들꺼라고 col로 작성한다.  -->
		<div class="col">
			<h3>기본 리스트 그룹</h3>
			<ul class="list-group">
				<li class="list-group-item">본사</li>
				<li class="list-group-item">수도권역</li>
				<li class="list-group-item">경남권역</li>
				<li class="list-group-item">충청권역</li>
			</ul>
		</div>
		<div class="col">
			<h3>활성화/비활성화된 리스트 그룹</h3>
				<ul class="list-group">
				<li class="list-group-item disable">본사</li>
				<li class="list-group-item active">수도권역</li><!-- active로 선택되어있음을 나타낼수있다. -->
				<li class="list-group-item">경남권역</li>
				<li class="list-group-item">충청권역</li>
			</ul>
		</div>
		<div class="col">
			<h3>링크를 포함하는 리스트 그룹</h3>
			<div class="list-group">
				<a href="" class="list-group-item list-group-item-action">가구</a>
				<a href="" class="list-group-item list-group-item-action active">전자제품</a>
				<a href="" class="list-group-item list-group-item-action">의류</a>
				<a href="" class="list-group-item list-group-item-action">악세사리</a>
			</div>
		</div>
		<div class="col">
			<h3>뱃지를 포함하는 리스트 그룹</h3>
			<ul class="list-group">
			<!-- between을 사용하면 거리가 멀어지게 만든다. rounded-pill은 가득채운다는 의미이다.-->
				<li class="list-group-item d-flex justify-content-between">아메리카노<span class="badge bg-primary rounded-pill"> 5,000원</span></li>
				<li class="list-group-item d-flex justify-content-between">카푸치노<span class="badge bg-success rounded-pill"> 5,000원</span></li>
				<li class="list-group-item d-flex justify-content-between">카라멜 모카<span class="badge bg-warning rounded-pill"> 5,000원</span></li>
				<li class="list-group-item d-flex justify-content-between">바닐라 라떼<span class="badge bg-danger rounded-pill"> 5,000원</span></li>
				<li class="list-group-item d-flex justify-content-between">자몽티<span class="badge bg-black rounded-pill"> 5,000원</span></li>
			</ul>
		</div>
	</div>
	<hr>
	<h3>사용자 정의 리스트 그룹</h3>
	<div class="row">
		<div class="col">
			<h4>심플 사용자 정의 리스트 그룹</h4>
			<ul class="list-group">
				<li class="list-group-item d-flex justify-content-between align-items-start">
					<div class="ms-2 me-auto">
					<!-- 유틸리티클래스 안에 있는 것, 글자를 진하게 만든다. -->
					<div class="fw-bold">프로젝트 회의</div>
					201호 회의실에서 프로젝트 일정관련 회의 참석하기 
					</div>
					<span class="badge bg-danger">긴급</span>
				</li>
				<li class="list-group-item d-flex justify-content-between align-items-start">
					<div class="ms-2 me-auto">
					<!-- 유틸리티클래스 안에 있는 것, 글자를 진하게 만든다. -->
					<div class="fw-bold">프로젝트 회의</div>
					201호 회의실에서 프로젝트 일정관련 회의 참석하기 
					</div>
					<span class="badge bg-secondary">지연</span>
				</li>
				<li class="list-group-item d-flex justify-content-between align-items-start">
					<div class="ms-2 me-auto">
					<!-- 유틸리티클래스 안에 있는 것, 글자를 진하게 만든다. -->
					<div class="fw-bold">프로젝트 회의</div>
					201호 회의실에서 프로젝트 일정관련 회의 참석하기 
					</div>
					<span class="badge bg-success">완료</span>
				</li>
				<li class="list-group-item d-flex justify-content-between align-items-start">
					<div class="ms-2 me-auto">
					<!-- 유틸리티클래스 안에 있는 것, 글자를 진하게 만든다. -->
					<div class="fw-bold">프로젝트 회의</div>
					201호 회의실에서 프로젝트 일정관련 회의 참석하기 
					</div>
					<span class="badge bg-primary">예정</span>
				</li>
			</ul>
		</div>
		<div class="col">
			<h4>다양한 컨텐츠를 포함하는 사용자 정의 리스트 그룹</h4>
			<div class="list-group">
				<a href="" class="list-group-item list-group-item-action">
					<div class="d-flex w-100 justify-content-between">
					<!-- div의 flex로 만들면서 100%채워지도록 생성했다. mb : margin, bottom -->
						<h5 class="mb-1">프로젝트 회의 참석</h5>
						<small>2021년 11월 30일</small>
					</div>
					<p class="mb-1">
					신규프로젝트 일정계획 수립 및 개발 인원산정을 위한 요구사항 리스트 점검회의
					신규프로젝트 일정계획 수립 및 개발 인원산정을 위한 요구사항 리스트 점검회의
					신규프로젝트 일정계획 수립 및 개발 인원산정을 위한 요구사항 리스트 점검회의
					</p>
					<small>홍길동</small>
						<a href="" class="list-group-item list-group-item-action">
					<div class="d-flex w-100 justify-content-between">
						<h5 class="mb-1">프로젝트 회의 참석</h5>
						<small>2021년 11월 30일</small>
					</div>
					<p class="mb-1">
					<!-- 멀게 만들어주는 것이 mb-다음의 숫자 a태그가 인라인태그인데 블록엘리먼트를 인라인엘리먼트 안에 작성할 수 없다. 
						그원칙을 깻기 때문에 노란 줄이 간다. 클릭을 하면 a태그로 설정한 주소로 이동한다.
					-->
					신규프로젝트 일정계획 수립 및 개발 인원산정을 위한 요구사항 리스트 점검회의
					신규프로젝트 일정계획 수립 및 개발 인원산정을 위한 요구사항 리스트 점검회의
					신규프로젝트 일정계획 수립 및 개발 인원산정을 위한 요구사항 리스트 점검회의
					</p>
					<small>홍길동</small>
				</a>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>