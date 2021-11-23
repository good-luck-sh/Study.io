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
	<h1 class="mb-3">이벤트 연습</h1>
	
	
	<div class="row mb-3">
		<div class="col">
		<h3>onclick 이벤트</h3>
		<!-- 
			이 버튼에서 : 이벤트 소스 지정
			onclick 이벤트가 발생하면 : 이벤트 종류 지정
			등록()함수가 실행되게 한다. : 이벤트 핸들러 함수 지정
			이벤트 모델을 활용한 사용자와 상호작용하기 
		 -->
			<button class="btn btn-primary" onclick="등록();">등록버튼</button>	<!-- 엘리먼트를 클릭했을 때 발생하는 이벤트 -->
			<button class="btn btn-warning" onclick="수정();">수정버튼</button>
			<button class="btn btn-danger" onclick="삭제();">삭제버튼</button>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col">
			<h3>onmouseenter와 onmouseleave이벤트</h3><!-- 항상 쌍으로 다닌다. -->
			<div class="border p-5" onmouseenter="들어가기();" onmouseleave="나가기();">박스</div>
			<!-- 이벤트의 이름은 소문자로 작성해야하는 관례가 존재한다. 전부다 소문자로 작성할 수 있다.  -->
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col">
			<h3>onkeydown, onkeypress, onkeyup 이벤트</h3>
			<input type="text" name="username" onkeydown="down();" onkeypress="press();" onkeyup="up();">
			<!-- 하나의 엘리먼트에 여러가지 반응요소를 입력할 수 있다. -->
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col">
			<h3>onchange 이벤트</h3>
			<select class="form-select" name="career" onchange="옵션바꾸기();">
				<option value="" selected disabled >선택하세요</option>
				<option value="1">1년 이상</option>
				<option value="3">3년 이상</option>
				<option value="5">5년 이상</option>
				<option value="7">7년 이상</option>
				<option value="10">10년 이상</option>
				<option value="12">12년 이상</option>
			</select>
			
			<div class="form-check-inline">
				<input class="form-check-input" type="checkbox" name="skill" value="java" onchange="선택해제();">
				<label class="form-check-label">자바</label>
			</div>
			<div class="form-check-inline">
				<input class="form-check-input" type="checkbox" name="skill" value="python" onchange="선택해제();">
				<label class="form-check-label">파이썬</label>
			</div>
			<div class="form-check-inline">
				<input class="form-check-input" type="checkbox" name="skill" value="c" onchange="선택해제();">
				<label class="form-check-label">c</label>
			</div>
			<div class="form-check-inline">
				<input class="form-check-input" type="checkbox" name="skill" value="c++" onchange="선택해제();">
				<label class="form-check-label">c++</label>
			</div>
			<!-- 전체 선택 / 전체 해제 방법 -->
		</div>
		
		<div class="row mb-3">
			<div class="col">
				<h3>onsubmit 이벤트</h3>
				<form class="border p-3 bg-light" onsubmit="">
					<div class="mb-3">
						<label class="form-label">아이디</label>
						<input type="text" class="form-control" name="id">
					</div>
					<div class="mb-3">
						<label class="form-label">비밀번호</label>
						<input type="text" class="form-control" name="password">
					</div>
					<div class="text-end">
						<button type="submit" class="btn btn-primary">로그인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	function 등록(){
		alert("등록버튼이 클릭되었습니다.");	//프로젝트에서는 절대 사용해서는 안된다. 
	}
	
	function 수정(){
		alert("수정버튼이 클릭되었습니다");
	}
	
	function 삭제(){
		alert("삭제버튼이 클릭되었습니다");
	}
	function 들어가기() {
		console.log("박스 안으로 마우스가 들어왔다.");
	}
	function 나가기() {
		console.log("박스 밖으로 마우스가 나갔다.");//경고창으로는 확인하기 어렵다. console.log가 보기 편함
	}
	function down(){
		console.log("keydown");
	}
	function press(){
		console.log("keypress");
	}
	function up() {
		console.log("keyup");
	}
	function 옵션바꾸기(){
		console.log("선택옵션이 변경되었다. ");
	}
	function 선택해제() {
		console.log("체크박스가 선택 혹은 해제되었습니다.");
	}
</script>
</body>
</html>