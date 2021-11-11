<%@page import="com.sample.vo.Location"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.LocationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
<title>부서정보 관리::입력폼</title>
</head>
<body>
<%
	LocationDao locationDao = new LocationDao();
	List<Location> locationList = locationDao.getAllLocations();
	
%>
	<h1>새 부서 등록폼</h1>
	
	<div>
		<form class="well" method="post" action="register.jsp">
			<div class="form-group">
				<label>부서이름</label>
				<input type="text" name="name"/>
			</div>
			<div class="form-group">
				<label>부서 소재지</label>
				<select name="locationId">
<%
	for(Location loc : locationList) {
		//셀렉트박스로 사용하는 방법
%>

					<option value="<%=loc.getId() %>"><%=loc.getCity() %>(<%=loc.getCountryId()%>)</option>
<% 		
	}
%>				
				</select>
			</div>
			<div class="text-right">
				<input class="btn" type="submit" value="등록"/>
				<!-- 
					<form>태그 안에서 사용가능한 버튼
					<input type="submit" value="등록"/>		: form의 입력값을 서버로 제출시킨다. 
					<button>등록</button>						: form의 입력값을 서버로 제출시킨다.
					<button type="submit">등록</button>		: form의 입력값을 서버로 제출시킨다.
					<button type="button">등록</button>		: form의 입력값을 서버로 제출시키지 않는다.
				 -->
			</div>
		</form>
	</div>
</body>
</html>