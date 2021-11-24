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
		<div class="col">이벤트 객체와 엘리먼트를 전달하기</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<!-- 
				이벤트핸들러 메소드의 매개변수로 발생한 Event객체를 전달할 수 있다. 
				꼭 이름을 event라고 적어줘야한다. 
				onclick = "이벤트핸들러함수(event)";
			 -->
			<button class="btn btn-primary" onclick="btn1(event);">버튼1</button>
				<!-- 발생한 이벤트가 변수에 저장된다.  -->
			<button class="btn btn-primary" onclick="btn2(this);">버튼1</button><!-- 버튼을 클릭시 event가 발생,이벤트 객체가 만들어진다. -->
			<!-- 
				이벤트가 발생한 엘리먼트를 이벤트핸들러함수의 매개변수로 전달할 수 있다. 
				this는 이벤트가 발생한 그 엘리먼트를 나타낸다. 
			 -->
			<!-- 이벤트가 발생한 엘리먼트가 저장된다.  -->
			<button class="btn btn-primary" onclick="btn3(event, this);">버튼1</button><!-- 버튼을 클릭시 event가 발생,이벤트 객체가 만들어진다. -->
		</div>
	</div>
	<div class="row">
		<div class="col">
			<h3>임의의 값을 전달하기</h3>
			<!-- 
				요청헨들러 함수의 매개변수로 임의의 값을 전달할 수 있다. 
			 -->
			<div class="border p-3 mb-3">
            <div class="form-check form-check-inline">
               <input class="form-check-input" type="checkbox" name="skill" value="java" onchange="선택해제('java');">
               <label class="form-check-label">자바</label>
            </div>
            <div class="form-check form-check-inline">
               <input class="form-check-input" type="checkbox" name="skill" value="python" onchange="선택해제('python');">
               <label class="form-check-label">파이썬</label>
            </div>
            <div class="form-check form-check-inline">
               <input class="form-check-input" type="checkbox" name="skill" value="c" onchange="선택해제('c');">
               <label class="form-check-label">c</label>
            </div>
            <div class="form-check form-check-inline">
               <input class="form-check-input" type="checkbox" name="skill" value="c++" onchange="선택해제('c++');">
               <label class="form-check-label">c++</label>
            </div>
         </div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	function btn1(e) {
		console.log('이벤트 객체', e);
		console.log('발생한 이벤트의 종류', e.type);	//this와 동일함
		console.log('이벤트를 발생시킨 엘리먼트', e.target);
		console.log("엘리먼트의 태그명",e.target.tagName);
		console.log("엘리먼트의 컨텐츠",e.target.textContent);
	}
	function btn2(el) {
		console.log('엘리먼트객체', el);
		console.log("엘리먼트의 태그명",el.tagName);
		console.log("엘리먼트의 컨텐츠",el.textContent);
		//태그와 버튼의 이름을 읽어올 수 있다.
	}
	function btn3(e, el) {
		console.log('이벤트객체', e);
		console.log('엘리먼트객체', el);	
	}
	function 선택해제(skill) {
		console.log("선택 혹은 해제된 스킬",skill);
		//뭐가 바뀐지 알수 있다. 임의의 값을 전달해서 확인이 가능하다. 
		//event, this, 임의의 값을 전달할 수 있다. 
	}
</script>
</body>
</html>