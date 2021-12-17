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
	//시스템의 현재 날짜와 시간 정보가 포함된 정보 획득하기
	var now = new Date();
	console.log(now);	//Fri Dec 17 2021 10:48:25 GMT+0900 (한국 표준시)
	//Date객체 
	//Date객체의 주요메소드 
	console.log("년", now.getFullYear());
	console.log("월", now.getMonth() + 1);	//월은 0 ~ 11
	console.log("일", now.getDate());
	console.log("시", now.getHours());
	console.log("분", now.getMinutes());
	console.log("초", now.getSeconds());
	console.log("유닉스타입", now.getTime());
	console.log("날짜", now.toLocaleDateString());
	console.log("시간", now.toLocaleTimeString());
	//내가 원하는 날짜대로 표현하는 기능은 자바스크립트에서는 부족하다.
	//moment.js라는 라이브러리를 사용하면 쉽게 날짜를 다룰수 있다. 
</script>
</body>
</html>