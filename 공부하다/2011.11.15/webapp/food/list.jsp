<%@page import="vo.Food"%>
<%@page import="vo.Category"%>
<%@page import="java.util.List"%>
<%@page import="service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>식품 판매 프로그램</title>
</head>
<body>

<div class="container">
<%@ include file="../common/navigation.jsp" %>
<%
	//food.jsp로 요청되는 경우와 food.jsp?catNo=3000으로 요청되는 2가지 요청을 처리하는 jsp다.
	String tempCategoryNo = request.getParameter("catNo");

	AdminService service = AdminService.getInstance();
	
	List<Food> foods = List.of();
	//위에서 선언한 경우는 괄호가 끝나면 사라지기 때문이다.
	//비어있는 list를 하나 만들다. 
	//만약 tempcategory가 null이면 전체적인 음식을 호출한다.		food.jsp 요청인 경우 
	if (tempCategoryNo == null) {
		foods = service.getAllFoods();
		//전체 카테고리를 표현한다. 
	} else {
		//만약 null이아니라면 카테고리가 요청된 부분이기 때문에 		food.jsp?catNo=카테고리번호 요청인 경우 
		int categoryNo = Integer.parseInt(tempCategoryNo);
		foods = service.getFoodsByCategory(categoryNo);
		//변환을 준다. 
		//카테고리에 해당하는 식품을 출력한다. 
	}

%>
	<div class="row">
		<div class="col">
			<div class="card">
				<div class="card-header">식품 목록</div>
				<div class="card-body">
					<table class="table">
						<colgroup>
							<col width="15%">
							<col width="20%">
							<col width="*%">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th>식품번호</th>
								<th>카테고리</th>
								<th>식품명</th>
								<th>가격</th>
								<th>판매여부</th>
							</tr>
						</thead>
						<tbody>
<%
	for (Food food : foods) {
%>
							<tr>
								<td><%=food.getNo() %></td>
								<td><%=food.getCategory().getName() %></td>
								<td><a href="detail.jsp?foodNo=<%=food.getNo()%>"><%=food.getName() %></a></td>
								<td><%=food.getPrice() %></td>
								<td><%=food.getOnSale() %></td>
							</tr>
<%
	}
%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>