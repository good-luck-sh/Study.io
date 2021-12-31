<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 등록</title>
</head>
<body>
	<h1>신규 직원 등록 폼</h1>
	<form method="post" action="insert.do" style="width: 70%; margin: 5%">
		<div style="margin-bottom: 10px;">
			<label style="display:black;">First Name</label>
			<input type="text" name="firstName" style="width:100%; height: 30px;"/>
		</div>
		<div style="margin-bottom: 10px;">
			<label style="display:black;">Last Name</label>
			<input type="text" name="lastName" style="width:100%; height: 30px;"/>
		</div>
		<div style="margin-bottom: 10px;">
			<label style="display:black;">Phone Number</label>
			<input type="text" name="phoneNumber" style="width:100%; height: 30px;"/>
		</div>
		<div style="margin-bottom: 10px;">
			<label style="display:black;">Email</label>
			<input type="text" name="email" style="width:100%; height: 30px;"/>
		</div>
		<div style="margin-bottom: 10px; text-align: right;">
			<button type="submit" style="padding: 10px">등록</button>
		</div>
	</form>
</body>
</html>