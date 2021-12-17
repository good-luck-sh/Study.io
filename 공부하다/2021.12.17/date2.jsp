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
	<div class="row">
		<div class="col">
			<div class="mb-3 p-3" id="date-button-group">
				<button class="btn btn-outline-secondary btn-sm active" onclick="set1Week()" id="btn-1-week">1주일</button>
				<button class="btn btn-outline-secondary btn-sm" onclick="set1Months()" id="btn-1-month">1달</button>
				<button class="btn btn-outline-secondary btn-sm" onclick="set3Months()" id="btn-3-month">3개월</button>
			</div>
			<div class="mb-3">
				<input type="date" id="from-date"> ~ <input type="date" id="end-date" name="end" readonly="readonly">
			</div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/moment@2.29.1/moment.min.js"></script>
<script type="text/javascript">
	var from = document.getElementById("from-date");
	var end = document.getElementById("end-date");
	/*
		<button class="btn btn-outline-secondary btn-sm active" onclick="changeFromToEnd(-1,'w','btn-1-week')" id="btn-1-week">1주일</button>
		<button class="btn btn-outline-secondary btn-sm" onclick="changeFromToEnd(-1,'m','btn-1-months')" id="btn-1-month">1달</button>
		<button class="btn btn-outline-secondary btn-sm" onclick="changeFromToEnd(-3,'m','btn-3-months')" id="btn-3-month">3개월</button>
	*/
	/*
	function changeFromToEnd(number, type, id) {
		from.value = moment().add(number, type).format("YYYY-MM-DD");
		end.value = moment().format("YYYY-MM-DD");
		clearActiveDateButton();
		document.getElementById(id).classList.add('active');
	}
	
	changeFromToEnd(-1,'w','btn-1-week');
	이렇게 하나로 만들어서 코드를 간결하게 만드는 것을 리펙토링이라고 한다. 
	사용성이 좋아지고, 호환성이 좋아지고, 코드가 간결하게 만드는 것을 리펙토링이라고한다.
*/
 	
	function set1Week(){
		from.value = moment().add(-1,'w').format("YYYY-MM-DD");
		end.value = moment().format("YYYY-MM-DD");
		clearActiveDateButton();
		document.getElementById("btn-1-week").classList.add('active')
	}
	function set1Months(){
		from.value = moment().add(-1,'M').format("YYYY-MM-DD");
		end.value = moment().format("YYYY-MM-DD");
		clearActiveDateButton();
		document.getElementById("btn-1-month").classList.add('active')
	}
	function set3Months(){
		from.value = moment().add(-3,'M').format("YYYY-MM-DD");
		end.value = moment().format("YYYY-MM-DD");
		clearActiveDateButton();
		//전체적으로 삭제 후 
		document.getElementById("btn-3-month").classList.add('active')
		//해당하는 아이디의 엘리먼트를 active를 클래스에 넣는다. 
	}
	
	
	
	function clearActiveDateButton(){
		var buttons = document.querySelectorAll("#date-button-group button");
		//아이디가 date-button-group에서 button을 싹다 가져오도록 함
		buttons.forEach(button => button.classList.remove('active'));
		//버튼클래스에 있는 active의 글자를 없애달라고작성함
	}
	set1Week();
</script>
</body>
</html>