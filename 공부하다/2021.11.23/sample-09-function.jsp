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
	//자바스크립트 함수의 매개변수, 지역변수, 반환값
	//매개변수 
	//		자바스크립트 함수는 매개변수를 갖는다.
	//		함수를 실행할 때 매개변수에 맞는 적절한 값을 인자로 전달해야한다.
	//		함수를 실행할 때 매개변수의 갯수보다 적은 갯수의 값을 인자로 전달할 수 있다.
	//		함수를 실행할 때 매개변수의 갯수보다 많은 갯수의 값을 인자로 전달할 수 있다.
	//		매개변수로 숫자, 문자열, 불린값, 배열, 객체, 함수를 전달받을 수 있다. 
	// 		자바는 함수는 받을 수 없다.
	function greeting(name) {
		console.log(name + "님 반갑습니다.");
	}
	//기본 값을 가지는 매개변수 정의하기
	//기본 값이 정의된 매개변수는 값을 전달받지 못하면 기본값으로 설정된 값이 매개변수에 저장된다. 
	function sendMessage(from, to, title, text="내용은 없습니다.") {	//text의 기본값을 설정해 놓았다. 
		console.log(from, to, title, text);
	}
	
	greeting();	//매개변수를 전달받지 않으면 undefined의 값을 입력받는다.
	//매개 변수 name에 값이 전달되지 않았다. 매개변수 name의 값은 undefined다.
	greeting("홍길동");
	//매개 변수 name에 값이 전달되었다. 매개변수의 name의 값은 "홍길동"이다.
	
	sendMessage("홍길동","김유신","오후 2시 회의","오후 2시에 회의 있습니다.");
	//모든 매개변수에 값이 전달 되었다. 
	sendMessage("강감찬", "이순신","점심때 짜장면 어때?");	//제목만 작성하고 내용은 작성하지 않았다.
	//text 매개 변수에 값이 전달되지 않았다. text매개변수에는 기본값으로 설정한 값이 설정된다. 
	
	//자바의 경우 매개변수에 무조건 값을 줘야하지만, 자바스크립트는 값을 주지 않으면 undefined의 값이간다.
	function sum(x, y){
		//arguments는 자바스크립트 함수는 매개변수로 전달되는 모든 인자값을 가지는 배열이다. 
		//모든 자바스크립트의 함수가 공통으로 가지고 있는 프로퍼티이다.
		console.log("arguments",arguments);		//함수에 전달되는 인자값을 갖고있는 배열이다.
		console.log("x=", x, "y=", y)
		var result = x + y;
		console.log("연산결과" , result)
	}
	
	//자바 스크립트의 함수를 호출할 때는 매개변수의 갯수에 상관없이 함수를 호출할 수 있다. 
	sum();			//NaN		, undefined와 undefined가 연산하면 NaN 가 나타난다. Not A Number
	sum(10);		//NaN		,	x= 10 y= undefined으로 NaN이 나타난다. 	[10, callee: ƒ, Symbol(Symbol.iterator): ƒ]의 값을 가진다.
	sum(200, 400);	//600
	sum(3000, 6000, 9000);	//9000		x= 3000 y= 6000 의 연산
	sum(500, 1500, 2500, 3500, 4500);		//2000  x= 500 y= 1500의 연산, 몇개를 보내던지 앞의 2개만 계산된다.
	//앞의 뒤에는 필수입력값으로, 매개변수보다 더많은 값을 보내게 되면 사용하는 것보다 많은 것을 사용할 수 있다. 모든 자바스크립트 함수안에는 기본적으로 프라퍼티의 함수가 들어가있다. 
	
	//지역변수 
	//		함수안에서 정의한 변수다
	//		해당 함수 내부에서만 사용가능하다.
	function showMessage() {
		//지역변수다.
		var message = "반갑습니다.";			//if => 지역변수를 선언시 var을 생략할 경우 글로벌 변수가 된다. 지역변수로 선언시 var을 생략해서는 안된다.
		console.log('지역변수의 값',message);
	}
	showMessage();
	//console.log(message); //정의 안된 값으로 에러가 발생한다.오류, 함수내부에서 선언된 지역변수는 함수밖에서 사용할 수 없다. 
	
	//글로벌 변수 
	// 함수의 외부에서 정의한 변수다. 
	// 서로 다른 함수에서 사용할 수 있다. 
	// 여러 함수에서 공통으로 사용하는 값을 글로벌 함수로 정의할 수 있다.
	//1. 변수만들 때 var생략한다. --> 생각해서는 안되는 행위이다.
	//2. 함수밖에서 var로 정의한다. 
	
	var path = "c:/save";
	
	function saveImage(filename) {
		var fullpath = path + filename;		//밖에서 정의해서 path처럼 사용할 수 있다.
		console.log(fullpath + "파일을 저장합니다.");
	}
	function downloadImage(filename) {
		var fullpath = path + filename;
		console.log(fullpath + "파일을 다운로드합니다.");
	}
	
	saveImage("logo.png");
	downloadImage("logo.png");
	
	//함수의 반환값 
	// 		함수를 호출한 측에게 반환되는 값이다. 
	// 		return문을 사용해서 값을 반환할 수 있다. 
	//		함수 선언부의 반환타입을 정의할 필요가 없다.(자바스크립트의 모든 변수는 변수를 생성할 때 타입을 지정할 필요가 없기 때문이다. --> 알아서 바뀌기 때문이다.)
	//		함수의 반환값은 숫자, 문자열, 불린값, 배열, 객체, 함수 모두 가능하다.
	function plus(x, y){
		var z = x + y;
		return z;
	}
	var returnValue = plus(10, 20);
	console.log("반환값",returnValue);
	
	//객체를 반환하는 함수
	function getScore(name, kor, eng, math) {
		var total = kor + eng + math;
		var average = total/3;
		
		//학생 성적정보를 포함하는 객체를 생성한다.
		var result = {학생이름:name, 국어점수:kor, 영어점수:eng, 수학점수:math, 총점:total, 평균:average};
		//배열의 객체는 name:value의 값을 반환한다. 
		return result;
	}
	
	//전부 public이기 때문에 open되어있어서 getter/setter이 필요하지 않다.
	//가져오는 방법 
	//x. 학생이름으로 가져온다.		--> dot연산자와 
	//x[학생이름]으로 가져온다. 		-->브라켓표기법으로 가져올 수 있다. 
	
	//score변수에는 getScore()함수의 반환한 객체가 대입된다.
	var score = getScore("홍길동", 100, 80, 60);		//score안에 객체가 들어있다.
	console.log(score.학생이름);
	console.log(score['국어점수']);
	console.log(socre.평균);
	
</script>
</body>
</html>