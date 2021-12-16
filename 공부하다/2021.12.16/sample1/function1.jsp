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
			<h1>자바스크립트 함수</h1>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	//자바스크립트 함수 정의하기 
	fn1();
	fn2();	//오류 발생, 익명함수로 함수를 생성한 경우에는 반드시 함수표현식 아래에서 그 함수를 사용해야 한다. 
	//함수선언 함수 선언하기
	function fn1(){
		console.log("fn1함수 입니다.");
	}
	
	//이름 없는 익명함수를 함수표현식으로 정의하고 변수에 대입한 것
	var fn2 = function(){
		console.log("fn2함수 입니다.");
	}
	

</script>
</body>
</html>