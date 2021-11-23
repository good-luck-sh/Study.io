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
	// 자바스크립트의 함수 
	// 		이름있는 코드들의 블록이다. 
	//		자바스크립트 프로그램을 구성하는 주요 구성요소다.
	// 함수의 사용목적
	//  	함수를 이용해서 프로그램에서 반복적으로 등장하는 코드를 함수로 정의하면 코드의 중복을 제거할 수 있다.
	//		함수를 이용해서 사용자와의 상호작용을 구현한다. 
	//		함수를 이용해서 HTML 태그, 컨텐츠, 스타일 등을 조작할 수 있다. 
	// 함수의 선언(정의)
	//	function 함수이름(매개변수 , 매개변수, 매개변수, ...) {	--여러개 작성가능하다.
	//		수행문;	-->이 부분이 함수의 본문이 된다. 
	//		수행문;
	//	}
	// 함수의 사용, 함수의 실행
	//		함수이름 (값, 값, 값,...); -->참조변수가 필요하지 않다.
	//	함수의 선언	-->function이라는 객체를 만들어서 이름, 매개변수를 입력한다. 이름으로 저장된 함수를 찾아서 실행하게 된다. 
	function greeting(name) {
		console.log(name + "님 반갑습니다. ")
	}
	// 함수의 실행
	greeting("홍길동");
	greeting("김유신");
	
	
</script>
</body>
</html>