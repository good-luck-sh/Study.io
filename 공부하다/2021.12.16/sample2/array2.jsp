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
	//배열의 모든 값 출력하기 
	var array1 = [100, 200, 300, 400, 500];
	
	for(var a = 0; a < array1.length; a++) {
		console.log(array1[a]);
	}
	
	for(var b in array1) {	//b가 index의 범위로 출력된다.
		console.log(array1[b]);
	}
	
	// 배열.forEach(함수) : 지정된 함수를 배열의 갯수만큼 실행한다.
	//					: 함수는 function(item, index) {...}  -->아이템에는 값, 인덱스에는 횟수가 들어간다. index는 생략가능함
	// 배열.forEach(function(value, index) {})
	
	array1.forEach(function(item, index) {		//총 5번 반복된다. 
		console.log(item, index)
	});
	
</script>
</body>
</html>