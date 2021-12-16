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
			<h1>화살표 함수</h1>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	/*
		함수 정의하기 
		1. 함수 선언
			function 함수명(매개변수, 매개변수, 매개변수) {
				수행문;
			}
		2. 함수 표현식
			var 변수명 = function(매개변수, 매개변수, 매개변수) {
				수행문;
			}
		3. 화살표 함수	(함수표현식을 더 단순하고 간결한 문법으로 정의하는 것)
			var 변수 = (매개변수, 매개변수, 매개변수) => 수행문
			//function이라는 기호가 사라지는 것 
			var 변수 = (매개변수, 매개변수, 매개변수) =>{
				수행문;
				수행문;
			} //수행문이 2개이상이면 중괄호가 필요하다
			* 화상표 함수의 특징
				+ 매개변수가 없는 화살표 함수는 아래와 같이 작성할 수 있다. 괄호를 생략할 수 없다.
				var 변수 = () => 수행문
				+ 매개변수가 하나만 있는 화살표 함수는 매개변수를 감싸는 괄호를 생략할 수 있다. 
				var 변수 = 매개변수 => 수행문
				var 변수 = (매개변수) => 수행문
				+ 수행문이 하나만 있는 화살표 함수는 중괄호가 필요없다. 
				+ 수행문이 하나만 있는 화살표 함수에서는 return 키워드를 생략해도수햄누의 실행결과가 반환값이 된다. 
				+ 수행문이 2개 이상있는 화살표 함수는 중괄호가 필요하다. 
				+ 수행문이 2개 이상있는 화살표 함수가 반환값이 있는 경우 return키워드를 사용해서 값을 반환해야한다.
				
			작성예
				function fn(a,b) {		function fn(a,b) {} 		var fn = function(a,b) {	var fn= funcrion(a,b) {
					var c = a + b;			return a + b;				var c = a + b;				return a + b;
					return c;				}							return c;					}
				}														}
				var fn = (a,b) => {			var fn = (a,b) => a + b;
				var c = a + b;
				return c;
				}
		함수는 위의 방법 중 어떤 방식이 좋은다?
			+ 첫번째 고려대상은 언제나 함수선언이다. 
				* 함수선언 방식으로 정의한 함수는 그 함수를 선언위치와 상관없이 사용할 수 있다. 
				* 함수의 이름을 통해서 어떤 기능이 정의된 함수인지 빠르게 파악할 수 있다. 
				* 함수의 몸체에 해당하는 부분에 복잡한 수행문을 작성할 수 있다. 
			+ 함수로 구현한 기능이 딱 한군데에서만 사용되거나 혹은 다른 함수의 매개변수로 전달하는 함수인 경우 함수 표현식을 고려할 수 있다. 
				* 함수 표현식도 중괄호안에 복잡한 수행문을 작성할 수 있다.
				* 함수를 호출할 때 그 함수의 매개변수로 함수가 전달되는 경우, 전달되는 함수를 함수표현식으로 작성하는 것이 좋다.
				* 함수를 호출할 떄 그 함수의 매개변수로 함수가 전달되는 경우, 전달되는 함수의 코드가 간단하다면 화살표 함수를 고려할 수 있다. 
	*/	
	function 계산기(a, b, fn) {
		var x = fn(a, b);
		console.log("결과", x);
	}
	계산기(10,20, function(a, b){
		return a + b;
	})
	계산기(10,20,(a,b) => a - b);	
	
	계산기(10,20,(a,b) => {return a - b});	// 결과 undefined, 중괄호로 묶으면 return문을 꼭 적어주어야한다. 
</script>
</body>
</html>