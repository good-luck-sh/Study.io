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
	<div class="row">
		<div class="col">
			<input type="text" class="form-control w-50" name="score" value="90"/>
			<input type="text" class="form-control w-50" name="score" value="70" />
			<input type="text" class="form-control w-50" name="score" value="60" />
			<input type="text" class="form-control w-50" name="score" value="50" />
			<input type="text" class="form-control w-50" name="score" value="100" />
			<input type="text" class="form-control w-50" name="score" value="80" />
			<input type="text" class="form-control w-50" name="score" value="70" />
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	var elements = document.querySelectorAll('[name=score]');	//배열유사객체로, 배열의 모든 메소드가 존재하지는 않는다. 
	
	var totalScore = 0;
	elements.forEach(el => totalScore += parseInt(el.value));
	console.log("합계", totalScore);
	//el => totalScore += parseInt(el.value) 화살표 함수
	
	/*
	elements.forEach(function(el){
		var score =parseInt(el.value);	//메소드를 사용하면 정수가 숫자로 바뀐다.
		totalScore += score;
	});	-->장바구니 금액계산, 장바구니에서 삭제할 떄 사용할 수 있다. 
	*/
	
</script>
</body>
</html>