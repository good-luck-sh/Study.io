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
			<h1>텍스트 컨텐츠, HTML 컨텐츠 조회 및 변경</h1>
			<p class="border p-3 mb-3" id="text-content-1">첫번째 텍스트 내용입니다.</p>
			<p class="border p-3 mb-3" id="text-content-2">두번째 텍스트 내용입니다.</p>
			<div>
				<button class="btn btn-primary" onclick="getTextContent();">조회</button>
				<!-- 조회를 클릭시 첫번째를 조회하고 싶을경우 유니크한id를 부여한다. 
					조작의 대상이 되는 엘리먼트에 id를 부여한다. html상호작용, 이벤트 헨들러메소드를 통해서 사용자의 대응은 
					사용자가 선택하는 엘리먼트를 우선적으로 찾는 방법을 고민해야한다.
					HTML조작하기 
					1. 조작대상이 되는 엘리먼트를 선정한다. 
					2. 조작대상이 되는 엘리먼트를 조회하기 위해서 id혹은 class를 확인하고, 필요하면 추가한다. 
					3. 사용자와 상호작용하는 엘리먼트를 선정한다 
						(주로 button, a, input, select등이다.)
					4.사용자와 상호작용으로 발생되는 이벤트 중에서 하나를 선정한다. 
						(주로 onclick, onchange, onkeyup, onsubmit 이다.)
					5. 이벤트 발생시 실행될 이벤트핸들러 함수를 정의한다.
					6. 사용자와 상호작용하는 엘리먼트에 이벤트 이름="이벤트핸들러함수()"를 정의한다. 
					7. 이벤트 핸들러 함수를 구현한다. 
						a. 조작대상이 되는 엘리먼트를 조회한다. 
						var el = document.getElementById("아이디");		--Element객체 
						var elList = document.getElementsByTagName("태그명");--Element객체가 담긴 HTMLCollection
						var elList = document.getElementsByClassNme("클래스명");--Element객체가 담긴 HTMLCollection
						var el =document.querySelector("선텍지표현식");--Element객체 
						var elList=document.querySelectorAll("선택자표현식");--Element객체가 담긴 HTMLCollection
						
						var el = document.getElementById("아이디");		--Element객체 
						var el =document.querySelector("선텍지표현식");--Element객체 
						var elList=document.querySelectorAll("선택자표현식");--Element객체가 담긴 HTMLCollection
						이 3개만 생각해도 된다. 선택자표현식에 어떻게 작성하는지에 따라서 태그명 클래스명을 가지고 올 수 있기 때문이다.
						
						b.엘리먼트에서 조회/변경 대상이 되는 값을 조회하거나 변경한다. 
						//조회 
						var 변수명 = el.프로퍼티명;			
						var 변수 = el.textContent;		//텍스틑 컨텐츠를 조회한다. 
						var 변수 = el.innerHTML;			//태그가 포함된 html컨텐츠를 조회한다. 
						var 변수 = el.getAttribute("속성명"); 	//태그의 속성값을 조회한다. 
						var 변수 = el.value;				//input,select, textarea, checkbox, radio의 값을 조회한다. 
						var 변수 = el.checked;			//checkbox,radio의 체크여부를 조회한다.
						var 변수 = el.disabled;			//input,select, textarea, checkbox, radio, button의 비활성화 여부를 조회한다. 
						var 변수 = el.readOnly;			//input,select, textarea, checkbox, radio의 읽기전용여부를 조회한다. 
						var 변수 = el.style.display;		//스타일(표시여부)를 조회한다.
						
						//변경 
							el.textContent = "변경내용";
							el.innerHTML = "<태그>컨텐츠</태그>";
							el.setAttribute("속성명","값");
							el.value = "값";
							el.checked = true;혹은 el.checked= false;
							el.disabled = true;혹은 el.disabled= false;
							el.readOnly = true;혹은 el.readOnly= false;
							el.style.display = 'none' 혹은 el.style.display = '';
				 -->
				<button class="btn btn-warning" onclick="changeTextContent();">변경</button>
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>텍스트 컨텐츠 조회 및 변경</h3>
			<div class="border p-3 mb-3" >
				<h4>첫번째 div 엘리먼트</h4>
				<div id="box-1">
					<ul>
						<li>커피</li>
						<li>사이다</li>
						<li>콜라</li>
					</ul>
				</div>
			</div>
			<div class="border p-3 mb-3">
				<h4>첫번째 div 엘리먼트</h4>
				<div id="box-2"></div>
			</div>
			<div>
				<button class="btn btn-primary" onclick="getHtmlContent();">조회</button>
				<button class="btn btn-warning" onclick="changeHtmlContent();">변경</button>
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>엘리먼트 복사하기</h3>
			<div class="row">
				<div class="col-4 text-center">
					<div class="card">
						<div class="card-header">직원리스트</div>
						<ul class="list-group">
<!-- 

	for (Employee emp : employeeList) {

							<li class="list-group-item" onclick="addList();">< % =emp.getName() % ></li>

 -->
							<li class="list-group-item" onclick="addList(this, '홍길동');">홍길동</li>
							<li class="list-group-item" onclick="addList(this, '김유신');">김유신</li>
							<li class="list-group-item" onclick="addList(this, '강감찬');">강감찬</li>
							<li class="list-group-item" onclick="addList(this, '이순신');">이순신</li>
							<li class="list-group-item" onclick="addList(this, '류관순');">류관순</li>
							<!-- 사용자와 상호작용되어야하는 부분 -->
						</ul>
					</div>
				</div>
				<div class="col-4 offset-2 text-center">
					<div class="card">
						<div class="card-header">참가자 리스트</div>
						<ul class="list-group" id="emp-list"><!-- 적용이 되어야하는 부분 --></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	function getTextContent() {
		//HTML Document객체에서 id가 "text-content-1"인 엘리먼트(태그를 표현하는 객체) 객체를 찾아서 변수 el에 대입한다.
		var el =  document.getElementById("text-content-1");	//엘리먼트가 얻어진다.
		console.log("조회된 엘리먼트 -> ", el);
	
		//el변수에 저장된 엘리먼트객체의 textContent프라퍼티가 가지고 있는 텍스트 컨텐츠를 변수 content에 대입한다. 
		var content = el.textContent;
		console.log("조회된 엘리먼트의 텍스트 컨텐츠 -> ",content);
	}
	
	function changeTextContent() {
		var el = document.getElementById("text-content-2");
		el.textContent = "점심먹고 합시다.";
	}
	
	function getHtmlContent() {
		var el = document.getElementById("box-1");
		var html = el.innerHTML;	//박스안에 들은걸 조회하는 것이 innerHTML이다. 
		console.log(html);
	}

	function changeHtmlContent() {
		var srcEL = document.getElementById("box-1");
		//box-1에 작성된 내용을가져온다. 
		var destEL = document.querySelector("#box-2");
		//box-2의 영역을 가져온다. 
		
		var html =srcEL.innerHTML;
		destEL.innerHTML = html;
	}
	
	function addList(src, name) {	//같은 값이 들어가면 입력이 안되도록 만든다. this를 입력한다.
		//클릭한 엘리먼트가 onclick 이벤트 발생시 아무일도 일어나지 않게 한다. 
		src.onclick = null;	//this가 등록되어있다면 null을 보내서 초기화 시킨다.
		//html 컨텐츠를 생성한다. 
		var item = '<li class="list-group-item">'+name+'</li>';
		//생성된 html컨텐츠를 반영할 엘리먼트를 조회한다.
		var el = document.getElementById("emp-list");	//id에 있는 값을 가져오고,
		
		//엘리먼트의 html컨텐츠에 생성된 html컨텐츠를 추가한다. 
		//el.innerHTML = el.innerHTML + item;
		el.innerHTML += item;	//+=원래꺼에 가져다가 붙이는 것임 이어붙이다. 
		//동일한 사람이 반복해서 들어간다. 그러나 복사하는것이 목적이기 때문에 입력한다. 
		//el.appendChild(); -->이 방식은 엘리먼트를 넣는다. 
	}
</script>
</body>
</html>