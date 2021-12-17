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
			<h1>배열의 map()메소드</h1>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	/*
	 	배열.map(함수) : 지정된 함수가 반환하는 값이 포함된 배열을 생성한다. 
	 	원본배열을 이용해서 새로운 배열을 만들 때 사용되는 메소드이다. 
	 	map은 가공을 한다고 생각하면 된다. 
	 */
	//학생들의 성적정보(이름, 국어점수, 영어점수, 수학점수)가 저장된 배열
	var data = [
		//현재 데이터가 있다고 가정함
		{name:"홍길동", kor:100, eng:70, math:70},
		{name:"김유신", kor:90, eng:90, math:60},
		{name:"강감찬", kor:70, eng:50, math:40},
		{name:"이순신", kor:80, eng:70, math:70},
		{name:"류관순", kor:100, eng:80, math:80}
	
	];
	//자바스크립트의 객체이다. name:value값으로 저장되는 객체가 존재한다.
	
	//학생들의 성적정보 배열-> 시험본 학생들의 이름이 저장된 배열
	var names = data.map(function(student, index) {
		return student.name;
	});	//데이터를 가공한다.
	
	//원본배열을 이용해서 시험을 본 학생들이 이름이 저장된 배열
	names = data.map(student => student.name);
	console.log("학생이름",names);
	
	//원본배열을 이용해서 이름, 총점, 평균이 저장된 배열 생성하기 
	var scores = data.map(function(student){
		var scores = {
				name : student.name,
				total : student.kor +student.eng + student.math,
				average : (student.kor +student.eng + student.math)/3
		};//객체를 만듦 
		return scores;
	})
	console.log("성적",scores);
	
	//원본배열을 이용해서 평균점수가 60점이상인 합격자 명단이 저장된 배열 생성하기 ---> [홍길동, 이순신, 류관순]
	var passedNames = data.map(function(student){
		var scores = {
				name : student.name,
				average : (student.kor +student.eng + student.math)/3
		}; //객체를 만듦 	0: {name: '홍길동', average: 80},{name: '김유신', average: 80},
		return scores;
	})
	.filter(function(item){
		return item.average >= 60;
	})	//참인것만 걸러짐
	.map(function(item){
		return item.name
	})	//["홍길동", "이순신", "류관순"]
	//화살표 함수를 이용해서 시험을 통과한 학생들의 이름을 획득하기
	passedNames = data.map(item=>{
		return{	//return에 빈줄을 넣으면 안된다.
		name:item.name, 
		average:(item.kor + item.eng + item.math)/3
		
		}
	})	//배열이 반환된다.
		 .filter(item =>item.average >= 60)	//평균점수가 60점이상인 배열이 반환된다.
		 .map(item => item.name)	//이름으로 이뤄진 배열이 반환된다.
		 .join(",");	//"이름,이름,..."문자열이 반환된다.
		 
	//메소드 체이닝
	//var 결과 = 배열.map(함수).filter(함수).map(함수).join(구분자)
	//연쇄적으로 함수를 붙여서 사용한다. 
	
	console.log(passedNames);
</script>
</body>
</html>