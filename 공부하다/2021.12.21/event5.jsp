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
			<h1>현재 존재하지 않는 엘리먼트에 이벤트 핸들러 등록하기</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">
					<h4>입력폼<button class="btn btn-outline-primary btn-sm float-end" id="btn-add-field">추가</button></h4>
					<!-- 이버튼을 클릭했을 때 추가가되기 위해서 id를 부여함 -->
				</div>
				<div class="card-body">
					<div class="mb-3">
						<label class="form-label">이름</label>
						<input type="text" class="form-control"/>
					</div>
					<div class="mb-3">
						<label class="form-label">경력사항</label>
						<div class="d-flex justify-content-between">
							<input type="text" class="form-control w-75"/>
							<!-- 첫번째꺼에는 삭제가 없이 작성함 -->
						</div>
					</div>
					<div class="mb-3">
						<div class="d-flex justify-content-between">
							<input type="text" class="form-control w-75"/>
							<button class="btn btn-outline-danger btn-sm">삭제</button>
						</div>
					</div>
					<!-- 새 경력사항이 추가될 곳, 이 위치를 찾아야한다. 맨 마지막 mb-3 뒤에 들어가야한다.-->
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
 	//id가 btn-add-field 엘리먼트를 클릭했을 때 실행되는 이벤트핸들러 함수를 정의하기 
 	//id를 정의할 때 id가 뭔지 들어내는 id로 작성하는게 좋음 
 	//id = element(버튼)-action(추가)-what(필드) ex)<button id="btn-del-form"> <form id="form-search"> 이렇게
 	//<input type="number" name="amount"><button id="btn-change-amount" />
 	$("#btn-add-field").click(function(){
 		var template = `
 			<div class=" mb-3 d-flex justify-content-between">
				<input type="text" class="form-control w-75"/>
				<button class="btn btn-outline-danger btn-sm">삭제</button>
			</div>`;//1옆에 있는 `것
			
		//class가 card-body인 엘리먼트안에 있는 클래스가 .mb-3인 엘리먼트 중에서 맨 마지막번째 엘리먼트를 선택하기
		$(".card-body .mb-3:last").after(template);//뒤에 넣는것 after, 앞에 넣는것 before
 	})
	
 	//삭제버튼에 이벤트 주기
 	//$(".card-body .btn-outline-danger").click(function(){  //기존에 존재하는 이벤트
 	//	alert("삭제");
 	//})
 	
	//새롭게 추가되는 곳, card-body안에서 생성될 것이다. card-body가 container이다. container는 꼭 존재해야한다.
	//현재 존재하지 않는 엘리먼트에 이벤트핸들러함수를 추가하기
	/*
		$(컨테이너엘리먼트를 선택하는 선택자 ).on('이벤트명', '이벤트를 발생시키는 엘리먼트를 선택하는 선택자', 이벤트핸들러함수)
			+ 컨테이너엘리먼트를 선택하는 선택자 
				- 새로 엘리먼트가 추가되는 부모엘리먼트를 선택하는 선택자를 정의한다.
				- '.card-body'는 경력사항입력필드와 삭제버튼이 추가되는 곳이다.
			+ 처리대상 이벤트명
				- 이벤트명을 지정한다.
			+ 이벤트를 발생시키는 엘리먼트를 선택하는 선택자
				- 이벤트를 발생시키는 엘리먼트를 선택하는 선택자를 정의한다.
				- '.btn-outline-danger'버튼을 클릭했을 때 이벤트 핸들러 함수가 실행된다.
			+ 이벤트핸들러함수
				- '.btn-outline-danger'버튼을 클릭했을 때 실해오디는 이벤트 핸들러 함수다.
				- 
	*/
	$('.card-body').on('click','.btn-outline-danger',function(){
		//버튼을 누르면 부모의 부모가 삭제되어야 한다.
		//$(this)이벤트의 jQuery객체 parent() : 부모, parents(엘리먼트):무조건 조상
		//parents에서 조상을 찾으면 전체 row mb-3이 날아가서 전체가 삭제됨
		//closest('엘리먼트') :제일 가까운 조상을 찾는다.
		//parent() 아니면 closest() 둘중에 하나만 사용해야한다.
	   $(this).closest('.mb-3').remove();
	})	//card-body안에 btn-outline-danger가 새롭게 정의될 텐데, click되면 실행될 이벤트함수
 </script>
</body>
</html>