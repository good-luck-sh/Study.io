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
				<tbody>

				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
/*
	자바스크립트에서 서버로 HTTP통신하기 
	$.getJSON(url,함수)
		url : 클라이언트의 요청을 처리하는 웹애플리케이션의 URL
		함수 : 서버가 클라이언트의 요청을 처리하고, 응답데이터를 내려보내면 실행되는 함수다.
		function(data){...}
		* data에는 서버가 내려보낸 데이터가 전달된다.
		* jQuery는 서버가 json텍스트를 내려보내면 자바스크립트 객체나 배열로 변환한 후 data에 전달해준다.
		JSON.parse를 실행할 필요도 없다.
		
*/
	
	$.getJSON("/script2/product/list.hta", function(data){
		var htmlContent= "";
		data.forEach((product)=>{
			
			htmlContent += "<tr>";
			htmlContent += "<td>"+product.no+"</td>";
			htmlContent += "<td>"+product.name+"</td>";
			htmlContent += "<td>"+product.company+"</td>";
			htmlContent += "<td>"+product.price+"</td>";
			htmlContent += "<td>"+product.discountPrice+"</td>";
			htmlContent += "</tr>";
		})
		document.querySelector("#table-products tbody").innerHTML = htmlContent;
		//tbody에 html을 넣겠다.
		//데이터를 저장하지 않고 붙여서 출력할 수 있다.
	}) 
</script>
</body>
</html>