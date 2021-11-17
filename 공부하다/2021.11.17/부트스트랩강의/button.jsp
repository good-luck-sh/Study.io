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
<div class ="contatiner">
	<h1>버튼</h1>
	<h3>버튼</h3>
	<div>
		<button class="btn btn-primatry">버튼</button>
		<!-- 파란색 : 중요한 기능 -->
		<button class="btn btn-secondary">버튼</button>
		<!-- 짙은 회색 : 취소버튼 -->
		<button class="btn btn-success">버튼</button>
		<button class="btn btn-warning">버튼</button>
		<button class="btn btn-danger">버튼</button>
		<button class="btn btn-info">버튼</button>
		<button class="btn btn-light">버튼</button>
		<button class="btn btn-dark">버튼</button>
		<button class="btn btn-link">버튼</button>
		<button>버튼</button>
		<!-- 기본모양의 버튼 -->
	</div>
	<hr>
	<div>
	<h3>다양한 태그에 버튼 적용하기 </h3>
		<a href="" class="btn btn-primary">링크</a>
		<!-- 링크출력하고 버튼모양으로 보이게 만드는 것  -->
		<input type="button" class="btn btn-primary" value="버튼" />
		<input type="reset" class="btn btn-primary" value="리셋버튼" />
		<input type="submit" class="btn btn-primary" value="제출버튼" />
	</div>
	<hr>
	<h3>테두리가 있는 버튼</h3>
	<div>
		<button class="btn btn-outline-primatry">버튼</button>
		<!-- 파란색 : 중요한 기능 -->
		<button class="btn btn-outline-secondary">버튼</button>
		<!-- 짙은 회색 : 취소버튼 -->
		<button class="btn btn-outline-success">버튼</button>
		<button class="btn btn-outline-warning">버튼</button>
		<button class="btn btn-outline-danger">버튼</button>
		<button class="btn btn-outline-info">버튼</button>
		<button class="btn btn-outline-light">버튼</button>
		<button class="btn btn-outline-dark">버튼</button>
		<button class="btn btn-outline-link">버튼</button>
		<!-- 마우스 over되었을때 색상이 표시되게 된다.  -->
	</div>
	<hr>
	<h3>크기가 서로 다른 버튼</h3>
	<div>
		<button class="btn btn-primary btn-lg">버튼</button>
		<button class="btn btn-primary">버튼</button>
		<button class="btn btn-primary btn-sm">버튼</button>
	</div>
	<hr>
	<h3>비활성화된 버튼</h3>
	<div>
		<button class="btn btn-primatry disabled">버튼</button>
		<!-- 파란색 : 중요한 기능 -->
		<button class="btn btn-secondary disabled">버튼</button>
		<!-- 짙은 회색 : 취소버튼 -->
		<button class="btn btn-success disabled">버튼</button>
		<button class="btn btn-warning disabled">버튼</button>
		<button class="btn btn-danger disabled">버튼</button>
		<button class="btn btn-info disabled">버튼</button>
		<button class="btn btn-light disabled">버튼</button>
		<button class="btn btn-dark disabled">버튼</button>
		<button class="btn btn-link disabled">버튼</button>
	</div>
	<hr>
	<h3>정렬된 버튼</h3>
	<div class="text-start">
		<button class="btn btn-outline-primary">버튼</button>
	</div>
	<div class="text-center">
		<button class="btn btn-outline-primary">버튼</button>
	</div>
	<div class="text-end">
		<button class="btn btn-outline-primary">버튼</button>
	</div>
	<hr>
	<h3>블록 버튼</h3>
	<div class="d-grid gap-2">
	<!-- gap은 사이의 간격을 의미한다.  -->
		<button class="btn btn-primary">버튼</button>
		<button class="btn btn-primary">버튼</button>
	</div>
	
	<hr>
	
	<h3>버튼 그룹</h3>
	<div class="btn-group">
		<button class="btn btn-outline-danger">구글</button>
		<button class="btn btn-outline-danger">애플</button>
		<button class="btn btn-outline-danger">아마존</button>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>