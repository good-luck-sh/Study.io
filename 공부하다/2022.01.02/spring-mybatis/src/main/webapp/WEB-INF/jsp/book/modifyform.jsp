<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title></title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row mb-3">
		<div class="col">
			<h1>도서 수정 폼</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<p>책정보를 수정하세요</p>
			<form id="form-update-book" class="border bg-light p-3" method="get" action="updatePrice.do">
				<input type="hidden" name="no" value="${book.no }" />
				<div class="mb-3">
					<label class="form-label">제목</label>
					<input type="text" class="form-control" name="title" value="${book.title }" disabled="disabled"/>
				</div>
				<div class="mb-3">
					<label class="form-label">가격</label>
					<input type="number" class="form-control" name="price" min="1000" max="1000000" value="${book.price }"/>
				</div>
				<div class="mb-3">
					<label class="form-label">할인가격</label>
					<input type="number" class="form-control" name="discountPrice" min="1000" max="1000000" value="${book.discountPrice }"/>
				</div>
				<div class="mb-3">
					<label class="form-label">입고수량</label>
					<input type="number" class="form-control" name="stock" min="1" max="100"/>
				</div>
				<div class="text-end">
					<a href="detail.do?no=책번호" class="btn btn-secondary">취소</a>
					<button type="button" class="btn btn-primary" id="btn-update-price">가격 변경</button>
					<button type="button" class="btn btn-primary" id="btn-update-stock">재고변경</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src= "https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	//가격 변경 버튼을 클릭하면 책번호, 가격, 할인가격을 읽어서 서버로 전달한다.
	//form의 action 속성값을 updatePrice.do로 변경하고 폼을 서버로 제출한다. 
	$('#btn-update-price').click(function() {
		var price = parseInt($(":input[name=price]").val());
		var discountPrice = parseInt($(":input[name=discountPrice]").val());
		if(price >= discountPrice) {
			$('#form-update-book').trigger("submit");
		} else {
			alert("입력된 가격이 올바르지 않습니다.");
		}
		//$('form .form-control:last').remove();	
		
	});
	
	//재고 변경 버튼을 클릭하면 책번호, 입고수량을 서버로 전달한다. 
	//form의 action 속성값은 updateStock.do로 변경하고 폼을 서버로 제출한다. 
	$('#btn-update-stock').click(function() {
		$('form .form-control:eq(1),.form-control:eq(2)').remove();
		$('#form-update-book').attr('action','updateStock.do').submit();
	})
</script>
</body>
</html>