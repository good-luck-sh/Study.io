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
			<h1>상품 리스트</h1>
		</div>
	</div>
	<div class="row mb-2">
		<div class="col text-end">
			<button class="btn btn-primary" onclick="runAjax()">조회</button>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table" id="table-products">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>제조회사</th>
						<th>가격</th>
						<th>할인가격</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script type="text/javascript">
	//XMLHttpReqest로 웹서버와 비동기식 통신하기
	function runAjax(){
		console.log("runAjax 실행");
		
		//서버와 비동기식 통신 시작 
		//1.XMLHttpRequest 객체 
		var xhr = new XMLHttpRequest();
		console.log("XMLHttpRequest객체 생성");
		
		//2.XMLHttpRequest객체의 상태가 변할 때마다 실행할 메소드 등록
		xhr.onreadystatechange = function(){
			console.log("XMLHttpRequest의 상태",xhr.readyState);
			if(xhr.readyState == 4 && xhr.status == 200){
				//5. XMLHttpRequest의 responseText 프로퍼티에 저장된 응답데이터를 가져오기 
				var jsonText = xhr.responseText;
				console.log("응답데이터", jsonText);
				//6. jsonText를 자바스크립트 객체/ 배열로 변환하기 
				var products = JSON.parse(jsonText);
				console.log("응답데이터",products);
				
				//7.응답 데이터로 HTML 컨텐츠를 생성하기
				var htmlContent="";
				products.forEach(item => {
					htmlContent+= "<tr>";
					htmlContent+= "<td>"+item.no+"</td>";
					htmlContent+= "<td>"+item.name+"</td>";
					htmlContent+= "<td>"+item.company+"</td>";
					htmlContent+= "<td>"+item.price+"</td>";
					htmlContent+= "<td>"+item.discountPrice+"</td>";
					htmlContent+= "<tr>";
				});
				// 8.생성된 HTML컨텐츠를 화면의 특정부분에 추가한다.
				var tbody = document.querySelector("#table-products tbody");
				tbody.innerHTML = htmlContent;
			}
		};
		
		//3.XMLHttpRequest객체 초기화
		xhr.open("GET","/script2/product/list.hta");
		console.log("XMLHttpRequest 객체 초기화");
		
		//4. 웹서버로 요청 보내기 
		xhr.send();
		console.log("웹서버로 요청보내기");
	}
</script>
</body>
</html>