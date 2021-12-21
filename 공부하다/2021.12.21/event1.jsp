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
			<h1>이벤트 처리</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
			<h3 class="fs-5">인라인 이벤트 처리</h3>
			<div>
				<button class="btn btn-primary" id="btn-1" onclick="evetHandler()">버튼</button>
			</div>
		</div>
		<div class="col-3">
			<h3 class="fs-5">엘리먼트의 onXXX에 이벤트 핸들러 함수를 등록해서 이벤트 처리</h3>
			<div>
				<button class="btn btn-primary" id="btn-2">버튼</button>
			</div>
		</div>
		<div class="col-3">
			<h3 class="fs-5">엘리먼트의 addEventListener로 이벤트 핸드러 함수를 등록해서 이벤트 처리 </h3>
			<div>
				<button class="btn btn-primary" id="btn-3">버튼</button>
			</div>
		</div>
		<div class="col-3">
			<h3 class="fs-5">jQuery로 이벤트 처리</h3>
			<div>
				<button class="btn btn-primary" id="btn-4">버튼</button>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
  	function evetHandler(){
  		alert("버튼이 클릭되었습니다.");
  	}
  	
  	/*
  	var btn2 = document.getElementById("btn-2");
  	btn2.onclick = evetHandler;	//eventHandler라는 함수를 등록하는 것이다. 
  	//btn2엘리먼트의 onclick프로퍼티에 eventHandler함수를 등록한다.
  	
  	var btn3 = document.getElementById("btn-3");
  	btn3.addEventListener("click",evetHandler);	//버튼 3에서 클릭이라는 이벤트가 발생하면 함수가 실행되도록 메소드를 등록했다.
  	//btn3엘리먼트에서 onclick이벤트 발생시 실행할 함수로 eventHandler를 등록한다.
  	
  	$("#btn-4").on('click',evetHandler);//jQuery의 select하고, click event시 발생할 함수를 등록함
  	//아이디가 "btn-4"인 엘리먼트를 선택자 함수로 찾고, 엘리먼트에서 click이벤트 발생시 실행할 함수로 eventHandler를 전달한다.
  	*/
  	
  	document.getElementById("btn-2").onclick= function(event){
  		alert("2번째 버튼이 클릭되었습니다.");
  	};	//실제로는 더 이렇게 많이 적음, 미리 정의 된 함수에만 위처럼 대입, 거의 익명함수를 많이 사용한다.
  	
  	document.getElementById("btn-3").addEventListener("click", function(event){
  		alert("3번째 버튼이 클릭되었습니다.");
  	});
  	
  	$("#btn-4").on('click',function(event){//필요하다면 event를 매개변수로 두고 전달받을 수 있다.
  		alert("4번째 버튼이 클릭되었습니다.");
  	});//제이쿼리를 사용하면 이런 형태의 개발이 이뤄진다.
 </script>
</body>
</html>