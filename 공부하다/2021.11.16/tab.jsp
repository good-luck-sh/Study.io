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
	<h1>탭</h1>
	
	<ul class="nav nav-tabs mb-3" role="tablist">
		<li class="nav-item"><a href="#hr-dept" data-bs-toggle="tab" class="nav-link active">부서</a></li>
		<li class="nav-item"><a href="#hr-job" data-bs-toggle="tab" class="nav-link">직종</a></li>
		<li class="nav-item"><a href="#hr-emp" data-bs-toggle="tab" class="nav-link">사원</a></li>
		<!-- 탭의 내비게이션 링크 목록을 우선적으로 조회한다.  -->
	</ul>
	<!-- 탭의 내비게이션과 연결된 컨텐츠 영역을 정의한다. 그래서 a태그의 href에 불러온다. active는 하나에만 작성해야한다. -->
	<div class="tab-content">
		<div id="hr-dept" class="container tab-pane active">
		<!-- active는 화면에 표시할 화면 fade는 표시되지 않는다.  -->
			<h3>부서 리스트</h3>
			<div class="card">
				<div class="card-header">부서 리스트</div>
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th>부서아이디</th>
								<th>부서명</th>
								<th>부서담당자</th>
								<th>부서소재지</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>100</td>
								<td>영업1팀</td>
								<td>홍길동</td>
								<td>서울 종로구</td>
							</tr>
							<tr>
								<td>100</td>
								<td>영업1팀</td>
								<td>홍길동</td>
								<td>서울 종로구</td>
							</tr>
							<tr>
								<td>100</td>
								<td>영업1팀</td>
								<td>홍길동</td>
								<td>서울 종로구</td>
							</tr>
							<tr>
								<td>100</td>
								<td>영업1팀</td>
								<td>홍길동</td>
								<td>서울 종로구</td>
							</tr>
							<tr>
								<td>100</td>
								<td>영업1팀</td>
								<td>홍길동</td>
								<td>서울 종로구</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="hr-job" class="container tab-pane fade">
			<h3>직종 리스트</h3>
		</div>
		<div id="hr-emp" class="container tab-pane fade">
			<h3>사원 리스트</h3>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>