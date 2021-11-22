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
	<h1>사용자와 상호작용하기</h1>
	
	<div class="mb-3">
		<button class="btn btn-outline-primary" onclick="fn1();">버튼</button>
		<!-- 버튼을 클릭했을때 fn1이라는 메소드를 실행해라 -->
	</div>
	
	<div class="mb-3">
		<button class="btn btn-outline-primary" onclick="appendContent();">버튼</button>
		<button class="btn btn-outline-primary" onclick="clearContent();">버튼</button>
		<p id="content" class="border p-3 mt-2"></p>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	//버튼을 클릭했을 때 실행할 함수 정의
	function fn1() {
		console.log("버튼이 클릭되었습니다.");
	}
	
	function appendContent() {
		console.log("p태그에 컨텐츠를 추가한다.");
		document.querySelector("#content").textContent = "안녕하세요 ";//id가 content를 가지고 와라, 선택해라 
	}
	function clearContent() {
		console.log("p태그의 컨텐츠를 지운다.");
		document.querySelector("#content").textContent = "";
	}
</script>
</body>
</html>