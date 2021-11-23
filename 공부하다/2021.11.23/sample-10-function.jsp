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

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	//이름있는 함수와 이름없는 함수		-->익명함수라는 것을 만들 수 있다. 자바의 익명객체와는 다르다.
	//이름 있는 함수(함수 선언식)
	//		function 함수이름(매개변수){...}		: 이름있는 함수이다. 
	//이름 없는 함수(함수 표현식)
	//		function(매개변수) {...}  		: 이름 없는 함수이다.
	//이름 있는 함수의 정의 
	//이름 있는 함수에서 함수의 이름은 그 함수를 
	function greetin(name) {		//함수의 이름이 함수를 가르키는 참조변수라고 생각한다. 
		console.log(name + "님 반갑습니다.");
	}
	greetin("홍길동");		//함수의 이름과 매개인자를 작성한다.
	//이름 없는 함수를 정의하고, 변수에 대입
	//이름 없는 함수가 저장된 변수도 그 함수를 참조하는 값을 가지고 있다. 
	var bye = function(name) {
		console.log(name + " 님 안녕히 가세요");
	}
	bye("김유신");	//이름없는 함수를 bye에 작성한다. 참조변수에 대입, 함수를 실행하는 매개변수의 값을 입력하는 것이다. 
	//이름이 있던지, 없던지 함수의 이름을 작성하고 괄호를 붙이면 된다.  함수의 이름이 곧 그 함수를 가르키는 참조변수이다.
	bye("강감찬");
	bye("이순신");	//변수에 담아서 실행할 수 있다.
	
	
	//즉시 실행함수 --변수에 담아놓아야한다. 그러나 그게 없다면 단 한번만 실행하기 위하여 만들었다.
	(function(){
		console.log("함수가 실행되었음");
	})();//괄호를 붙이면 실행할 수 있기 때문에 괄호로 감싸고 괄호를 붙여서 만들 수 있다 --> 웹페이지가 로딩되자마자 바로 실행하게 만든다. -->라이브러리는 내부적으로 
	//즉시실행함수를 사용한다. 
	
	//즉시 실행함수의 매개변수에 인자 전달하기 
	(function(a, b, c){
		console.log(a, b, c);
	})(10, 20, 30);
	//함수를 실행하는 것은 ()괄호이다. 값까지 실행할 수 있다.
</script>
</body>
</html>