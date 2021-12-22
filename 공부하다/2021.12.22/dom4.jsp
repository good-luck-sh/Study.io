<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
</head>
<body>
<div class ="container">
	<div class="row mb-3">
		<div class="col">
			<h1>클래스 조작하기</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-6">
			<ul class="list-group" id="ul-dept-list">
			<!-- 클릭하면 active의 색상이 들어가게 하고싶다.-->
				<li class="list-group-item">영업1팀</li>
				<li class="list-group-item">영업2팀</li>
				<li class="list-group-item">영업3팀</li>
				<li class="list-group-item">영업4팀</li>
			</ul>
		</div>
			<div class="col-6">
			<ul class="list-group" id="ul-dept-list-2">
			<!-- 클릭하면 active의 색상이 들어가게 하고싶다.-->
				<li class="list-group-item">영업1팀</li>
				<li class="list-group-item">영업2팀</li>
				<li class="list-group-item">영업3팀</li>
				<li class="list-group-item">영업4팀</li>
			</ul>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header" id="card-user-list">레퍼런스 참가자 현황</div>
				<div class="card-title">사원명단
					<div class="card-body">
						<ul class="list-group" id="ul-user-list-1">
						<li class="list-group-item">홍길동</li>
						<li class="list-group-item">김유신</li>
						<li class="list-group-item">강감찬</li>
						<li class="list-group-item">이순신</li>
						<li class="list-group-item">류관순</li>
						<li class="list-group-item">안중근</li>
						</ul>
					</div>
				</div>
				<div class="card-body">
					<button class="btn btn-outline-dark" id="btn-down-emp">추가</button>
					<button class="btn btn-outline-danger" id="btn-up-emp">삭제</button>
				</div>
				<div class="card-body">
					<div class="card-title">참가 확정 사원리스트
						<ul class="list-group" id="ul-user-list-2">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
 	/*
 		1. id="card-user-list"의 <li class="list-group-item"></li>들을 클릭하면 active를 토글시킨다.
 			+ 클릭한 것 외에 다른 엘리먼트의 list-group-secondary 상태를 변경할 필요는 없다.
 			+ 즉, list-group-secondary 상태의 엘리먼트가 여러개 있어도 된다.
 		2. 추가버튼을 클릭하면 
 			+ <ul class="list-group" id="ul-user-list-1">의 li엘리먼트중에서 list-group-secondary 상태인 것들만 선택한다. 
 			+ 선택한 엘리먼트들을 <ul class="list-group" id="ul-user-list-2">에 추가한다.
 			+<ul class="list-group" id="ul-user-list-2">에 추가된 엘리먼트들의 class에서 list-group-secondary클래스를 삭제한다.
 	*/
 	//강사님 답 
 	$("#ul-user-list-1 .list-group-item").click(function(){
 		$(this).toggleClass('list-group-item-secondary');
 	});	//여기까지 정답 맞춤
 	//추가버튼에 이벤트를 걸 예정이다. 
 	$("#btn-down-emp").click(function(){
 		moveElements("#ul-user-list-1","#ul-user-list-2")
 	});
 	
 	$("#btn-up-emp").click(function(){
 		moveElements("#ul-user-list-2","#ul-user-list-1")
 	})//코드 리펙토링 진행함. 변하는 부분만 전달해줄 수 있게 변수로 넣어줌
 	
 	function moveElements(src, dest) {
 		var $listGroupItems = $(src)	//id가 ul-user-list-1인 엘리먼트를 선택한다.
 		.find(".list-group-item-secondary")			//위에서 선택한 엘리먼트의 자손중에서 클래스가 'list-group-item-secondary'를 선택한다.
 		.removeClass('list-group-item-secondary');	//위에서 선택한 엘리먼트의 class에서 'list-group-item-secondary'를 삭제한다.
 		if($listGroupItems.length == 0) {
 			alert("선택된 사원이 없습니다.");
 			return;
 		}
 		$(dest).append($listGroupItems);
 	}
 	//선택된 엘리먼트에 클래스 추가/삭제하기
 	$("#ul-dept-list li").click(function(){
 		$(this).addClass('active').siblings().removeClass('active');
 	})
 	//없는 상태에서 클릭하면, active이고, 있는상태에서 클릭하면 없애고 싶다.
 	//선택된 엘리먼트에 클래스 토굴시키기
 	$("#ul-dept-list-2 li").click(function(){
 		$(this).toggleClass('active').siblings().removeClass('active');
 	})
 	
 	/*
 	//선택된 엘리먼트에 클래스 토굴함
 	$("#ul-user-list-1 li").click(function(){
 		$(this).toggleClass('active').siblings().removeClass('active');
 	})
 	
 	$("#btn-down-emp").click(function(){//card-body
 		var $names = $("#ul-user-list-1").find('.list-group-item.active').removeClass('active');
 		$('#ul-user-list-2').append($names);
 	})		
	
 	$('#ul-user-list-2').click(function(){
 		
 	})
 	*/
 </script>
</body>
</html>