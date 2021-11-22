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
	//자바스크립트의 객체 타입
	
	// 배열 		-->java의 List와 유사하다.
	// 값을 여러개 담는 자료구조, 0부터 시작하는 index가 있다. 
	//배열에 저장되는 값의 타입은 상관이 없다.
	//가변길이의 배열이다. 
	var arr1=[];	//길이가 0인 배열을 생성한다. -->java로 생각한다면 arrayList와 동일하다. 자바의 배열보다는 훨씬더 기능이 많다. 
	//배열의 특정 인덱스에 값을 저장하기 
	arr1[0] = 100;
	arr1[1] = 200;
	arr1[45] = 450;
	arr1[75] = 500;
	arr1[99] = 10000;
	console.log("arr1 배열의타입", typeof arr1); //배열의 길이를 미리 설정하지 않아도 된다. 따로 입력하지 않으면 empty값이 들어간다.
	//앞에 설명한 타입외에는 전부 Object의 타입이다.
	console.log("arr1 배열", arr1); //배열의 길이를 미리 설정하지 않아도 된다. 따로 입력하지 않으면 empty값이 들어간다.

	console.log("arr1 배열의 0번쨰 값", arr1[0]);		//100출력	
	console.log("arr1 배열의 1번쨰 값", arr1[1]);		//200출력
	console.log("arr1 배열의 2번쨰 값", arr1[2]);		//undefined 출력

	//배열에 여러 종류의 값을 저장할 수 있다. 
	//배열에 여러 종류의 값을 저장할 수 있지만, 실제 프로젝트에서는 배열에 같은 종류의 값만 담는다. -->어디에 뭐가 들어가는지 알고있어야하기 떄문
	//차트같은 경우에는 같이 사용할 수 있지만, 그외에는 되도록 사용하지 않는다.
	var arr2 = [10,"강감찬", "김유신" , [100,200,300],3.14];
	console.log("arr2의 배열", arr2);	
	
	//객체
	//이름:값의 쌍으로 저장하는 자료구조 ,java의 Map과 유사하다. 
	//자바 스크립트의 객체는 class가 필요없다. -->아예 존재 없다. 
	//자바스크립트의 객체는 프로그램 실행 중에 그 구성요소를 자유롭게 추가/ 삭제할 수 있다. 
	//값은 숫자, 문자열, boolean값, 배열, 객체, 함수(메소드) 등이 가능하다.
	var obj1 = {}; 	//비어있는 객체 생성
	var obj2 = {name:'홍길동',kor:100, eng:100, math:100, passed:true};
	
	//함수  -- > java의 메소드와 유사하다.
	//이름 있는 코드 블록이다. 
	//java와 다른점 
	//접근제한자가 없다. 반환타입이 존재하지 않는다 --> 기본적으로는 public이다. private로 설정은 가능하다. . 매개 변수는 변수명만 적는다.
	function plus(x, y) { //원래대로라면 var x, var y로 
		var z = x + y;
		return z;
	}
	
	console.log('plus의 타입', typeof plus);	//function이라는 type의 값이 나온다. 객체이다. 
	var result1 = plus(10, 20);
	var result2 = plus(100, 456);
	var result3 = plus(108574, 6847694);
	console.log('덧셈 결과',result1);
	console.log('덧셈 결과',result2);
	console.log('덧셈 결과',result3);
	console.log('덧셈 결과',plus(10000,20000));
	//앞으로 제일 많이 만들게 될 것이 함수다. 
</script>
</body>
</html>