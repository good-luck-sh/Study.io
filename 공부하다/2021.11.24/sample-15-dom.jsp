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
	<div class="row ">
		<div class="col">
			<h1>폼 요소의 값 조회/변경하기</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-6">
			<h3>폼 요소의 값 조회하기</h3>
			<p>아이디 및 비밀번호 입력필드에 모든 값이 입력된 경우에만 폼 입력값이 login.jsp로 제출되게 한다. </p>
			<form id="form-lodin" class="border p-3 bg-light" method="post" action="login.jsp" onsubmit="checkInputField(event);">
			<!-- 이 이벤트가 발생했을 때 발생하지 않게 되도록 만드는 것 그래서 event객체를 입력했다.  
				form에 id를 주고, onsubmit의 이벤트는 submit을 누를때 발생한다. 유효성을 체크를 하기위해서, form의 이벤트시function에 event객체을 보낸다. 
			-->
			<!-- form에서만 사용되는 event : 입력값이 제출되기 직전에 제출된다. -->
				<div class="mb-3">
					<label class="form-label">아이디</label>
					<input type="text" class="form-control" name="id" id="user-id" />
					<div class="form-text text-danger" style="display:none;" id="error-message-id">아이디는 필수 입력값입니다.</div>
					<!-- 제일처음에는 div가 등장하지 않게 만들고, 입력을 하지 않을 경우 나타나게 하고 싶다.  -->
				</div>
				<div class="mb-3">
					<label class="form-label">비밀번호</label>
					<input type="text" class="form-control" name="password" id="user-password" />
					<div class="form-text text-danger" style="display:none;" id="error-message-password">비밀번호는 필수 입력값입니다.</div>
				</div>
				<div class="mb-3 text-end">
					<button type="submit" class="btn btn-primary">로그인</button>
					<!-- 이 버튼을 클릭시, jsp에게 이 양식이 제출된다. -->
				</div>
			</form>
		</div>
		<div class="col-6">
		
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	function checkInputField(e) {
		//form태그에서 onsubmit이벤트 발생시 폼입력값을 서버로 제출하는 기본동작이 동작되지 않게 한다. 
		//먼저 걸어놓고 시작한다.
		e.preventDefault();
		//폼의 엘리먼트를 조회한다. 
		var loginForm = document.getElementById("form-lodin");
		
		//아이디와 비밀번호 입력필드 엘리먼트를 선택한다. 
		var userIdElement = document.getElementById("user-id");
		var userPasswordElement = document.getElementById("user-password");
		//오류 메세지를 표시하는 엘리먼트를 선택한다. 
		var idErrorMessageElement = document.getElementById("error-message-id");
		var passwordErrorMessageElement = document.getElementById("error-message-password");
		//조작대상의 모든 엘리먼트를 가지고 와야한다.
		//아이디 입력필드에 입력된 값을 조회한다. 
		//비밀번호 입력필드에 입력된 값을 조회한다. 
		
		//입력필드 유효성 체크전에 모든 에러메세지를 숨긴다. 
		idErrorMessageElement.style.display = "none";
		passwordErrorMessageElement.style.display = "none";
		var userId = userIdElement.value;
		var usePassword = userPasswordElement.value;
		
		//입력필드에 대한 유효성체크 통과여부를 저장하는 변수
		var isValid = true;	//유효한지 체크
		if(userId === "") {
			idErrorMessageElement.style.display = "";//에러메세지가 보이게 확인
			isValid = false;
		} 
		if(usePassword === "") {
			passwordErrorMessageElement.style.display = "";
			isValid = false;
			//isvalid가 유효하지 않다.
		}//하나라도 걸리면 안된다. 두개가 통과가 되었다는 것은 유효성체크에서 통과가 되었다는 뜻이다.
		//유효성체크를 모두 통과했다면 form 엘리먼트 객체의 submit()메소드를 실행해서 폼 입력값을 서버로 제출시킨다.
		if(isValid) {
			loginForm.submit();
		}
	}
</script>
</body>
</html>