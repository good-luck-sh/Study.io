<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>폼 샘플::다이나믹 폼</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="container mb-3">    
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">부트스트랩 다이나믹 폼</h1>
		</div>
	</div>
	<div class='row mb-3'>
		<div class="col">
			<form class="border bg-light p-3">
				<div class="row g-3 mb-3">
					<div class="col-6">
						<label class="form-label">상품명</label>
						<input type="text" class="form-control" name="name" />
					</div>
					<div class="col-6">
						<label class="form-label">제조회사</label>
						<input type="text" class="form-control" name="maker" />
					</div>
					<div class="col-6">
						<label class="form-label">가격</label>
						<input type="number" class="form-control" name="price" />
					</div>
					<div class="col-6">
						<label class="form-label">할인가격</label>
						<input type="number" class="form-control" name="discountPrice" />
					</div>
					<div class="col-4">
						<label class="form-label">색상</label>
						<input type="text" class="form-control" name="color" />
					</div>
					<div class="col-4">
						<label class="form-label">사이즈</label>
						<input type="text" class="form-control" name="size" />
					</div>
					<div class="col-3">
						<label class="form-label">입고량</label>
						<input type="text" class="form-control" name="amount" />
					</div>
					<div class="col-1 d-flex align-items-end justify-content-end mb-1">
						<button type="button" class="btn btn-outline-primary btn-sm" onclick="addItemField()">추가</button>
					</div>
				</div>
				<!--  
					폼 입력요소가 추가될 div 엘리먼트
				-->
				<div class="row g-3 mb-3" id="item-box"></div>
				<div class="row">
					<div class="col-12 text-end">
						<button type="submit" class="btn btn-primary">등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

	// html 태그 템플릿을 정의한다.
	var template = `
		<div class="col-4" id="color-index">
			<input type="text" class="form-control" name="color" />
		</div>
		<div class="col-4" id="size-index">
			<input type="text" class="form-control" name="size" />
		</div>
		<div class="col-3" id="amount-index">
			<input type="text" class="form-control" name="amount" />
		</div>
		<div class="col-1 d-flex align-items-end justify-content-end mb-1 " id="button-index">
			<button type="button" class="btn btn-outline-danger btn-sm " onclick="removeItemField(index)">삭제</button>
		</div>`;
	
	// 템플릿을 식별하는 아이디 생성에 사용되는 값
	var count = 100;
	// 템플릿이 추가될 엘리먼트를 조회
	var box = document.getElementById("item-box");
	
	// 추가버튼을 클릭했을 때 실행되는 함수
	function addItemField() {
		// 템플릿에서 index를 전부 찾아서 count변수의 값으로 변경한다.
		// <div class="col-4" id="color-index"> -> <div class="col-4" id="color-100">
		var content = template.replace(/index/g, count);
		
		// 템플릿을 box가 가르키는 엘리먼트에 추가한다.
		box.innerHTML += content;
		
		count++;
	}
	
	// 삭제버튼을 클릭했을 때 실행되는 함수
	function removeItemField(no) {
		document.getElementById("color-" + no).remove();
		document.getElementById("size-" + no).remove();
		document.getElementById("amount-" + no).remove();
		document.getElementById("button-" + no).remove();
	}

	
</script>
</body>
</html>