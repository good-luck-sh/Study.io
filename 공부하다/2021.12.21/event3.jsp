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
			<h1>jQuery의 이벤트 핸들러 함수에서 this</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<button class="btn btn-primary">버튼 1</button>
			<button class="btn btn-primary">버튼 2</button>
			<button class="btn btn-primary">버튼 3</button>
			<button class="btn btn-primary">버튼 4</button>
			<button class="btn btn-primary">버튼 5</button>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<ul class="list-group">
				<li class="list-group-item">홍길동<button class="btn btn-danger btn-sm float-end">삭제</button></li>
				<li class="list-group-item">김유신<button class="btn btn-danger btn-sm float-end">삭제</button></li>
				<li class="list-group-item">강감찬<button class="btn btn-danger btn-sm float-end">삭제</button></li>
				<li class="list-group-item">이순신<button class="btn btn-danger btn-sm float-end">삭제</button></li>
				<li class="list-group-item">류관순<button class="btn btn-danger btn-sm float-end">삭제</button></li>
			</ul>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
 	$(".row:eq(1).btn").click(function(){
 		//this에는 이벤트가 발생한 엘리먼트객체(jQuery결과 집합 객체가 아님)가 전달된다. 
 		//this를 바로 사용하지 않고, $(this)를 실행해서 jQuery결과집합객체를 획득한 다음 사용한다.
 		//console.log(this);	
 		//console.log($(this));	//k.fn.init [button.btn.btn-primary]
 		$(this).prop('disabled', true);
 	})	//버튼에 click이벤트를 걸었고, this에 그 이벤트를 발생시킨 그 버튼이 담겨서 전달된다.
 	//this에 이벤트를 발생시킨 엘리먼트가 무엇인지 알아낼 수 있다. 일일히 버튼에 등록해놓을 필요는 없다. 
 	//아무버튼이나 이렇게 진행하는 것은 아니다.
 	
 	$(".btn-danger").click(function(){
 		//this는 이벤트가 발생한 엘리먼트 객체다. 
 		//$(this)는 이벤트가 발생한 엘리먼트를 포함하는 jQuery결과 집합 객체이다.
 		//$(this).parent()는 이벤트가 발생한 엘리먼트의 부모엘리먼트를 포함하는 jQuery결과 집합 객체다.
 		//$(this).parent().remove()는 이벤트가 발생한 엘리먼트의 부모엘리먼트를 삭제하는 코드다.
 		$(this).parent().remove();//버튼만 삭제된다. parent()메소드로 부모엘리먼트의 객체를 반환한다.
 		//this.parent().remove()는 안된다.
 	})
 	//해당
 	
 /*	
 function fn() {
 		console.log(this);
 	}
 	
 	var obj1 = {
 			name: "object1",
 			fn: function(){
 				console.log(this);
 			}
 	}
 	
 	var obj2 = {
 			name: "object2"
 	}
 	
 	//Window객체가 콘솔에 출력된다. 
 
 		21번 라인에서 정의한 fn함수는 Window객체에 자동으로 등록된다.
 		Window객체는 브라우져의 내장객체이다.
 		스크립트 코드에서 생성하는 모든 변수, 모든 객체, 모든 함수가 Window객체의 멤버로 포함된다.
 		따라서, 위에서 정의한 fn함수, obj1객체, obj2객체도 Window객체에 포함된다.
 		Window객체는 Window객체의 Window프로퍼티에 저장되어 있다.
 	
 	
 	fn();				//Window {window: Window, self: Window, document: document, name: '', location: Location, …}
 	//obj1객체가 콘솔에 출력된다.
 	obj1.fn();			//{name: 'object1', fn: ƒ}
 	//obj2객체가 콘솔에 출력된다. 즉, 함수의 this는 고정적이지 않다. 함수의 this에 임의의 객체를 전달하는 것이 가능하다.
 	obj1.fn.call(obj2);	//{name: 'object2'}
 */
 	
 	
 	
 </script>
</body>
</html>