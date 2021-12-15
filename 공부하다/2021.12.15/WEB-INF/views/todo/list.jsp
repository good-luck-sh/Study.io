<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>일정 목록</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">    
	<div class="row mb-3">
		<div class="col">
			<h1 class="fs-5 border p-3 shadow-sm">일정 목록</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table">
				<thead>
					<tr>
						<th style="width: 7%;">번호</th>
						<th style="width: 15%;">카테고리</th>
						<th style="width: 45%;">제목</th>
						<th style="width: 13%;">처리예정일</th>
						<th style="width: 10%;">상태</th>
						<th style="width: 10%;">작성자</th>
					</tr>
				</thead>
				<tbody>
				<%--
					요청객체에 속성으로 저장된 일정 목록을 <c:forEach /> 태그를 이용해서 출력한다. 
					<c:forEach var="변수명" items="${표현식}">
					
					</c:forEach>
				 --%>
				<c:forEach var="todo" items="${todoList }">
					<tr>
						<td>${todo.no }</td>
						<td>${todo.categoryNo }</td>
						<td><a href="detail.hta?no=${todo.no }&page=${pagin.page }"><c:out value="${todo.title }" /></a></td>
						<td><fmt:formatDate value="${todo.dueDate }" pattern="yyyy년 M월 d일"/></td>
						<td>${todo.statusTitle }</td>
						<td>${todo.userName }</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col">
		<%--
			Pagination객체는 이전/다음 블록존재여부(existPrev,existNext), 이전페이지번호(prev), 다음 페이지번호(next)
			현재 블록의 시작페이지번호(begin), 끝 페이지 번호(end)를 제공한다. 
		 --%>
			<ul class="pagination justify-content-center">
				<li class="page-item ${pagin.existPrev ? '' : 'disabled' }"><a href="list.hta?page=${pagin.prev }" class="page-link">이전</a></li>
				<c:forEach var="num" begin="${pagin.begin }" end="${pagin.end }">
				<li class="page-item ${num eq pagin.page } ? 'active' : '' "><a href="list.hta?page=${num }" class="page-link">${num }</a></li>
				</c:forEach>
				<li class="page-item ${pagin.existNext ? '' : 'disabled' }""><a href="list.hta?page=${pagin.next }" class="page-link">다음</a></li>
			</ul>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>