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
	<h1>모달창</h1>
	
	<div>
		<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">모달창 열기
		<!-- data는 자바스크립트라이브러리에서 가져온것으로 myModal에 해당하는 id를 가져온다는 의미이다. -->
		<!-- 경고창이 뜨도록 만드는 것을 의미한다. 페이지에는 있지만 화면에는 표현에 안보인다. display가 none상태이다. -->
		</button>
	</div>
	
	<div class="modal" id="myModal">
  		<div class="modal-dialog modal-lg">
    		<div class="modal-content">
    		<!-- 모달창의 헤더부분의 시작 -->
      			<div class="modal-header">
        			<h4 class="modal-title">주문 상품 내역</h4>
        			<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      			</div>
      			<!-- 모달창의 헤더부분의 끝 -->
      			<!-- 모달창의 바디부분의 시작 바디부분이 모달창에서 표시하고자하는 컨텐츠를 입력한다.-->
      			<div class="modal-body">
        			<div class="card">
        				<div class="car-header">주문 상품 내역</div>
        				<div class="card-body">
        					<table class="table">
        						<thead>
        							<tr>
        								<th>번호</th>
        								<th>상품명</th>
        								<th>가격</th>
        								<th>구매수량</th>
        							</tr>
        						</thead>
        						<tbody>
        							<tr>
        								<td>1000</td>
        								<td>갤럭시Z 플립3 256GB</td>
        								<td>2,000,000 원</td>
        								<td>1 개</td>
        							</tr>
        							<tr>
        								<td>1000</td>
        								<td>갤럭시Z 플립3 256GB</td>
        								<td>2,000,000 원</td>
        								<td>1 개</td>
        							</tr>
        							<tr>
        								<td>1000</td>
        								<td>갤럭시Z 플립3 256GB</td>
        								<td>2,000,000 원</td>
        								<td>1 개</td>
        							</tr>
        						</tbody>
        					</table>
        				</div>
        			</div>
      			</div>
      				<!-- 모달창의 바디부분의 끝 -->
      				<!-- 모달창의 푸터부분의 시작 -->
      				<!-- 푸터부에는 닫기부분이 위치하게 된다.  -->
      			<div class="modal-footer">
        			<button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      			</div>
      			<!-- 모달창의 푸터부분의 끝 -->
			</div>
    	</div>
  	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>