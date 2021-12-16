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
			<h1>배열의 기본 메소드</h1>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	//자바스크립트의 배열
	//가변길이 배열이다. 자바의 ArrayList와 동일하다. 다양한 메소드를 제공한다.
	//프로퍼티
	//	length : 배열의 길이를 반환한다. 
	//메소드
	//	push(값)			: 배열의 끝에 새 값을 추가한다. 
	//	pop()			: 배열의 맨 마지막값을 삭제하고, 그 값을 반환한다.	
	//	shift()			: 배열의 맨 처음값을 삭제하고, 그 값을 반환한다.
	//	unshift(값)		: 배열의 맨 처음에 새 값을 추가한다.
	//	splice(index, many, 값, 값, 값, 값, ...)
	//					index : 값을 삭제하거나 추가할 위치를 지정한다.
	//					many : 삭제할 갯수를 지정한다. 0을 입력하면 삭제하지 않는다.
	//					값 	:추가할 값을 지정한다, 생략하면 삭제만 할 수 있다.
	//					index, many와 값을 전부 넣는다면 many가 설정한 값까지 삭제 후 그사이에 값이 들어간다.
	//					특정위치의 값을 삭제하거나 추가할 때 많이 사용한다. 
	//	join(연결문자)		: 배열의 값을 지정된 연결문자로 연결한 문자열로 반환한다.
	var items = ["사과","바나나","감자"];
	// 배열의 끝에 추가하기 
	items.push("토마토");		//['사과', '바나나', '감자', '토마토']
	items.push("메론");		//['사과', '바나나', '감자', '토마토',"메론"]
	items.push("오렌지");		//['사과', '바나나', '감자', '토마토',"메론","오렌지"]
	console.log(items);
	
	// 배열의 앞에 추가하기 
	items.unshift("고구마");	//['고구마', '사과', '바나나', '감자', '토마토', '메론', '오렌지']
	items.unshift("호박");	//['호박', '고구마', '사과', '바나나', '감자', '토마토', '메론', '오렌지']
	items.unshift("당근");	//['당근', '호박', '고구마', '사과', '바나나', '감자', '토마토', '메론', '오렌지']
	console.log(items);
	
	// 배열의 끝에서부터 삭제하기
	console.log(items.pop());	//['당근', '호박', '고구마', '사과', '바나나', '감자', '토마토', '메론']
	console.log(items.pop());	//['당근', '호박', '고구마', '사과', '바나나', '감자', '토마토']
	console.log(items.pop());	//['당근', '호박', '고구마', '사과', '바나나', '감자']
	console.log(items);
	
	//배열의 처음부터 삭제하기
	console.log(items.shift());	//['호박', '고구마', '사과', '바나나', '감자']
	console.log(items.shift());	//['고구마', '사과', '바나나', '감자']
	console.log(items);
	
	//배열의 특정 위치에 추가/삭제하기 
	var items2 = ['고구마', '사과', '바나나', '감자'];
	
	//'바나나'삭제하기 
	//items2.splice(2, 1);				['고구마', '사과', '감자']
	//'바나나','감자' 삭제하기 
	//items2.splice(2, 2);				['고구마', '사과']
	//'사과'를 삭제하고 그 자리에 '호박' 추가하기 
	//items2.splice(1, 1, '호박')			['고구마', '호박', '바나나', '감자']
	//'사과'를 삭제하지 않고 그 자리에 '호박' 추가하기 
	//items2.splice(1, 0, '호박')			['고구마', '호박', '사과', '바나나', '감자']
	
	//지정된 위치의 값 하나 삭제하기
	//배열.splice(index, 1);
</script>
</body>
</html>