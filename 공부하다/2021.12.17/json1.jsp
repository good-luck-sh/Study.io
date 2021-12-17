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
 			<h1>자바스크립트 JSON</h1>
 		</div>
 	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	/*
		Javascript의 JSON API
			JSON.stringify(자바스크립트 객체) : json object구조의 텍스트가 반환된다.
			JSON.stringify(자바스크립트 배열)	 : json array구조의 텍스트가 반환된다.
			
			JSON.parse("json object구조의 텍스트") : 자바스크립트 객체가 반환된다.
			JSON.parse("json array구조의 텍스트")  : 자바스크립트 배열이 반환된다. 
	*/
	//자바스크립트 객체/배열 -> json형식의 텍스트 
	var employee = {name:"홍길동", dept:"영업1팀" , salary:3500000, commissionPct:0.1};
	var employees =[{name:"홍길동", dept:"영업1팀" , salary:3500000, commissionPct:0.1},{name:"김유신", dept:"홍보팀" , salary:5500000, commissionPct:0.3}]
	
	//생성된 json형식의 텍스트 데이터
	var jsonText = JSON.stringify(employee);
	var jsonText2 = JSON.stringify(employees);
	
	//json형식의 텍스트 -> 자바스크립트의 객체/배열
	var employee2 = JSON.parse(jsonText);
	var employees2 = JSON.parse(jsonText2);
	
	console.log(employee2);	//.찍어서 가져옴
	console.log(employees2);//forEach로 가져옴
	
</script>
</body>
</html>