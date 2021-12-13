<%@page import="kr.co.jhta.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- lib에있는 태그를 사용하겠다는 지시어이다. include 지시어와 동일한 지시어이다. -->
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
</head>
<body>
<div class ="container">
	<div class="row mb-3">
		<div class="col">
			<h1>홈</h1>
			<p>${message }</p><!-- EL 표현식 : 값을 표현만 할 수 있다. 별도의라이브러리가 필요없다. JSP에 속해있다.  -->
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>최신 게시글</h3>
		</div>	
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
				<!-- for(변수명:배열/콜렉션)  변수명이 x이고 배열을 두는 것이 item이다. -->
				<c:forEach var="x" items="${boardList }"><!-- for문이다.스클립트을 적을 필요가없다. 이질적이지 않다.-->
					<tr>
						<td>${x.no }</td>
						<td>${x.title }</td>
						<td>${x.writer }</td>
						<td>${x.createdDate }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
	<div class="row mb-3">
		<div class="col">
			<h3>최신 게시글</h3>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
<%
	//리스트이기 때문에 이런 모습으로 출력이된다. 
	List<Board> boardList = (List<Board>)request.getAttribute("boardList");
	for(Board board : boardList) {
%>
					<tr>
						<td><%=board.getNo() %></td>
						<td><%=board.getTitle() %></td>
						<td><%=board.getWriter() %></td>
						<td><%=board.getCreatedDate() %></td>
					</tr>
<%
	}
%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> 
</body>
</html>