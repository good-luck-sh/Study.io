<%@page import="java.util.List"%>
<%@page import="com.sample.vo.Product"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
<style type="text/css">
	table {
		width:100%;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid black;
		padding: 10px;
		text-align: left;
	}

</style>
</head>
<body>
	<h1>최신 상품 리스트</h1>
	<%
		
		List<Product> productList = List.of(new Product(10,"연필","모나미",2500,2300,10,"판매중",new Date()),
			new Product(20,"지우개","모나미",500,300,10,"판매중",new Date()),
			new Product(30,"볼펜","모나미",1500,1300,10,"판매중",new Date()),
			new Product(40,"3색볼펜","모나미",3500,3300,10,"판매중",new Date()),
			new Product(50,"만년필","모나미",10500,1000,10,"판매중",new Date()),
			new Product(60,"공책","모나미",2000,1700,10,"판매중",new Date()),
			new Product(70,"표준전과","모나미",40000,3700,10,"판매중",new Date()),
			new Product(80,"크레파스","모나미",25000,2300,10,"판매중",new Date()),
			new Product(90,"수체화 물감","모나미",35000,3200,10,"판매중",new Date()));
			//행이 9개가 나와야한다. tr와 td가 한줄
	%>
	<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>상품이름</th>
			<th>제조사</th>
			<th>가격</th>
			<th>할인가격</th>
		</tr>
	</thead>
	<tbody>
	<%
		for(Product product : productList) {
			//자바코드만 <%으로 감싸준다.
	%>
		<tr>
			<td><%=product.getNo() %></td>
			<td><%=product.getName() %></td>
			<td><%=product.getMaker() %></td>
			<td><%=product.getPrice() %></td>
			<td><%=product.getDiscountPrice() %></td>
		</tr>
		<%
			}
		%>
	</tbody>
	</table>
	<div>
		<a href="form.jsp">새 상품등록</a>
	</div>
</body>
</html>