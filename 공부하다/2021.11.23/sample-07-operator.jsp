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
	//자바스크립트의 연산자. 
	
	//산술 연산자
	var x = 10;
	var y = 4;
	
	console.log("x + y", x + y);
	console.log("x - y", x - y);
	console.log("x*y", x*y);
	console.log("x/y", x/y);		//정수/정수 연산결과 값이 실수가 될 수도 있다. 
	console.log("x%y", x%y);
	
	//비교 연산자
	var a = 5;
	var b = 5;
	var c = '5';
	var d = '8';
	/*
		== 		타입이 다르더라도 변환 후 값이 일치하면 true다.	--둘중에 하나만 같아도 true다.
		===	 	타입도 같고, 값도 같을 때만 true다.			--전체적으로 같을 때 true다
		!=		타입도 다르고, 값도 다를 때만 true다.		--전체적으로 다를 때 true다 
		!==		타입이 다르거나 값이 다르면 true다.			--둘중에 하나만 같아도 true다.
	
	*/
	console.log("a == b", a == b);			//true a와 b의 값이 같거나, 서로 타입인 다른 경우 타입 변환 후 값이 같으면 true로 판정된다.
	console.log("a === c", a === c);		//false, a와 c의 타입도 같고, a와 c의 값도 같으면 true이다. -->좀더 안전하다.
	
	console.log("a != b", a != b);			//false			5!=5		-->달라야 true가 나온다.값도 같고, 타입도 같아서 서로 다르지 않다. 
	console.log("a != c", a != c);			//false			5!='5'	--타입은 다르지만 변환후 값이 서로 다르지 않다.
	console.log("a != d", a != d);			//true			5!='8'	--타입도 다르고, 변환후 값도 다르다. -->진짜 다른상탵
	
	console.log("a !== b", a !== b);		//false, 5!==5		다른게 하나도 없다. 
	console.log("a !== c", a !== c);		//true, 5!=='5'		타입은 다르고, 값은 같다. 그래서 false : 다른게 하나라도 있으면된다.
	console.log("a !== d", a !== d);		//ture,	5!=='8'		타입도 다르고, 값도 다르다.
	
	//논리 연산자 
	//&& || !		-->java의 경우 boolean타입의 값이 논리연산의 결과 값이 되었었다. 
	//자바스크립트에서 false로 여기는 값
	//		false, undefined, null, 0, '' , NaN은 항상 false로 간주되는 값이다.
	//자바 스크립트에서 true로 여기는 값
	//		위에서 정의한 6개의 값을 제외한 모든 값
	//자바의 경우 : 피연산자가 반드시 boolean 타입의 값 이거나, 연산결과가 boolean 타입이어야 한다. 
	//		   	 논리 연산의 연산결과는 항상 true, false의 값 중의 하나다.
	// 				distance > 30000 || year >= 3 		-->이런 부분만 가능하다. 
	//자바스크립트의 경우 : 피연산자가 boolean 타입의 값일 필요는 없다.
	//					논리 연산의 결과가 boolean타입이 아닐 수 있다.
	//				4 && 5 		-->값이 5가 나온다.
	//var distance = 3000		---> undefined
	//var year = 1			-->	undefined
	//distance >= 50000 || year >= 3 ---> false 와 false의 비교로 false의 값이 나온다.
	//var minPrice;		--> 1. undefined --> 2. false로 판단되는 값
	
	//3. ||연산자는 좌항의 값이 true일 때 우황을 확인하지 않는다. 
	//	 || 연산자는 좌항의 값이 false일 때 우황을 확인한다.
	//4. 즉, 위의 식에서는 좌항이 false이기 떄문에 우황을 확인한다. 
	// minPrice || 1000  --> false || 1000  -->false와 1000을 비교함 (1000의 값에 따라서 true와 false가 된다.)  -->5. 우황의 값은 1000이다.
	//6. 따라서, 이 연산의 최종결과는 1000이다. 
	//7. 최종결과값이 true/false가 아닌 이유는 1000이 true에 해당하는 값이기 때문이다. --> 어제 false배운것 외에는 전부 false이다. 
	//if문에서 사용이 된다면 1000인 값으로 인식하여  true의 값으로 인식한다.
	
	//var minPrice = 5000;
	//minPrice || 1000
	//1. minPrice의 값은 5000이다. 
	//2. 5000은 true로 간주된다. 
	//3. ||연산자는 좌항의 값이 true일 때 우황을 확인하지 않는다. 
	//	 || 연산자는 좌항의 값이 false일 때 우황을 확인한다.
	//4. 즉, 위의 식에서는 좌항이 true이기 때문에 우항을 확인하지 않는다. 
	//5. 따라서 이 연산의 최종 결과는 5000이다.
	//distance >= 50000 || year >= 3 이렇게 적는 경우가 많다. --> 자바스크립트의 독특한 성질로 인하여 다르게 사용한다. 
	
	//distance >= 50000 || year >= 3 연산결과 : TRUE/FALSE중의 하나다. 
	// 자바 스크립트의 논리 연산자의 특징을 활용한 수행문이 있다. 
	/*
		function searchProductsByMinPrice(minPrice) {
			변수 = 매개변수 || 매개변수의 값이 null이거나 undefined일 때 변수에 대입할 디폴트의 값
			var price = minPrice || 1000;
			console.log(price);
			//price변수의 값은 매개 변수 minPrice값이 undefined일 때 1000이다
			//price의 변수의 값은 매개변수 minPrice값이 undefined가 아닐 때는 minPrice의 값이 된다. -->변수의 기본값이 들어가기 위하여 사용한다. 뒤의 있는 값이 default값이다.
		}
	
		searchProductByMinPrice();	-->값을 넣지 않았을 경우 : 매개변수의 값을 주지 않고도 호출하는 것이 가능하다. minPrice는 undefined다.  출력결과 : 1000
		searchProductByMinPrice(5000);		minPrice는 5000이다			출력결과 : 5000
		searchProductByMinPrice(25000);		minPrice는 25000이다			출력결과 : 25000
		searchProductByMinPrice(50000);		minPrice는 50000이다			출력결과 : 50000
		-->minPrice가 전달 받지 않을 경우, 기본값을 설정할 수 있다. 
		
	*/
	var distance = 3000, year = 1;
	var isPaymentRepair = distance >= 50000 || year >= 3;
	console.log("유상수리 여부", isPaymentRepair);
	
	//자바 스크립트의 논리 연산자의 고유한 특징을 응용한 예
	//maxUploadFileSize값이 undefined일 때 size는 1024*1024*10이다.
	//maxUploadFileSize값이 undefined가 아닐 때 size는 maxUploadFileSize의 값이다.
	var maxUploadFileSize;
	var size = maxUploadFileSize || 1024*1024*10;
	console.log(size);		//출력결과 : 1024*1024*10
	
	maxUploadFileSize = 1024*1024*5;
	size = maxUploadFileSize || 1024*1024*10;
	console.log(size);		//출력결과 : 1024*1024*5
	
</script>
</body>
</html>