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
				<h1>상품 리스트<button class="btn btn-primary btn-sm float-end mt-3" id="btn-load-products">데이터 불러오기</button></h1>
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <script type="text/javascript">
 	/*
 		$.ajax({
 			type: 'GET' or 'POST',							//요청방식
 			url: '요청URL',									//요청URL
 			data: {no:14, page:1} or "no=14$page=1",		//서버로 보내는 데이터
 			contentType: 'application/json'	or 'text/xml',	//서버로 보내는 데이터의 컨텐츠타입, 기본값	"application/x-www-form-urlencoded"							
 			dataType: 'text' or 'json' or 'xml' or 'jsonp',	//서버로부터 응답으로 받을 것으로 예상되는 컨텐츠 타입을 지정한다. 
 			success: function(responseData) {				//서버로부터 성공적인 응답이 왔을 때 실행되는 함수다.
 				
 			},
 			error: function(){								//서버로 보낸 요청이 실패했을 때 실행되는 함수다.
 				
 			}
 		})
 	*/
 	$("#btn-load-products").click(function(){
 		//서버랑 HTTP통신해서 데이터 받아와서 표현하기
 		$.ajax({
 			type:'GET',
 			url:'/script2/product/list.hta',
 			dataType:'json',
 			success:function(products) {
 				var $tbody = $('#table-products tbody');
 				$.each(products,function(index, product){
 					var row = "<tr>";
 		 			row += "<td>"+product.no+"</td>";
 		 			row += "<td>"+product.name+"</td>";
 		 			row += "<td>"+product.company+"</td>";
 		 			row += "<td>"+product.price.toLocaleString()+" 원</td>";
 		 			row += "<td><strong>"+product.discountPrice.toLocaleString()+"원</strong></td>";
 		 			row += "</tr>";
 		 			
 		 			$tbody.append(row);
 				})
 			}
 		});//ajax에게 객체를 전달해주는 것이다. 필요한 부분만 작성하면 된다.
 	})
 </script>
</body>
</html>