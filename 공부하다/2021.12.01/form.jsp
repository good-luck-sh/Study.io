<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title></title>
</head>
<body>
<div class="container">    
	<div class="row">
		<div class="col">
			<h1>파일 업로드 폼</h1>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<!--  
				파일을 업로드하는 폼
					- method는 반드시 post로 지정한다.
					- enctype을 반드시 multipart/form-data로 지정한다.
						* enctype는 폼입력값을 어떤 형식으로 서버로 전달할지 지정하는 속성이다.
						* enctype을 지정하지 않으면 enctype="application/x-www-form-urlencoded" 기본값이다.
						
						* enctype="application/x-www-form-urlencoded"
							- 폼 입력값을 쿼리스트링과 같은 형식으로 만들어서 서버로 보낸다.
							- 폼 입력값이 서버로 전달되는 형식
								name=아이폰13&maker=애플&price=1500000
							- 첨부파일을 서버로 전달할 수 없다.
							
						* enctype="multipart/form-data" 
							- 폼에 첨부파일 입력요소가 있을때만 사용한다.
							- 첨부파일을 서버로 전달할 수 있다.
							- 폼 입력값이 서버로 전달되는 형식
								----WebKitFormBoundarysPooMmIoapwC08Wg
								name="name"						iphone
								----WebKitFormBoundarysPooMmIoapwC08Wg
								
								----WebKitFormBoundarysPooMmIoapwC08Wg
								
								----WebKitFormBoundarysPooMmIoapwC08Wg
							
							
							
			-->
			<form class="board p-3 bg-light" method="post" action="register.jsp" enctype="multipart/form-data">
				<div class="mb-3">
					<label class="form-label">상품이름</label>
					<input type="text" class="form-control" name="name">
				</div>
				<div class="mb-3">
					<label class="form-label">제조사</label>
					<input type="text" class="form-control" name="maker">
				</div>
				<div class="mb-3">
					<label class="form-label">가격</label>
					<input type="text" class="form-control" name="price">
				</div>
				<div class="mb-3">
					<label class="form-label">이미지파일</label>
					<input type="file" class="form-control" name="imagefile1">
				</div>
				<div class="mb-3">
					<label class="form-label">이미지파일</label>
					<input type="file" class="form-control" name="imagefile2">
				</div>
				<div class="mb-3">
					<label class="form-label">이미지파일</label>
					<input type="file" class="form-control" name="imagefile3">
				</div>
				<div class="mb-3 text-end">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>