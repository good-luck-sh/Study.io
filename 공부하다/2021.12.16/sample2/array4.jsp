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
	var names = ['김수영', '한올', '민수', '옥상달빛', '서자영', ' 김사월'];
	
	//배열.filter(함수) : 지정된 함수를 배열의 갯수만큼 실행한다. 함수가 true를 반환하는 값만 포함된 배열을 반환한다.
	
	var shortNames = names.filter(function(name){
		return name.length === 2;
	});
	console.log(shortNames);
	
	shortNames = names.filter(name => name.length >= 3);
	console.log(shortNames);
</script>
</body>
</html>