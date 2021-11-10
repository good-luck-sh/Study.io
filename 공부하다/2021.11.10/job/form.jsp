<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="register.jsp">
	<div>
		<label>직종 아이디</label>
		<input type="text" name="id"/>	
		
	</div>
	<div>
		<label>직종 제목</label>
		<input type="text" name="title"/>
	</div>
	<div>
		<label>최소 급여</label>
		<input type="number" name="min" min="0"/>
	</div>
	<div>
		<label>최대 급여</label>
		<input type="number" name="max"min="0"/>
	</div>
	<div>
		<button type="submit">등록</button>
	</div>
	
	</form>
	<div class="text-right">
	<a href="main.jsp">되돌아가기</a>
	</div>
</body>
</html>