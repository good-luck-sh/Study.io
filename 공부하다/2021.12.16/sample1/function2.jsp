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
			<h1>콜백함수</h1>
			<p>함수를 파라미터로 전달하기,엄청 많이 사용 됨</p>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	function 계산기(num1, num2, type) { //계산을 하는데 어떤 연산이 올지 몰라 type을 매개변수로 둠
		if(type === '더하기') {
			console.log("결과" ,num1 + num2)
		} else if(type === '곱하기') {
			console.log("결과" ,num1*num2)
		}
	}//계산기 1은 수정을 할 수 없이 정해져있다.
	
	계산기(10,20,'더하기');
	계산기(10,20,'곱하기');
	
	//좀더 나은방법으로 계산기를 구현하고 싶음
	//함수를 매개변수로 전달받는 함수
	// 새로운 연산기능이 추가되더라도 계산기2()의 코드를 변경할 필요가 없다.
	// 계산기2()는 두 수를 연산하는 기능을 직접 구현하지 않고, 연산기능이 구현된 함수를 전달받아서 그 함수를 실행시키기만 한다.
	function 계산기2(num1, num2, fn) {//fn에 함수가 들어오게 함, 자바스크립트는 함수를 매개변수로 전달할 수 있다.
		fn(num1, num2);
	}//계산기2는 이코드가 끝이다.
	//실제로 실행할 부분은 내가 구현해놨으니까 넌 구현만해 (함수를 매개변수로 전달받은 함수) --확장성이 좋아졌다.
	//새로운 함수가 추가되더라도 계산기2의 메소드는 변경하지 않아도된다.
	//실제 실행하는 코드는 다양한 기능을 수행하기 때문에 이런형태의 메소드들이 많다.
	
	function plus(a, b){
		console.log(a + b);
	}
	function minus(a, b){
		console.log(a - b);
	}
	
	//계산기2()함수를 실행할 때 미리 정의된 함수를 전달했다.
	계산기2(100, 200, plus);//plus의 기능을 전달해줌, 계산기2(100, 200, function plus(a, b) {console.log(a + b)})
	계산기2(100, 200, minus);	//계산기2(100, 200, function minus(a, b) {console.log(a - b)})
	//계산기2()함수를 실행할 떄 익명함수를 호출시점에 직접 작성해서 전달했다.
	계산기2(100,200,function(a, b) {
		console.log(a*b);
	})//그냥 그자리에서 즉석으로 함수를 만들어서 전달해도 된다.
	계산기2(100,200,function(a, b){
		console.log(a/b);
	})//내가 실행시키고싶은 함수를 직접 구현해서 전달하고 싶을 때 함수를 만들어서 메소드 호출시점에 전달한다.
</script>
</body>
</html>