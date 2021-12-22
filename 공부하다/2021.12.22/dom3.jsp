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
			<h1>엘리먼트 추가하기</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<div class="mb-3">
				<button class="btn btn-outline-dark btn-sm" id="btn-append">append</button>
				<button class="btn btn-outline-dark btn-sm" id="btn-prepend">prepend</button>
				<button class="btn btn-outline-dark btn-sm" id="btn-before">before</button>
				<button class="btn btn-outline-dark btn-sm" id="btn-after">after</button>
			</div>
			<div class="p-3 border">
				<div class="p-3 border" id="box">
					<p>내용입니다.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<label>월</label>
			<select id="select-months"></select>		
			<label>일</label>
			<select id="select-dates">
				<option value="" selected disabled>월을 먼저 선택하세요</option>
			</select>		
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
 	//append를 가장 많이 사용한다.
 	$("#btn-append").click(function(){
 		$("#box").append("<p>append로 추가된 내용입니다. </p>")
 	})
 	$("#btn-prepend").click(function(){
 		$("#box").prepend("<p>prepend로 추가된 내용입니다. </p>")
 	})
 	$("#btn-before").click(function(){
 		$("#box").before("<p>before로 추가된 내용입니다. </p>")
 	})
 	$("#btn-after").click(function(){
 		$("#box").after("<p>after로 추가된 내용입니다. </p>")
 	})
 	
 	//월을 선택하면 자동으로 해달 월에 맞는 날짜들이 추가되게 하기 
 	//월별 마지막날을 나타내는 배열이다.
 	var dates = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
 	//월과 날을 표시하는 select엘리먼트를 미리 검색해둔다.
 	var $months = $("#select-months");
 	var $dates = $("#select-dates");
 	//검색이 자주 일어나니까 미리 변수에 담아둔다.
 	//월을 표시하는 select 엘리먼트가 변경될 때마다 실행되는 이벤트 핸들러 함수를 등록한다.
 	$months.append('<option value="" selected disabled>선택하세요</option>')
 	for(var i = 1; i<=12; i++) {
 		var option = '<option value="'+i+'">'+i+'월</option>';
 		$months.append(option);
 		//자식으로 뒤에 포함한다.
 	}
 	//월에서 선택한 항목이 변경될 때마다 실행되는 이벤트 핸들러 함수를 등록한다.
 	$months.change(function(){//월이 바뀔때마다 실행된다.
 		//날을 표시하는 select엘리먼트내의 모든 option엘리먼트를 삭제한다.
 		$dates.empty();//비워버린다.
 		//월을 표시하는 select엘리먼트내에서 현재 선택된 값을 조회한다.
 		var month =	$(this).val();
 		//현재 선택된 월에 맞는 날짜가 포함된 옵션을 배열의 값을 참고해서 추가한다.
 		for(var i = 1; i<=dates[month-1]; i++) {	//month가 1월이면 1-1로 인덱스 0을 찾는다.
 	 		var option = '<option value="'+i+'">'+i+'일</option>';
 	 		$dates.append(option);
 	 		//윤달은 4년에 1번으로 function을 넣으면 된다.
 	 		//append는 계속 쌓인다.  --->append와 empty와 함께 사용된다.
 	 	}
 	
 	});
 </script>
</body>
</html>