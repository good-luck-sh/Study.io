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
			<h1>jQuery의 이벤트 관련 메소드</h1>
			<p>.on('이벤트명', 이벤트핸들러함수),.one() .off(), trigger()</p>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
			<h3>.on()으로이벤트핸들러 등록하기</h3>
			<div id="box-btn-1">
				<button class="btn btn-primary" id="btn-1">버튼</button>
				<button class="btn btn-primary" id="btn-2">버튼</button>
			</div>
		</div>
		<div class="col-3">
			<h3>.one()으로이벤트핸들러 등록하기</h3>
			<div id="box-btn-2">
				<button class="btn btn-primary" id="btn-3">버튼</button>
				<button class="btn btn-primary" id="btn-4">버튼</button>
			</div>
		</div>
		<div class="col-3">
			<h3>.off()으로 등록된 이벤트핸들러를 삭제하기</h3>
			<div id="box-btn-3">
				<button class="btn btn-primary" id="btn-5">버튼</button>
				<button class="btn btn-primary" id="btn-6">버튼</button>
			</div>
		</div>
		<div class="col-3">
			<h3>.trigger()으로 이벤트 강제 발생시키기</h3>
			<div id="box-btn-4">
				<button class="btn btn-primary" id="btn-7">버튼</button>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
 	//버튼을 클릭할 때마다 실행될 이벤트 핸들러함수를 등록하기
 	$("#btn-1").on("click",function(){
 		alert("1번 버튼이 클릭되었습니다.");
 	})
 	$("#btn-2").click(function(){	//내부적으로는 위와 동일하게 진행되는 것이다.
 		alert("2번 버튼이 클릭되었습니다.");
 	})
 	
 	//버튼을 처음 한번 클릭할 때만 실행될 이벤트 핸들러 함수를 등록하기 ,딱 한번만 실행되고 삭제된다. 새로고침하면 사용할 수 있다.
 	$("#btn-3").one("click",function(){
 		alert("3번 버튼이 클릭되었습니다.");
 	});
 	$("#btn-4").one("click",function(){
 		alert("4번 버튼이 클릭되었습니다.");
 	});
 	
 	//버튼에 등록된 이벤트 핸들러함수를 삭제하기 
 	$("#btn-5").click(function(){	//btn-5를 클릭하면 btn-1에서 클릭이벤트 발생시 실행될 이벤트 핸들러를 삭제한다. 
 		$("#btn-1").off("click");
 	})
 	 $("#btn-6").click(function(){	//btn-6를 클릭하면 btn-2에서 클릭이벤트 발생시 실행될 이벤트 핸들러를 삭제한다. 
 		$("#btn-2").off("click");
 	})
 	
 	$("#btn-7").click(function(){	//함수를 지정한 것이다. 함수들은 이벤트가 발생될 때 실행되게 등록하는 함수이지, 이벤트가 실행시키는 것이 아니다.
 		alert("7번 버튼이 클릭되었습니다.");	//이벤트 발생을 통해서 실행되는 것이다.
 	});
 	
 	//btn-7엘리먼트에서 onclick 이벤트를 강제로 발생시키기
 	$("#btn-7").trigger("click");
 	//클릭이벤트를 강제로 발생시키는 것이다. 이벤트를 목적으로 사용할 수 있다.
 </script>
</body>
</html>