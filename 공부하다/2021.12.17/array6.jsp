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
			<h1>배열의 reduce() 메소드</h1>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	/*
		배열.reduce(함수) : 배열의 요소를 처리해서 최종적으로 값 하나를 반환한다.
		reduce라는 단어가 줄인다라는 뜻을 가지고 있다. reduce의 매개변수는 항상 2개의 값이 필요하다.
		배열.reduce(function(total, value){return total + value;})
		total의 초기값은 0이다.
		지정된 함수의 반환값이, 다음 번 실행되는 함수의 total로 전달된다. 
		value는 배열의 값이 순서대로 전달된다.
		map과 reduce는 빅데이터에서 제일 중요한 개념이다.
	*/
	var numbers =[80, 100, 20, 50, 70];
	
	var total = numbers.reduce(function(subtotal, num){	// 0, 80 /80 ,100 / 180, 20..이렇게 들어가게됨
		return subtotal + num
	});
	console.log(total);
</script>
</body>
</html>