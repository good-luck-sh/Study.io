
<%@page import="java.util.Date"%>
<%@page import="com.sample.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	<h1>상품 상세정보</h1>
<%
//자바코딩은 이제 여기에서 진행하면 된다 만든 객체를 import시킨다
	Product product = new Product(1001, "갤럭시Z 플립3", "삼성전자", 1500000, 1250000, 10, "판매중", new Date());

%>
	
	<table>
	<tbody>
	<tr>
		<th>상품번호</th>
		<td><%=product.getNo() %></td>
		<th>등록일자</th>
		<td><%=product.getCreatedDate() %></td>	
	</tr>
	<tr>
		<th>상품명</th>
		<td><%=product.getName() %></td>
		<th>제조회사</th>
		<td><%=product.getMaker() %></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><%=product.getPrice() %></td>
		<th>할인 가격</th>
		<td><%=product.getDiscountPrice() %></td>
	</tr>
	<tr>
		<th>재고현황</th>
		<td><%=product.getStock() %></td>
		<th>판매상태</th>
		<td><%=product.getOnSale() %></td>
	</tr>
	</tbody>
	</table>
</body>
</html>