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
	//산술과 연관된 함수다. 
	console.log("절대값",Math.abs(-3));			// 3
	console.log("천장값",Math.ceil(1.4));			// 2
	console.log("바닥값",Math.floor(1.4));		// 1
	console.log("반올림",Math.round(1.3));		// 1
	console.log("소숫점버림",Math.trunc(1.9));		// 1
	console.log("난수",Math.random());			// 0<= value < 1 범위의 실수
	
	var x = 0.1, y = 0.2;
	console.log(x + y);					//0.30000000000000004
	console.log((10*x + 10*y)/10)		//0.3 
	//소수점을 없애는 값을 곱하고, 그 값으로 나눠야 간단하게 나온다. 
	//컴퓨터는 부동소수점으로 저장하기 때문에 근사값으로 계산하기 때문에 실수의 값은 정확하지 않다. 
	//그렇기 때문에 2번째 방식으로 계산해야값이 제대로 나온다.
</script>
</body>
</html>