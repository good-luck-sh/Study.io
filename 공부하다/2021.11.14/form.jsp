<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<title>게시판::등록폼</title>
</head>
<body>
<div id="wrapper">
	<ul class="nav">
 		<li><a href="/sample/board/list.jsp?cpno=1">홈</a></li>
 		<li><a class="active" href="/sample/board/form.jsp">새 글</a></li>
	</ul>

	<h1>게시글 작성폼</h1>
	
	<div>
		<form class="well" method="post" action="register.jsp">
			<div class="form-group">
				<label>제목</label>
				<input type="text" name="title" />
			</div>
			<div class="form-group">
				<label>작성자</label>
				<input type="text" name="writer" />
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea rows="10" name="content"></textarea>
			</div>
			<div class="text-right">
				<button class="btn default" type="submit">등록</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>