<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 등록 폼</title>
<style type="text/css">
	form {
		padding: 15px;
		background-color: #eee;
		border: 1px solid #ddd;
	}
	.form-group {
		margin: 20px 10px;
	}
	.form-group label {
		display: block;
		width: 200px;
		font-weight: bold;
		margin-bottom: 5px;
	}
	.form-group input[type=text], input[type=number], .form-group select {
		height: 30px;
		width: 95%;
	}
	.form-group button {
		padding: 10px 20px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<h1>상품정보 등록 폼</h1>
	
	<form method="post" action="insert.jsp">
		<div class="form-group">
			<label>상품이름</label>
			<input type="text" name="name" />
		</div>
		<div class="form-group">
			<label>제조회사</label>
			<select name="maker">
				<option value="애플"> 애플</option>
				<option value="삼성"> 삼성전자</option>
				<option value="LG"> LG전자</option>
				<option value="소니"> 소니</option>
				<option value="샤오미"> 샤오미</option>
			</select>
		</div>
		<div class="form-group">
			<label>가격</label>
			<input type="number" name="price" />
		</div>
		<div class="form-group">
			<label>할인가격</label>
			<input type="number" name="discountPrice" />			
		</div>
		<div class="form-group">
			<label>입고량</label>
			<input type="number" name="stock" />
		</div>
		<div class="form-group">
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>